package com.michaelfotiadis.moviedb.data.loader;

import android.app.Activity;

import com.michaelfotiadis.moviedb.common.models.tv.TvSeries;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesContainer;
import com.michaelfotiadis.moviedb.common.responses.CommonCallback;
import com.michaelfotiadis.moviedb.common.responses.CommonDeliverable;
import com.michaelfotiadis.moviedb.common.responses.CommonError;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadError;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadErrorFactory;

/**
 *
 */
public class TvSeriesLoader extends DataFeedLoaderAbstract<TvSeries> {

    public TvSeriesLoader(final Activity activity) {
        super(activity);
    }

    @Override
    public void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                // move the current Thread into the background
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);

                DemoCore.getDataProvider().getPopularSeries(new CommonCallback<TvSeriesContainer>() {
                    @Override
                    public void onFailure(final CommonError error) {
                        final UiDataLoadError uiError = UiDataLoadErrorFactory.createError(getActivity(), error);
                        notifyError(uiError);
                    }

                    @Override
                    public void onSuccess(final CommonDeliverable<TvSeriesContainer> deliverable) {
                        notifySuccess(deliverable.getContent().getSeries());
                    }
                });

            }
        }).start();

    }
}
