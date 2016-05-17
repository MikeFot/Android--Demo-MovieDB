package com.michaelfotiadis.moviedb.ui.core.intent.factory;

import android.content.Context;
import android.content.Intent;

import com.michaelfotiadis.moviedb.ui.components.home.HomeActivity;


/**
 *
 */
public class IntentFactoryImpl implements IntentFactory {

    private final Context mContext;

    public IntentFactoryImpl(final Context context) {
        mContext = context.getApplicationContext();
    }

    @Override
    public Intent getHomeIntent() {
        return HomeActivity.getInstance(mContext);
    }
}
