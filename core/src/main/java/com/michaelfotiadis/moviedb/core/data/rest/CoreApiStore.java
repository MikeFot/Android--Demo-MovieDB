package com.michaelfotiadis.moviedb.core.data.rest;

import com.google.gson.Gson;
import com.michaelfotiadis.moviedb.core.data.api.GetConfigurationApi;
import com.michaelfotiadis.moviedb.core.data.api.GetGenresApi;
import com.michaelfotiadis.moviedb.core.data.api.GetMoviesApi;
import com.michaelfotiadis.moviedb.core.data.api.GetPeopleApi;
import com.michaelfotiadis.moviedb.core.data.api.GetTvSeriesApi;
import com.michaelfotiadis.moviedb.core.utils.CoreLog;

import retrofit.RestAdapter;


/**
 *
 */
/*protected*/ class CoreApiStore {
    private final String mServerEndpoint;
    private final GetMoviesApi mMoviesApi;
    private final GetPeopleApi mPeopleApi;
    private final GetTvSeriesApi mTvSeriesApi;
    private final GetConfigurationApi mConfigurationApi;
    private final GetGenresApi mGenresApi;

    public CoreApiStore(final String serverEndpoint, final Gson gson) {
        CoreLog.d("New Retrofit API. Endpoint is " + serverEndpoint);

        final RestAdapter adapter = RestAdapterFactory.createDefault(serverEndpoint, gson);

        mServerEndpoint = serverEndpoint;
        mMoviesApi = adapter.create(GetMoviesApi.class);
        mPeopleApi = adapter.create(GetPeopleApi.class);
        mTvSeriesApi = adapter.create(GetTvSeriesApi.class);
        mConfigurationApi = adapter.create(GetConfigurationApi.class);
        mGenresApi = adapter.create(GetGenresApi.class);
    }


    public String getServerEndpoint() {
        return mServerEndpoint;
    }

    public GetMoviesApi getMoviesApi() {
        return mMoviesApi;
    }

    public GetPeopleApi getPeopleApi() {
        return mPeopleApi;
    }

    public GetTvSeriesApi getTvSeriesApi() {
        return mTvSeriesApi;
    }

    public GetConfigurationApi getConfigurationApi() {
        return mConfigurationApi;
    }

    public GetGenresApi getGenresApi() {
        return mGenresApi;
    }
}