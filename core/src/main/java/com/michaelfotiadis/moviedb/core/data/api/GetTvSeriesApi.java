package com.michaelfotiadis.moviedb.core.data.api;

import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesContainer;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 *
 */
public interface GetTvSeriesApi {
    @GET("/tv/popular")
    void getPopularSeries(@Query("api_key") String apiKey,
                          Callback<TvSeriesContainer> callback
    );
}
