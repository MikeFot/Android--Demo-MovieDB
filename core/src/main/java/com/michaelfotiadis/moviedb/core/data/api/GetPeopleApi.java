package com.michaelfotiadis.moviedb.core.data.api;

import com.michaelfotiadis.moviedb.common.models.movies.MoviesContainer;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 *
 */
public interface GetPeopleApi {
    @GET("/person/popular")
    void getPopularPeople(@Query("api_key") String apiKey,
                          Callback<MoviesContainer> callback
    );
}
