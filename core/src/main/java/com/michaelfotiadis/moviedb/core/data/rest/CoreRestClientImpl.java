package com.michaelfotiadis.moviedb.core.data.rest;

import com.google.gson.Gson;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.core.data.parsers.gson.CoreGson;
import com.michaelfotiadis.moviedb.core.utils.CoreLog;

/**
 * Rest Client class
 */
public final class CoreRestClientImpl implements CoreRestClient {

    private final GenericApiStore mGenericApiStore;
    private CoreApiStore mCiniKitApiStore;

    /**
     * Constructor for the CoreRestClient
     */
    public CoreRestClientImpl() {
        CoreLog.d("Initialising the Rest Client");
        mGenericApiStore = new GenericApiStore(CoreGson.get());
    }


    private void validateApiStore() {
        final boolean recreate;

        if (mCiniKitApiStore == null) {
            recreate = true;
        } else {
            final String currentEndpoint = DemoCore.getEndpoint();
            final String apiEndpoint = mCiniKitApiStore.getServerEndpoint();
            recreate = !currentEndpoint.equals(apiEndpoint);
        }

        if (recreate) {
            final String currentEndpoint = DemoCore.getEndpoint();
            final Gson gson = CoreGson.get();
            mCiniKitApiStore = new CoreApiStore(currentEndpoint, gson);
        }
    }
}