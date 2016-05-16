package com.michaelfotiadis.moviedb;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.utils.AppLog;

import io.fabric.sdk.android.Fabric;

/**
 *
 */
public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        AppLog.d(String.format("Dev Mode is %s and strict mode is %s", BuildConfig.DEV_MODE, BuildConfig.STRICT_MODE));
        AppLog.d("API KEY is " + getString(R.string.api_key));

        /**
         * Initialise the core module using the api key
         */
        DemoCore.init(this, getString(R.string.api_key), BuildConfig.DEV_MODE, BuildConfig.STRICT_MODE);

    }

}
