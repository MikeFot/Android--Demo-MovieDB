package com.michaelfotiadis.moviedb.ui.core.imagefetcher;

import android.app.Activity;
import android.widget.ImageView;

import com.michaelfotiadis.moviedb.R;

/**
 *
 */
public final class ImageFetcherImpl implements ImageFetcher {
    private static final int DEFAULT_PLACEHOLDER_IMAGE = R.drawable.ic_movie;
    private static final ScaleType DEFAULT_SCALE_TYPE = ScaleType.CENTER_CROP;
    private final PicassoWrapper mWrapper;

    public ImageFetcherImpl(final Activity activity) {
        mWrapper = new PicassoWrapper(activity);
    }

    private void internalLoad(final ImageFetcherRequest oldRequest,
                              final ImageView imageView,
                              final ImageFetcherCallback callback) {
        final ImageFetcherRequest sanitisedReq = sanitise(oldRequest);

        mWrapper.load(
                sanitisedReq,
                imageView,
                callback);
    }

    @Override
    public void load(final ImageFetcherRequest request,
                     final ImageView imageView,
                     final ImageFetcherCallback callback) {
        internalLoad(request, imageView, callback);
    }

    @Override
    public void loadIntoImageView(final String imagePath,
                                  final int placeholder,
                                  final ImageView imageView) {

        final ImageFetcherRequest request = new ImageFetcherRequest.Builder()
                .withPath(imagePath)
                .withPlaceholderResId(placeholder)
                .build();

        internalLoad(request, imageView, null);
    }


    @Override
    public void loadIntoImageView(final int resId,
                                  final int placeholder,
                                  final ImageView imageView) {

        final ImageFetcherRequest request = new ImageFetcherRequest.Builder()
                .withDrawableResId(resId)
                .withPlaceholderResId(placeholder)
                .build();

        internalLoad(request, imageView, null);
    }

    @Override
    public void loadIntoImageView(final String imagePath,
                                  final int placeholder,
                                  final ImageView imageView,
                                  final ImageFetcherCallback callback) {
        final ImageFetcherRequest request = new ImageFetcherRequest.Builder()
                .withPath(imagePath)
                .withPlaceholderResId(placeholder)
                .build();

        internalLoad(request, imageView, callback);
    }

    @Override
    public void loadIntoImageView(final String imagePath,
                                  final ImageView imageView) {
        final ImageFetcherRequest request = new ImageFetcherRequest.Builder()
                .withPath(imagePath)
                .build();

        internalLoad(request, imageView, null);
    }

    @Override
    public void loadIntoImageView(final String imagePath,
                                  final ImageView imageView,
                                  final ImageFetcherCallback callback) {
        final ImageFetcherRequest request = new ImageFetcherRequest.Builder()
                .withPath(imagePath)
                .build();

        internalLoad(request, imageView, callback);
    }

    private static ImageFetcherRequest sanitise(final ImageFetcherRequest req) {

        final int placeholder = req.getPlaceholderResId() > 0 ? req.getPlaceholderResId() : DEFAULT_PLACEHOLDER_IMAGE;
        final int error = req.getErrorResId() > 0 ? req.getErrorResId() : placeholder;
        final ScaleType scale = req.getScaleType() != null ? req.getScaleType() : DEFAULT_SCALE_TYPE;

        return new ImageFetcherRequest.Builder()
                .from(req)
                .withPlaceholderResId(placeholder)
                .withErrorResId(error)
                .withScaleType(scale)
                .build();
    }
}
