package com.michaelfotiadis.moviedb.ui.core.intent.factory;

import android.content.Intent;

/**
 *
 */
public interface IntentFactory {

    Intent getMovieDetailsIntent(String id);

    Intent getHomeIntent();

    Intent getTvSeriesDetailsIntent(String id);
}
