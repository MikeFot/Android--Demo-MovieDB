package com.michaelfotiadis.moviedb.core.data.rest;

import com.google.gson.Gson;
import com.michaelfotiadis.moviedb.core.DemoCore;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.converter.GsonConverter;

/**
 *
 */
/*package*/ final class RestAdapterFactory {
    private static final RestAdapter.LogLevel LOG_LEVEL = RestAdapter.LogLevel.BASIC;
    private static final String LOG_PREFIX = "^^";

    private RestAdapterFactory() {
    }

    public static RestAdapter createDefault(final String serverEndpoint,
                                            final Gson gson) {
        final RestAdapter.Builder restAdapterBuilder = new RestAdapter.Builder();
        restAdapterBuilder.setEndpoint(serverEndpoint);
        restAdapterBuilder.setConverter(new GsonConverter(gson));

        // instantiate a request interceptor
        final RequestInterceptor requestInterceptor = new InternalRequestInterceptor();
        restAdapterBuilder.setRequestInterceptor(requestInterceptor);

        if (DemoCore.isDebugEnabled()) {
            restAdapterBuilder.setLogLevel(LOG_LEVEL).setLog(new AndroidLog(LOG_PREFIX + "Retrofit"));
        }

        return restAdapterBuilder.build();
    }

    public static RestAdapter createGeneric(final String endpoint, final Gson gson) {
        final RestAdapter.Builder restAdapterBuilder = new RestAdapter.Builder();
        restAdapterBuilder.setConverter(new GsonConverter(gson));
        restAdapterBuilder.setEndpoint(endpoint);
        return restAdapterBuilder.build();
    }

    private static class InternalRequestInterceptor implements RequestInterceptor {
        @Override
        public void intercept(final RequestFacade request) {
            request.addHeader("Content-Type", "application/json");
        }
    }
}