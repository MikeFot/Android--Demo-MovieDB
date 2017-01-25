package com.michaelfotiadis.moviedb.core.data.api;

import com.michaelfotiadis.moviedb.common.models.configuration.Configuration;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 *
 */
public interface GetConfigurationApi {
    @GET("/configuration")
    void getConfiguration(@Query("api_key") String apiKey,
                          Callback<Configuration> callback
    );
}
