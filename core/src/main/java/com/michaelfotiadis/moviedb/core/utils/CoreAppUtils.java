package com.michaelfotiadis.moviedb.core.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.concurrent.TimeUnit;

/**
 */
public final class CoreAppUtils {

    // Sets the amount of time an idle thread waits before terminating
    public static final int KEEP_ALIVE_TIME = 1;
    // Sets the Time Unit to seconds
    public static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private CoreAppUtils() {
        // DO NOT INSTANTIATE
    }

    public static String getApplicationVersion(final Context context) {
        try {
            final PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (pInfo.versionName != null) {
                return pInfo.versionName;
            } else {
                return "0.0";
            }
        } catch (final PackageManager.NameNotFoundException e) {
            CoreLog.e("Error getting package name", e);
            return "0.1";
        }

    }

    public static int getNumberOfAvailableThreads() {

        return Runtime.getRuntime().availableProcessors();
    }

}
