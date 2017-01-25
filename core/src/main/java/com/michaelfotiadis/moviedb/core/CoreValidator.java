package com.michaelfotiadis.moviedb.core;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;

import com.michaelfotiadis.moviedb.common.exceptions.CoreException;
import com.michaelfotiadis.moviedb.core.utils.CoreLog;

import java.util.Collection;

public final class CoreValidator {

    private static final String NO_INTERNET_PERMISSION_REASON =
            "No internet permissions granted for the app, please add " +
                    "<uses-permission android:name=\"android.permission.INTERNET\" /> " +
                    "to your AndroidManifest.xml.";

    private CoreValidator() {
        // DO NOT INSTANTIATE
    }

    public static <T> boolean containsNoNulls(final Collection<T> container, final String name) {
        CoreValidator.notNull(container, name);
        for (final T item : container) {
            if (item == null) {
                final NullPointerException ex = new NullPointerException("Container '" + name +
                        "' cannot contain null values");
                if (!Looper.getMainLooper().equals(Looper.myLooper())) {
                    if (DemoCore.getInstance().isStrictModeEnabled()) {
                        throw ex;
                    } else {
                        CoreLog.e("Error", ex);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean hasInstallationID() {
        final String id = DemoCore.getInstance().getInstallationId();
        if (TextUtils.isEmpty(id)) {
            final IllegalStateException ex = new IllegalStateException("No MovieDbInstallation ID found.");
            if (DemoCore.getInstance().isStrictModeEnabled()) {
                throw ex;
            } else {
                CoreLog.e("Error", ex);
                return false;
            }
        } else {
            return true;
        }
    }

    public static boolean hasInternetPermissions(final Context context, final boolean shouldThrow) {
        CoreValidator.notNull(context, "context");
        if (context.checkCallingOrSelfPermission(Manifest.permission.INTERNET) ==
                PackageManager.PERMISSION_DENIED) {
            if (shouldThrow) {
                throw new IllegalStateException(NO_INTERNET_PERMISSION_REASON);
            } else {
                CoreLog.w(NO_INTERNET_PERMISSION_REASON);
                return false;
            }
        } else {
            return true;
        }
    }

    public static boolean hasMicrophonePermissions(final Context context, final boolean shouldThrow) {
        CoreValidator.notNull(context, "context");
        if (context.checkCallingOrSelfPermission(Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {
            if (shouldThrow) {
                throw new IllegalStateException(NO_INTERNET_PERMISSION_REASON);
            } else {
                CoreLog.w(NO_INTERNET_PERMISSION_REASON);
                return false;
            }
        } else {
            return true;
        }

    }

    public static <T> boolean notEmpty(final Collection<T> container, final String name) {
        if (container.isEmpty()) {
            final IllegalArgumentException ex = new IllegalArgumentException("Container '" + name + "' cannot be empty");
            if (DemoCore.getInstance().isStrictModeEnabled()) {
                throw ex;
            } else {
                CoreLog.e("Empty container: " + container, ex);
                return false;
            }
        } else {
            return true;
        }
    }

    public static <T> boolean notEmptyAndContainsNoNulls(final Collection<T> container, final String name) {
        return CoreValidator.containsNoNulls(container, name) && CoreValidator.notEmpty(container, name);
    }

    private static boolean notNull(final Object arg, final String name) {
        if (arg == null) {
            final NullPointerException ex = new NullPointerException("Argument '" + name + "' cannot be null");
            if (DemoCore.getInstance().isStrictModeEnabled()) {
                throw ex;
            } else {
                CoreLog.w("Null object", ex);
                return false;
            }
        } else {
            return true;
        }
    }

    public static boolean runningOnBackgroundThread() {
        final CoreException ex = new CoreException("This method should be called from the Background thread");
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            if (DemoCore.getInstance().isStrictModeEnabled()) {
                throw ex;
            } else {
                CoreLog.e("Error", ex);
                return false;
            }
        } else {
            return true;
        }
    }

    public static boolean runningOnUiThread() {
        final CoreException ex = new CoreException("This method should be called from the UI thread");

        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            if (DemoCore.getInstance().isStrictModeEnabled()) {
                throw ex;
            } else {
                CoreLog.e("Error", ex);
                return false;
            }
        } else {
            return true;
        }
    }
}