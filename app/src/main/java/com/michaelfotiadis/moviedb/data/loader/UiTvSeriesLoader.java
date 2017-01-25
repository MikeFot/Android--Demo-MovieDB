package com.michaelfotiadis.moviedb.data.loader;

import android.app.Activity;

import com.michaelfotiadis.moviedb.common.models.genre.GenreContainer;
import com.michaelfotiadis.moviedb.common.models.genre.GenreType;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeries;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesContainer;
import com.michaelfotiadis.moviedb.common.responses.CommonCallback;
import com.michaelfotiadis.moviedb.common.responses.CommonDeliverable;
import com.michaelfotiadis.moviedb.common.responses.CommonError;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadErrorFactory;
import com.michaelfotiadis.moviedb.data.factory.UiMediaFactory;
import com.michaelfotiadis.moviedb.data.model.UiMedia;
import com.michaelfotiadis.moviedb.utils.AppLog;

import java.util.Locale;

/**
 *
 */
public class UiTvSeriesLoader extends DataFeedLoaderAbstract<UiMedia> {

    final UiMediaFactory<TvSeries> mFactory;

    public UiTvSeriesLoader(final Activity activity) {
        super(activity);
        mFactory = new UiMediaFactory<>();
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
        DemoCore.getDataProvider().getPopularSeries(new CommonCallback<TvSeriesContainer>() {
            @Override
            public void onFailure(final CommonError error) {
                notifyError(UiDataLoadErrorFactory.createError(getActivity(), error));
            }

            @Override
            public void onSuccess(final CommonDeliverable<TvSeriesContainer> deliverable) {
                AppLog.d(String.format(Locale.UK, "Loader: got %d series", deliverable.getContent().getSeries().size()));
                mFactory.setMedia(deliverable.getContent().getSeries());
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
                        AppLog.d(String.format(Locale.UK, "Loader: got %d genres", deliverable.getContent().getGenres().size()));
                        mFactory.setGenres(deliverable.getContent().getGenres());

                        notifySuccess(mFactory.create());
                    }
                });
    }
}
