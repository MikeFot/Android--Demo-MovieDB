package com.michaelfotiadis.moviedb.core.data.rest;

import com.google.gson.Gson;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.core.data.api.GetConfigurationApi;
import com.michaelfotiadis.moviedb.core.data.api.GetMoviesApi;
import com.michaelfotiadis.moviedb.core.data.api.GetPeopleApi;
import com.michaelfotiadis.moviedb.core.data.api.GetTvSeriesApi;
import com.michaelfotiadis.moviedb.core.data.parsers.gson.CoreGson;
import com.michaelfotiadis.moviedb.core.utils.CoreLog;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;

/**
 * Rest Client class
 */
public final class CoreRestClientImpl implements CoreRestClient {

    private final GenericApiStore mGenericApiStore;
    private CoreApiStore mApiStore;

    /**
     * Constructor for the CiniKitRestClient
     *
     * @param cacheDirectory Nullable File object for cache directory.
     */
    public CoreRestClientImpl(final File cacheDirectory) {
        CoreLog.d("Initialising the Rest Client");

        mGenericApiStore = new GenericApiStore(CoreGson.get());
        final OkHttpClient client = new OkHttpClient();

        // initialise the cache directory if the parameter is not null
        if (cacheDirectory != null) {
            final Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);
            client.setCache(cache);
            CoreLog.d("Client initialised with cache");
        } else {
            CoreLog.d("Client initialised without cache");
        }
    }


    private void validateApiStore() {
        final boolean recreate;

        if (mApiStore == null) {
            recreate = true;
        } else {
            final String currentEndpoint = DemoCore.getEndpoint();
            final String apiEndpoint = mApiStore.getServerEndpoint();
            recreate = !currentEndpoint.equals(apiEndpoint);
        }

        if (recreate) {
            final String currentEndpoint = DemoCore.getEndpoint();
            final Gson gson = CoreGson.get();
            mApiStore = new CoreApiStore(currentEndpoint, gson);
        }
    }

    @Override
    public synchronized GetMoviesApi getMoviesApi() {
        validateApiStore();
        return mApiStore.getMoviesApi();
    }

    @Override
    public synchronized GetPeopleApi getPeopleApi() {
        validateApiStore();
        return mApiStore.getPeopleApi();
    }

    @Override
    public synchronized GetTvSeriesApi getTvSeriesApi() {
        validateApiStore();
        return mApiStore.getTvSeriesApi();
    }

    @Override
    public synchronized GetConfigurationApi getConfigurationApi() {
        validateApiStore();
        return mApiStore.getConfigurationApi();
    }
}