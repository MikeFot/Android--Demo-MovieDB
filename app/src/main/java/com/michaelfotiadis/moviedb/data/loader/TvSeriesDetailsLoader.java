package com.michaelfotiadis.moviedb.data.loader;

import android.app.Activity;

import com.michaelfotiadis.moviedb.common.models.tv.details.TvSeriesDetails;
import com.michaelfotiadis.moviedb.common.responses.CommonCallback;
import com.michaelfotiadis.moviedb.common.responses.CommonDeliverable;
import com.michaelfotiadis.moviedb.common.responses.CommonError;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadError;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadErrorFactory;
import com.michaelfotiadis.moviedb.utils.AppLog;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TvSeriesDetailsLoader extends DataFeedLoaderAbstract<TvSeriesDetails> {

    public TvSeriesDetailsLoader(final Activity activity) {
        super(activity);
    }

    public void loadData(final String id) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                // move the current Thread into the background
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);

                AppLog.d(String.format("Loading series for id %s", id));

                DemoCore.getDataProvider().getSeriesById(
                        id,
                        new CommonCallback<TvSeriesDetails>() {
                            @Override
                            public void onFailure(final CommonError error) {
                                AppLog.e("Loader received error: " + error.getErrorMessage());
                                final UiDataLoadError uiError = UiDataLoadErrorFactory.createError(getActivity(), error);
                                notifyError(uiError);
                            }

                            @Override
                            public void onSuccess(final CommonDeliverable<TvSeriesDetails> deliverable) {

                                final List<TvSeriesDetails> wrapper = new ArrayList<>();
                                wrapper.add(deliverable.getContent());

                                notifySuccess(wrapper);
                            }
                        });

            }
        }).start();

    }

    @Override
    public void loadData() {
        // good enough for the demo!
        throw new IllegalStateException("Use the by id method instead");
    }
}
