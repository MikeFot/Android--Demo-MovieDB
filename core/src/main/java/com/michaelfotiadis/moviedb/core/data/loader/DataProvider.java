package com.michaelfotiadis.moviedb.core.data.loader;

import android.content.Context;

import com.michaelfotiadis.moviedb.common.models.configuration.Configuration;
import com.michaelfotiadis.moviedb.common.models.movies.MoviesContainer;
import com.michaelfotiadis.moviedb.common.models.people.PeopleContainer;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesContainer;
import com.michaelfotiadis.moviedb.common.responses.CommonCallback;

import java.io.File;

/**
 *
 */
public class DataProvider {

    private final LoaderNetwork mNetworkLoader;

    public DataProvider(final Context context, final String apiKey) {
        mNetworkLoader = new LoaderNetwork(
                apiKey,
                new File(context.getCacheDir().getAbsolutePath()));

    }

    public void getPopularMovies(final CommonCallback<MoviesContainer> masterCallback) {
        mNetworkLoader.getPopularMovies(masterCallback);
    }

    public void getPopularPeople(final CommonCallback<PeopleContainer> masterCallback) {
        mNetworkLoader.getPopularPeople(masterCallback);
    }

    public void getPopularSeries(final CommonCallback<TvSeriesContainer> masterCallback) {
        mNetworkLoader.getPopularSeries(masterCallback);
    }

    public void getConfiguration(final CommonCallback<Configuration> masterCallback) {
        mNetworkLoader.getConfiguration(masterCallback);
    }

}
