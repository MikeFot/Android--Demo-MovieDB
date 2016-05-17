package com.michaelfotiadis.moviedb.data.loader;

import android.app.Activity;

import com.michaelfotiadis.moviedb.common.models.genre.GenreContainer;
import com.michaelfotiadis.moviedb.common.models.genre.GenreType;
import com.michaelfotiadis.moviedb.common.models.movies.MoviesContainer;
import com.michaelfotiadis.moviedb.common.responses.CommonCallback;
import com.michaelfotiadis.moviedb.common.responses.CommonDeliverable;
import com.michaelfotiadis.moviedb.common.responses.CommonError;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadErrorFactory;
import com.michaelfotiadis.moviedb.data.factory.UiMovieFactory;
import com.michaelfotiadis.moviedb.data.model.UiMovie;
import com.michaelfotiadis.moviedb.utils.AppLog;

/**
 *
 */
public class UiMovieLoader extends DataFeedLoaderAbstract<UiMovie> {

    final UiMovieFactory mFactory;

    public UiMovieLoader(final Activity activity) {
        super(activity);
        mFactory = new UiMovieFactory();
    }

    @Override
    public void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                // move the current Thread into the background
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);

                loadMovies();
            }
        }).start();

    }

    private void loadMovies() {
        DemoCore.getDataProvider().getPopularMovies(new CommonCallback<MoviesContainer>() {
            @Override
            public void onFailure(final CommonError error) {
                notifyError(UiDataLoadErrorFactory.createError(getActivity(), error));
            }

            @Override
            public void onSuccess(final CommonDeliverable<MoviesContainer> deliverable) {
                AppLog.d(String.format("Loader: got %d movies", deliverable.getContent().getMovies().size()));
                mFactory.setMovies(deliverable.getContent().getMovies());
                loadGenres();
            }
        });
    }

    private void loadGenres() {
        DemoCore.getDataProvider().getGenres(GenreType.MOVIE,
                new CommonCallback<GenreContainer>() {
                    @Override
                    public void onFailure(final CommonError error) {
                        notifyError(UiDataLoadErrorFactory.createError(getActivity(), error));
                    }

                    @Override
                    public void onSuccess(final CommonDeliverable<GenreContainer> deliverable) {
                        AppLog.d(String.format("Loader: got %d genres", deliverable.getContent().getGenres().size()));
                        mFactory.setGenres(deliverable.getContent().getGenres());

                        notifySuccess(mFactory.create());
                    }
                });
    }
}
