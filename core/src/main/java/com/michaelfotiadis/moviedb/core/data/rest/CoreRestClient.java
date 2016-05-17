package com.michaelfotiadis.moviedb.core.data.rest;

import com.michaelfotiadis.moviedb.core.data.api.GetConfigurationApi;
import com.michaelfotiadis.moviedb.core.data.api.GetMoviesApi;
import com.michaelfotiadis.moviedb.core.data.api.GetPeopleApi;
import com.michaelfotiadis.moviedb.core.data.api.GetTvSeriesApi;

/**
 * Rest Client class
 */
public interface CoreRestClient {


    GetMoviesApi getMoviesApi();

    GetPeopleApi getPeopleApi();

    GetTvSeriesApi getTvSeriesApi();

    GetConfigurationApi getConfigurationApi();
}