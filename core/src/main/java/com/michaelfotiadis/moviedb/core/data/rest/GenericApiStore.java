package com.michaelfotiadis.moviedb.core.data.rest;

import com.google.gson.Gson;
import com.michaelfotiadis.moviedb.core.data.api.GenericApi;
import com.michaelfotiadis.moviedb.core.utils.CoreLog;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 */
/*protected*/ class GenericApiStore {
    private static final int MAX_ENTRIES = 5;
    private final Gson mGson;
    private final Map<String, GenericApi> mLru;

    public GenericApiStore(final Gson gson) {
        mGson = gson;
        mLru = Collections.synchronizedMap(new LruMap<String, GenericApi>(MAX_ENTRIES));
    }

    public GenericApi getGenericApi(final String serverEndpoint) {

        final GenericApi result;

        synchronized (this) {
            if (mLru.containsKey(serverEndpoint)) {
                //SdkLog.d("Using pre-created Generic Retrofit API. Endpoint is " + serverEndpoint);
                result = mLru.get(serverEndpoint);
            } else {
                CoreLog.d("New Generic Retrofit API. Endpoint is " + serverEndpoint);
                result = RestAdapterFactory
                        .createDefault(serverEndpoint, mGson)
                        .create(GenericApi.class);

                mLru.put(serverEndpoint, result);
            }
        }

        return result;
    }

    private static class LruMap<K, V> extends LinkedHashMap<K, V> {
        private final int maxEntries;

        public LruMap(final int maxEntries) {
            super(maxEntries + 1, .75F, true);
            this.maxEntries = maxEntries;
        }

        // This method is called just after a new entry has been added
        public boolean removeEldestEntry(final Map.Entry<K, V> eldest) {
            return size() > maxEntries;
        }
    }

}