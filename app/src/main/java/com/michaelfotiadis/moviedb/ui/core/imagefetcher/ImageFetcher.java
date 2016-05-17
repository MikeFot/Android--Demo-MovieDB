package com.michaelfotiadis.moviedb.ui.core.imagefetcher;

import android.widget.ImageView;

/**
 *
 */
public interface ImageFetcher {
    void load(final ImageFetcherRequest request, final ImageView imageView, final ImageFetcherCallback callback);

    void loadIntoImageView(final String imagePath, final ImageView imageView, final ImageFetcherCallback callback);

    void loadIntoImageView(final String imagePath, final int placeholder, final ImageView imageView);

    void loadIntoImageView(final String imagePath, final int placeholder, final ImageView imageView, final ImageFetcherCallback callback);

    void loadIntoImageView(final int resId, final int placeholder, final ImageView imageView);

    void loadIntoImageView(final String imagePath, final ImageView imageView);
}
