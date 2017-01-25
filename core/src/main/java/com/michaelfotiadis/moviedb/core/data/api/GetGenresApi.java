package com.michaelfotiadis.moviedb.core.data.api;

import com.michaelfotiadis.moviedb.common.models.genre.GenreContainer;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 *
 */
public interface GetGenresApi {

    @GET("/genre/movie/list")
    void getMovieGenres(@Query("api_key") String apiKey,
                        Callback<GenreContainer> callback
    );

    @GET("/genre/tv/list")
    void getTvGenres(@Query("api_key") String apiKey,
                     Callback<GenreContainer> callback
    );
}
