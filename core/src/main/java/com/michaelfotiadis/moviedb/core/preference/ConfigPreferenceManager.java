package com.michaelfotiadis.moviedb.core.preference;

import android.content.Context;
import android.content.SharedPreferences;

import com.michaelfotiadis.moviedb.common.models.configuration.Configuration;
import com.michaelfotiadis.moviedb.core.data.parsers.gson.CoreGson;
import com.michaelfotiadis.moviedb.core.utils.CoreLog;

/**
 * Class for managing {@link SharedPreferences}
 */
public class ConfigPreferenceManager implements PreferenceManager {
    private static final String KEY_CONFIGURATION = "key_configuration";
    private static final String KEY_IMAGE_BASE_URL = "key_image_base_url";
    private static final String PREFERENCES = "com.michaelfotiadis.moviedb.prefs";
    private final Context mContext;

    public ConfigPreferenceManager(final Context context) {
        mContext = context.getApplicationContext();
    }

    public String getImageBaseUrl() {
        return getPreferences().getString(KEY_IMAGE_BASE_URL, null);
    }

    private SharedPreferences getPreferences() {
        return mContext.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    public Configuration getConfiguration() {
        final String value = getPreferences().getString(KEY_CONFIGURATION, null);
        return CoreGson.get().fromJson(value, Configuration.class);
    }

    public void writeConfiguration(final Configuration config) {

        if (config != null) {

            writeImageBaseUrl(config.getImages().getBaseUrl());

            final SharedPreferences.Editor editor = getPreferences().edit();
            final String value = CoreGson.get().toJson(config, Configuration.class);
            editor.putString(KEY_CONFIGURATION, value);
            editor.apply();
            CoreLog.d("Wrote configuration");
        } else {
            CoreLog.e("Failed to write configuration");
        }

    }

    private void writeImageBaseUrl(final String value) {
        final SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(KEY_IMAGE_BASE_URL, value);
        editor.apply();
        CoreLog.d("Wrote base image url " + value);
    }

}
