package com.michaelfotiadis.moviedb.core.data.api;


import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 *
 */
public interface GenericApi {

    @GET("/{endpoint}")
    void get(@Path(value = "endpoint", encode = false) String endpoint, Callback<Response> callback);

}
