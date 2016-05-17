package com.michaelfotiadis.moviedb.core;

import android.content.Context;
import android.text.TextUtils;

import com.michaelfotiadis.moviedb.common.exceptions.CoreException;
import com.michaelfotiadis.moviedb.core.data.loader.DataProvider;
import com.michaelfotiadis.moviedb.core.preference.ConfigPreferenceManager;
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
     * Endpoint for network calls
     */
    private String mEndpoint;

    /**
     * {@link com.michaelfotiadis.moviedb.core.preference.PreferenceManager}
     */
    private ConfigPreferenceManager mPreferenceManager;

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
                                         final String endpoint,
                                         final boolean isDebug,
                                         final boolean isStrict) {

        if (applicationContext == null) {
            throw new NullPointerException("Null application context");
        }
        final Context context = applicationContext.getApplicationContext();

        if (TextUtils.isEmpty(apiKey)) {
            throw new CoreException("Api Key cannot be empty");
        }

        if (TextUtils.isEmpty(endpoint)) {
            throw new CoreException("Endpoint cannot be empty");
        }
        getInstance().mEndpoint = endpoint;


        getInstance().mIsDebugEnabled = isDebug;
        getInstance().mIsStrictModeEnabled = isStrict;

        // generate an installation id
        getInstance().mInstallationId = CoreInstaller.generateInstallationId(context);

        getInstance().mDataProvider = new DataProvider(context, apiKey);

        getInstance().mPreferenceManager = new ConfigPreferenceManager(context);

        CoreLog.d("Core Initialised with installation id " + getInstance().getInstallationId());
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

    public static ConfigPreferenceManager getPreferenceManager() {
        return getInstance().mPreferenceManager;
    }

    public static String getEndpoint() {
        return getInstance().mEndpoint;
    }

    public static boolean isDebugEnabled() {
        return getInstance().mIsDebugEnabled;
    }

    public static DataProvider getDataProvider() {
        return getInstance().mDataProvider;
    }
}
