package com.michaelfotiadis.moviedb.core.data.api;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *
 */
public interface GenericApi {

    @GET("/{endpoint}")
    void get(@Path(value = "endpoint", encoded = false) String endpoint, Callback<Response> callback);

}
