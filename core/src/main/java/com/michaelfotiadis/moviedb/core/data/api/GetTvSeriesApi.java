package com.michaelfotiadis.moviedb.core.data.api;

import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesContainer;
import com.michaelfotiadis.moviedb.common.models.tv.details.TvSeriesDetails;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 *
 */
public interface GetTvSeriesApi {
    @GET("/tv/popular")
    void getPopularSeries(@Query("api_key") String apiKey,
                          Callback<TvSeriesContainer> callback
    );

    @GET("/tv/{id}")
    void getSeriesById(@Path("id") String id,
                       @Query("api_key") String apiKey,
                       Callback<TvSeriesDetails> callback);
}
