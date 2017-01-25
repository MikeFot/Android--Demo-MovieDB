package com.michaelfotiadis.moviedb.ui.components.moviedetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.common.models.movies.details.MovieDetails;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadError;
import com.michaelfotiadis.moviedb.data.loader.DataFeedLoaderCallback;
import com.michaelfotiadis.moviedb.data.loader.MovieDetailsLoader;
import com.michaelfotiadis.moviedb.ui.core.common.activity.BaseActivity;
import com.michaelfotiadis.moviedb.ui.core.common.error.errorpage.DefaultQuotePageController;
import com.michaelfotiadis.moviedb.ui.core.common.error.errorpage.QuoteOnClickListenerWrapper;
import com.michaelfotiadis.moviedb.ui.core.common.error.errorpage.QuotePageController;
import com.michaelfotiadis.moviedb.ui.core.common.error.quotes.ErrorQuotePicker;
import com.michaelfotiadis.moviedb.utils.AppLog;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetailsActivity extends BaseActivity implements AppBarLayout.OnOffsetChangedListener {

    private static final String EXTRA = MovieDetailsActivity.class.getSimpleName() + "_extra_1";

    private static final int PAGE_INDEX_CONTENT = 0;
    private static final int PAGE_INDEX_ERROR = 1;
    private static final int PAGE_INDEX_PROGRESS = 2;
    private static final String FRAGMENT_TAG =
            MovieDetailsActivity.class.getSimpleName() + "_fragment_tag";
    @Bind(R.id.app_bar_layout)
    protected AppBarLayout mAppBarLayout;
    @Bind(R.id.error_layout)
    protected View mErrorLayout;
    @Bind(R.id.view_flipper)
    protected ViewFlipper mViewFlipper;
    @Bind(R.id.header_layout)
    protected View mHeaderLayout;

    private String mId;
    private QuotePageController mErrorPageController;

    public static Intent getInstance(final Context context,
                                     final String movieId) {

        final Intent intent = new Intent(context, MovieDetailsActivity.class);
        intent.putExtra(EXTRA, movieId);
        return intent;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details_movie);
        setTitle(getString(R.string.title_movie_details));

        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final String id = extras.getString(EXTRA);
            if (!TextUtils.isEmpty(id)) {
                mId = id;
                AppLog.d("Got id " + id);
                addContentFragmentIfMissing(
                        MovieDetailsFragment.newInstance(id),
                        FRAGMENT_TAG);
            }
        }


        getCustomActionBar().goTransparent();
        ButterKnife.bind(this);

        mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                R.anim.quick_fade_in));
        mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                R.anim.quick_fade_out));

        mErrorPageController = new DefaultQuotePageController(
                mErrorLayout,
                new ErrorQuotePicker(this));

    }

    private void updateUi() {
        invalidateOptionsMenu();

        // The reason why we are not using an Anon class is
        // https://code.google.com/p/android/issues/detail?id=176328
        mAppBarLayout.addOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(final AppBarLayout appBarLayout, final int offset) {
        final int maxScroll = appBarLayout.getTotalScrollRange();
        final float percentage = (float) Math.abs(offset) / (float) maxScroll;

        getCustomActionBar().setTitleAlpha(percentage);

    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {

        final MovieDetailsLoader loader = new MovieDetailsLoader(this);

        loader.setCallback(new DataFeedLoaderCallback<MovieDetails>() {
            @Override
            public void onError(final UiDataLoadError error) {
                AppLog.e("Error while retrieving movie details " + error.getMessage());
                handleError(error);
            }

            @Override
            public void onSuccess(final List<MovieDetails> result) {
                AppLog.d("Movie loaded");
                showContent();
                showResult(result.get(0));
            }
        });
        showProgress();
        AppLog.d(String.format("Requesting movie for id: %s", mId));
        loader.loadData(mId);

    }

    private void showResult(final MovieDetails movieDetails) {
        updateUi();
        setTitle(movieDetails.getTitle());

        final MovieDetailsHeaderViewHolder holder = new MovieDetailsHeaderViewHolder(mHeaderLayout);

        final MovieDetailsHeaderViewBinder binder = new MovieDetailsHeaderViewBinder(
                this,
                getImageFetcher(),
                getIntentDispatcher()
        );

        binder.bind(holder, movieDetails);

        final Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if (fragment instanceof MovieDetailsFragment) {
            ((MovieDetailsFragment) fragment).setData(movieDetails);
        }

    }

    private void setError(final CharSequence errorMessage, final View.OnClickListener listener) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setViewFlipperPage(PAGE_INDEX_ERROR);
                mErrorPageController.display(
                        errorMessage,
                        new QuoteOnClickListenerWrapper(listener));
            }
        });
    }

    private void showContent() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setViewFlipperPage(PAGE_INDEX_CONTENT);
            }
        });
    }

    private void setViewFlipperPage(final int page) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mViewFlipper.setDisplayedChild(page);
            }
        });
    }

    private void showProgress() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setViewFlipperPage(PAGE_INDEX_PROGRESS);
            }
        });
    }

    private void handleError(final UiDataLoadError error) {
        setError(error.getMessage(),
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        loadData();
                    }
                });
    }

}
