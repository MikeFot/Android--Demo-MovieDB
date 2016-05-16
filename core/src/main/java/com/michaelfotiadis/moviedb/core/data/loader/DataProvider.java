package com.michaelfotiadis.moviedb.core.data.loader;

import android.content.Context;

import java.io.File;

/**
 *
 */
public class DataProvider {

    private final LoaderNetwork mNetworkLoader;

    public DataProvider(final Context context, final String apiKey) {
        mNetworkLoader = new LoaderNetwork(
                apiKey,
                new File(context.getCacheDir().getAbsolutePath()));

    }

    public LoaderNetwork getNetworkLoader() {
        return mNetworkLoader;
    }
}
