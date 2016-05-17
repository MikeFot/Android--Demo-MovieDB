package com.michaelfotiadis.moviedb.ui.core.imagefetcher;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

import com.michaelfotiadis.moviedb.utils.AppLog;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.concurrent.ExecutorService;

/**
 *
 */
/*package*/ class PicassoSingleton {
    private static final long MEGABYTE = 1024 * 1024;
    private static final Bitmap.Config PICASSO_BITMAP_CONFIG = Bitmap.Config.RGB_565;
    private static final String PICASSO_CACHE_DIRECTORY = "cinime_picasso_cache";
    private static final long PICASSO_CACHE_SIZE = 200 * MEGABYTE;
    //
    // PICASSO SETTINGS
    //
    //@formatter:off
    private static final boolean PICASSO_DEBUG_ENABLED = true;
    private static final ExecutorService PICASSO_EXECUTOR = null; // USE THE DEFAULT PICASSO EXECUTOR
    //@formatter:on

    //
    // SINGLETON INSTANCE
    //
    private static volatile Picasso sInstance;

    public Picasso getInstance(final Context context) {
        Picasso result = sInstance;
        if (result == null) {
            synchronized (this) {
                result = sInstance;
                if (result == null) {
                    sInstance = result = create(context);
                }
            }
        }
        return result;
    }

    private static Picasso create(final Context context) {
        final boolean debugEnabled = PICASSO_DEBUG_ENABLED;
        final Context appContext = context.getApplicationContext();

        AppLog.d("PICASSO: New Instance!");
        final OkHttpClient client = new OkHttpClient();
        client.setCache(createHttpClientCache(appContext));

        final Picasso.Builder builder = new Picasso.Builder(appContext);
        builder.downloader(new OkHttpDownloader(client));
        builder.indicatorsEnabled(debugEnabled);
        builder.defaultBitmapConfig(PICASSO_BITMAP_CONFIG);

        //noinspection ConstantConditions
        if (PICASSO_EXECUTOR != null) {
            builder.executor(PICASSO_EXECUTOR);
        }

        if (debugEnabled) {
            builder.listener(new PicassoListener());
        }

        return builder.build();
    }

    private static Cache createHttpClientCache(final Context context) {
        try {
            final File cacheDirectory = new File(
                    context.getCacheDir().getAbsolutePath(),
                    PICASSO_CACHE_DIRECTORY);

            return new Cache(cacheDirectory, PICASSO_CACHE_SIZE);
        } catch (final Exception e) {
            AppLog.w("PICASSO: Could not create http cache because: ", e);
            return null;
        }
    }

    private static class PicassoListener implements Picasso.Listener {
        @Override
        public void onImageLoadFailed(final Picasso picasso,
                                      final Uri uri,
                                      final Exception e) {
            AppLog.w("PICASSO: Failed to load image: '" + uri + "': " + e.getMessage());
        }
    }
}