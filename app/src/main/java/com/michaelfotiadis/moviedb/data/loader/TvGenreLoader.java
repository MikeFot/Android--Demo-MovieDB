package com.michaelfotiadis.moviedb.data.loader;

import android.app.Activity;

import com.michaelfotiadis.moviedb.common.models.genre.Genre;
import com.michaelfotiadis.moviedb.common.models.genre.GenreContainer;
import com.michaelfotiadis.moviedb.common.models.genre.GenreType;
import com.michaelfotiadis.moviedb.common.responses.CommonCallback;
import com.michaelfotiadis.moviedb.common.responses.CommonDeliverable;
import com.michaelfotiadis.moviedb.common.responses.CommonError;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadError;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadErrorFactory;

/**
 *
 */
public class TvGenreLoader extends DataFeedLoaderAbstract<Genre> {

    public TvGenreLoader(final Activity activity) {
        super(activity);
    }

    @Override
    public void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                // move the current Thread into the background
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);

                DemoCore.getDataProvider().getGenres(
                        GenreType.TV,
                        new CommonCallback<GenreContainer>() {
                            @Override
                            public void onFailure(final CommonError error) {
                                final UiDataLoadError uiError = UiDataLoadErrorFactory.createError(getActivity(), error);
                                notifyError(uiError);
                            }

                            @Override
                            public void onSuccess(final CommonDeliverable<GenreContainer> deliverable) {
                                notifySuccess(deliverable.getContent().getGenres());
                            }
                        });

            }
        }).start();

    }
}
