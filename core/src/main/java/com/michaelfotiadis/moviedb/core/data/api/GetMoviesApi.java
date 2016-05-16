package com.michaelfotiadis.moviedb.core.data.api;

import com.michaelfotiadis.moviedb.common.models.movies.MoviesContainer;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 *
 */
public interface GetMoviesApi {
    @GET("/movie/popular")
    void getPopularMovies(@Query("api_key") String apiKey,
                          Callback<MoviesContainer> callback
    );
}
