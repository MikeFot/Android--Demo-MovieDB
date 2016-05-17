package com.michaelfotiadis.moviedb.core.data.api;

import com.michaelfotiadis.moviedb.common.models.movies.MoviesContainer;
import com.michaelfotiadis.moviedb.common.models.movies.details.MovieDetails;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 *
 */
public interface GetMoviesApi {
    @GET("/movie/popular")
    void getPopularMovies(@Query("api_key") String apiKey,
                          Callback<MoviesContainer> callback
    );

    @GET("/movie/{id}")
    void getMovieById(@Path("id") String id,
                      @Query("api_key") String apiKey,
                      Callback<MovieDetails> callback);
}
