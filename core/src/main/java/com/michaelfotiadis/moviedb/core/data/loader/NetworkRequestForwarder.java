package com.michaelfotiadis.moviedb.core.data.loader;

import com.michaelfotiadis.moviedb.common.models.configuration.Configuration;
import com.michaelfotiadis.moviedb.common.models.genre.GenreContainer;
import com.michaelfotiadis.moviedb.common.models.movies.MoviesContainer;
import com.michaelfotiadis.moviedb.common.models.movies.details.MovieDetails;
import com.michaelfotiadis.moviedb.common.models.people.PeopleContainer;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesContainer;
import com.michaelfotiadis.moviedb.common.models.tv.details.TvSeriesDetails;
import com.michaelfotiadis.moviedb.core.data.rest.CoreRestClient;

import retrofit.Callback;

/**
 *
 */
/*package*/ class NetworkRequestForwarder {

    private final String mApiKey;
    private final CoreRestClient mRestClient;


    public NetworkRequestForwarder(final String apiKey, final CoreRestClient restClient) {
        this.mApiKey = apiKey;
        this.mRestClient = restClient;
    }

    public void forwardGetPopularMovies(final Callback<MoviesContainer> retrofitCallback) {
        mRestClient.getMoviesApi().getPopularMovies(mApiKey, retrofitCallback);
    }

    public void forwardGetMovieById(final String id,
                                    final Callback<MovieDetails> retrofitCallback) {
        mRestClient.getMoviesApi().getMovieById(id, mApiKey, retrofitCallback);
    }

    public void forwardGetSeriesById(final String id,
                                     final Callback<TvSeriesDetails> retrofitCallback) {
        mRestClient.getTvSeriesApi().getSeriesById(id, mApiKey, retrofitCallback);
    }

    public void forwardGetPopularPeople(final Callback<PeopleContainer> retrofitCallback) {
        mRestClient.getPeopleApi().getPopularPeople(mApiKey, retrofitCallback);
    }

    public void forwardGetPopularSeries(final Callback<TvSeriesContainer> retrofitCallback) {
        mRestClient.getTvSeriesApi().getPopularSeries(mApiKey, retrofitCallback);
    }

    public void forwardGetConfiguration(final Callback<Configuration> retrofitCallback) {
        mRestClient.getConfigurationApi().getConfiguration(mApiKey, retrofitCallback);
    }

    public void forwardGetMovieGenres(final Callback<GenreContainer> retrofitCallback) {
        mRestClient.getGenresApi().getMovieGenres(mApiKey, retrofitCallback);
    }

    public void forwardGetTvGenres(final Callback<GenreContainer> retrofitCallback) {
        mRestClient.getGenresApi().getTvGenres(mApiKey, retrofitCallback);
    }

}
