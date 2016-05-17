package com.michaelfotiadis.moviedb.data.loader;

import android.app.Activity;

import com.michaelfotiadis.moviedb.common.models.movies.details.MovieDetails;
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
public class MovieDetailsLoader extends DataFeedLoaderAbstract<MovieDetails> {

    public MovieDetailsLoader(final Activity activity) {
        super(activity);
    }

    public void loadData(final String id) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                // move the current Thread into the background
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);

                AppLog.d(String.format("Loading movie for id %s", id));

                DemoCore.getDataProvider().getMovieById(
                        id,
                        new CommonCallback<MovieDetails>() {
                            @Override
                            public void onFailure(final CommonError error) {
                                AppLog.e("Loader received error: " + error.getErrorMessage());
                                final UiDataLoadError uiError = UiDataLoadErrorFactory.createError(getActivity(), error);
                                notifyError(uiError);
                            }

                            @Override
                            public void onSuccess(final CommonDeliverable<MovieDetails> deliverable) {

                                final List<MovieDetails> wrapper = new ArrayList<>();
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
