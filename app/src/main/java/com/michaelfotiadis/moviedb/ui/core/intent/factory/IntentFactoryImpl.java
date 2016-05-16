package com.michaelfotiadis.moviedb.ui.core.intent.factory;

import android.content.Context;


/**
 *
 */
public class IntentFactoryImpl implements IntentFactory {

    private final Context mContext;

    public IntentFactoryImpl(final Context context) {
        mContext = context.getApplicationContext();
    }

}
