package com.michaelfotiadis.moviedb.core.data.loader;

import android.content.Context;

import com.michaelfotiadis.moviedb.common.models.configuration.Configuration;
import com.michaelfotiadis.moviedb.common.models.genre.GenreContainer;
import com.michaelfotiadis.moviedb.common.models.genre.GenreType;
import com.michaelfotiadis.moviedb.common.models.movies.MoviesContainer;
import com.michaelfotiadis.moviedb.common.models.movies.details.MovieDetails;
import com.michaelfotiadis.moviedb.common.models.people.PeopleContainer;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesContainer;
import com.michaelfotiadis.moviedb.common.models.tv.details.TvSeriesDetails;
import com.michaelfotiadis.moviedb.common.responses.CommonCallback;
import com.michaelfotiadis.moviedb.common.responses.CommonError;
import com.michaelfotiadis.moviedb.common.responses.CommonErrorKind;

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

    public void getMovieById(final String id,
                             final CommonCallback<MovieDetails> masterCallback) {
        mNetworkLoader.getMovieById(id, masterCallback);
    }

    public void getSeriesById(final String id,
                              final CommonCallback<TvSeriesDetails> masterCallback) {
        mNetworkLoader.getSeriesById(id, masterCallback);
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

    public void getGenres(final GenreType type,
                          final CommonCallback<GenreContainer> masterCallback) {

        if (GenreType.MOVIE.equals(type)) {
            mNetworkLoader.getMovieGenres(masterCallback);
        } else if (GenreType.TV.equals(type)) {
            mNetworkLoader.getTvGenres(masterCallback);
        } else {
            masterCallback.onFailure(CommonError.from("Invalid request parameter", CommonErrorKind.INVALID_REQUEST_PARAMETERS));
        }
    }

}
