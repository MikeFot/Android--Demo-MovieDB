package com.michaelfotiadis.moviedb.core.utils;

import android.util.Log;

import com.michaelfotiadis.moviedb.core.BuildConfig;
import com.michaelfotiadis.moviedb.core.DemoCore;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public final class CoreLog {

    private static final Set<String> CLASSNAME_TO_ESCAPE = getEscapedClassNames();
    private static final boolean INCLUDE_METHOD = BuildConfig.DEBUG;
    private static final String LINE_PREFIX = "SDK:";
    private static final int MAX_TAG_LENGTH = 50;
    private static final String PACKAGE_PREFIX = BuildConfig.APPLICATION_ID + ".";

    private CoreLog() {
        // Avoid instantiation
    }

    public static void d(final String message) {
        dInternal(message);
    }

    private static void dInternal(final String message) {
        if (BuildConfig.DEBUG || DemoCore.isDebugEnabled()) {
            Log.d(calcTag(), calcMessage(message));
        }
    }

    private static String calcTag() {
        final String caller = getCallingMethod();
        if (caller == null) {
            return "";
        } else {
            final String shortTag = caller.replace(PACKAGE_PREFIX, "");
            final boolean shouldBeShorter = shortTag.length() > MAX_TAG_LENGTH;

            if (shouldBeShorter) {
                final int length = shortTag.length();
                final int start = length - MAX_TAG_LENGTH;
                return shortTag.substring(start, length);
            } else {
                return shortTag;
            }
        }
    }

    private static String calcMessage(final String message) {
        return LINE_PREFIX + message;
    }

    private static String getCallingMethod() {
        final StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        if (stacks != null) {
            for (final StackTraceElement stack : stacks) {
                final String cn = stack.getClassName();
                if (cn != null && !CLASSNAME_TO_ESCAPE.contains(cn)) {
                    if (INCLUDE_METHOD) {
                        return cn + "#" + stack.getMethodName();
                    } else {
                        return cn;
                    }
                }
            }
        }
        return null;
    }

    public static void e(final String message) {
        eInternal(message, null);
    }

    private static void eInternal(final String message, final Exception e) {
        Log.e(calcTag(), calcMessage(message), e);
    }

    public static void e(final String message, final Exception e) {
        eInternal(message, e);
    }

    private static Set<String> getEscapedClassNames() {
        final Set<String> set = new HashSet<>();

        set.add("java.lang.Thread");
        set.add("dalvik.system.VMStack");
        set.add(Log.class.getName());
        set.add(CoreLog.class.getName());

        return set;
    }

    public static void w(final String message) {
        wInternal(message, null);
    }

    private static void wInternal(final String message, final Exception e) {
        Log.w(calcTag(), calcMessage(message), e);
    }

    public static void w(final String message, final Exception e) {
        wInternal(message, e);
    }
}