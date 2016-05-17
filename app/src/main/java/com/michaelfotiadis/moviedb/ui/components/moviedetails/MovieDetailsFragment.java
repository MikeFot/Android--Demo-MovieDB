package com.michaelfotiadis.moviedb.ui.components.moviedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.michaelfotiadis.moviedb.ui.core.common.fragment.BaseFragment;
import com.michaelfotiadis.moviedb.utils.AppLog;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 */
public class MovieDetailsFragment extends BaseFragment {

    private static final String EXTRA = MovieDetailsFragment.class.getSimpleName() + "_extra_1";

    private static final int PAGE_INDEX_CONTENT = 0;
    private static final int PAGE_INDEX_ERROR = 1;
    private static final int PAGE_INDEX_PROGRESS = 2;

    @Bind(R.id.error_layout)
    protected View mErrorLayout;
    @Bind(R.id.view_flipper)
    protected ViewFlipper mViewFlipper;

    private QuotePageController mErrorPageController;

    private String mId;

    public static BaseFragment newInstance(final String id) {

        final BaseFragment fragment = new MovieDetailsFragment();

        final Bundle args = new Bundle();
        args.putString(EXTRA, id);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_movie_details, container, false);

        ButterKnife.bind(this, view);

        mErrorPageController = new DefaultQuotePageController(
                mErrorLayout,
                new ErrorQuotePicker(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(getActivity(),
                R.anim.quick_fade_in));
        mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(getActivity(),
                R.anim.quick_fade_out));
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mId = getArguments().getString(EXTRA);
        } else {
            getActivity().finish();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {

        final MovieDetailsLoader loader = new MovieDetailsLoader(getActivity());

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
                setResult(result.get(0));
            }
        });
        showProgress();
        AppLog.d(String.format("Requesting movie for id: %s", mId));
        loader.loadData(mId);

    }

    private void setResult(final MovieDetails movieDetails) {

        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).setTitle(movieDetails.getTitle());
        } else {
            getActivity().setTitle(movieDetails.getTitle());
        }

    }

    private void setError(final CharSequence errorMessage, final View.OnClickListener listener) {
        getActivity().runOnUiThread(new Runnable() {
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
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setViewFlipperPage(PAGE_INDEX_CONTENT);
            }
        });
    }

    private void setViewFlipperPage(final int page) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mViewFlipper.setDisplayedChild(page);
            }
        });
    }

    private void showProgress() {
        getActivity().runOnUiThread(new Runnable() {
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
