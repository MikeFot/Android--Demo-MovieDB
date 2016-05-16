package com.michaelfotiadis.moviedb.core;

import android.content.Context;
import android.text.TextUtils;

import com.michaelfotiadis.moviedb.common.exceptions.CoreException;
import com.michaelfotiadis.moviedb.core.data.DataProvider;
import com.michaelfotiadis.moviedb.core.utils.CoreLog;

/**
 */
public final class DemoCore {

    private static final Object LOCK = new Object();
    private static DemoCore sInstance;
    /**
     * Boolean for logging
     */
    private boolean mIsDebugEnabled;
    /**
     * Boolean for marking strict mode (will throw more exceptions instead of just logging errors
     */
    private boolean mIsStrictModeEnabled;
    /**
     * {@link DataProvider} instance
     */
    private DataProvider mDataProvider;
    /**
     * Unique Installation ID for the device
     **/
    private String mInstallationId;

    /**
     * Api Key for network calls
     */
    private String mApiKey;

    private DemoCore() {
        // DO NOT INSTANTIATE
    }

    /* package */
    static DemoCore getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new DemoCore();
                }
            }
        }
        return sInstance;
    }

    public static synchronized void init(final Context applicationContext,
                                         final String apiKey,
                                         final boolean isDebug,
                                         final boolean isStrict) {

        if (applicationContext == null) {
            throw new NullPointerException("Null application context");
        }

        if (TextUtils.isEmpty(apiKey)) {
            throw new CoreException("Api Key cannot be empty");
        }


        final Context context = applicationContext.getApplicationContext();
        getInstance().mIsDebugEnabled = isDebug;
        getInstance().mIsStrictModeEnabled = isStrict;

        getInstance().mApiKey = apiKey;

        // generate an installation id
        getInstance().mInstallationId = CoreInstaller.generateInstallationId(context);

        getInstance().mDataProvider = new DataProvider(context);

        CoreLog.d("Core Initialised with installation id " + getInstance().getInstallationId());
    }

    public String getApiKey() {
        return mApiKey;
    }

    public boolean isStrictModeEnabled() {
        return mIsStrictModeEnabled;
    }

    /*package*/ String getInstallationId() {
        if (mInstallationId != null) {
            return mInstallationId;
        } else {
            throw new IllegalStateException("Installation ID requested before initialising the SDK.");
        }
    }

    public static boolean isDebugEnabled() {
        return getInstance().mIsDebugEnabled;
    }

    public static DataProvider getDataProvider() {
        return getInstance().mDataProvider;
    }
}
