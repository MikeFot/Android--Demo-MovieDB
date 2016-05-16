package com.michaelfotiadis.moviedb.core.data.rest;

import com.google.gson.Gson;
import com.michaelfotiadis.moviedb.core.utils.CoreLog;


/**
 *
 */
/*protected*/ class CoreApiStore {
    private final String mServerEndpoint;

    public CoreApiStore(final String serverEndpoint, final Gson gson) {
        CoreLog.d("New Moni Retrofit API. Endpoint is " + serverEndpoint);
        mServerEndpoint = serverEndpoint;
    }


    public String getServerEndpoint() {
        return mServerEndpoint;
    }
}