package com.michaelfotiadis.moviedb.ui.components.splash;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.common.models.configuration.Configuration;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.core.utils.NetworkUtils;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadError;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadErrorFactory;
import com.michaelfotiadis.moviedb.data.loader.ConfigurationLoader;
import com.michaelfotiadis.moviedb.data.loader.DataFeedLoaderCallback;
import com.michaelfotiadis.moviedb.ui.core.common.activity.BaseActivity;
import com.michaelfotiadis.moviedb.ui.core.common.error.errorpage.DefaultQuotePageController;
import com.michaelfotiadis.moviedb.ui.core.common.error.errorpage.QuoteOnClickListenerWrapper;
import com.michaelfotiadis.moviedb.ui.core.common.error.errorpage.QuotePageController;
import com.michaelfotiadis.moviedb.ui.core.common.error.quotes.EmptyQuotePicker;
import com.michaelfotiadis.moviedb.ui.core.common.error.quotes.ErrorQuotePicker;
import com.michaelfotiadis.moviedb.ui.core.common.error.quotes.Quote;
import com.michaelfotiadis.moviedb.utils.AppLog;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {

    private static final int PAGE_INDEX_CONTENT = 0;
    private static final int PAGE_INDEX_ERROR = 1;

    @Bind(R.id.error_layout)
    protected View mErrorLayout;
    @Bind(R.id.view_flipper)
    protected ViewFlipper mViewFlipper;
    @Bind(R.id.quote)
    protected TextView mQuote;
    @Bind(R.id.quote_author)
    protected TextView mQuoteAuthor;

    private QuotePageController mErrorPageController;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        mErrorPageController = new DefaultQuotePageController(
                mErrorLayout,
                new ErrorQuotePicker(SplashActivity.this));

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadConfiguration();
    }

    private void setQuote(final Quote quote) {
        mQuote.setText(quote.getQuote());
        mQuoteAuthor.setText(quote.getAuthor());
    }

    private void loadConfiguration() {

        setQuote(new EmptyQuotePicker(this).getQuote());
        final ConfigurationLoader loader = new ConfigurationLoader(this);

        loader.setCallback(new DataFeedLoaderCallback<Configuration>() {
            @Override
            public void onError(final UiDataLoadError error) {
                AppLog.e("Error while retrieving configuration");
                handleError(error);
            }

            @Override
            public void onSuccess(final List<Configuration> result) {
                AppLog.d("Configuration received");
                setResult(result.get(0));

                startHome();
            }
        });

        if (NetworkUtils.isConnected(this)) {
            AppLog.d("Loading configuration");
            loader.loadData();
        } else {

            final UiDataLoadError error = UiDataLoadErrorFactory.createDeviceOfflineError(this);

            setError(error.getMessage(), new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    loadConfiguration();
                }
            });
        }
    }

    private void setResult(final Configuration configuration) {
        DemoCore.getPreferenceManager().writeConfiguration(configuration);
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

    private void setViewFlipperPage(final int page) {
        SplashActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mViewFlipper.setDisplayedChild(page);
            }
        });
    }

    private void handleError(final UiDataLoadError error) {
        setError(error.getMessage(),
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        loadConfiguration();
                    }
                });
    }

    private void startHome() {
        getIntentDispatcher().openHomeActivity();
    }

}
