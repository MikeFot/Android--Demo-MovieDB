package com.michaelfotiadis.moviedb.core.data.rest;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
/*package*/ final class RestAdapterFactory {
    private static final String LOG_PREFIX = "^^";

    private RestAdapterFactory() {
    }

    public static Retrofit createDefault(final String endpoint,
                                         final Gson gson) {

        final Retrofit.Builder builder = new Retrofit.Builder();

        builder.baseUrl(endpoint);

        if (gson != null) {
            builder.addConverterFactory(GsonConverterFactory.create(gson));
        } else {
            builder.addConverterFactory(GsonConverterFactory.create());
        }

        builder.client(getClient(new Interceptor() {
            @Override
            public Response intercept(final Chain chain) throws IOException {
                // TODO set up the interceptor
                return null;
            }
        }));

        return builder.build();
    }


    private static OkHttpClient getClient(final okhttp3.Interceptor interceptor) {

        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (interceptor != null) {
            builder.addInterceptor(interceptor);
        }

        return builder.build();
    }

}