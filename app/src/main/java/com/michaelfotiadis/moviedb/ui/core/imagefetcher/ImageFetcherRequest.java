package com.michaelfotiadis.moviedb.ui.core.imagefetcher;

import android.widget.ImageView;

/**
 *
 */
public final class ImageFetcherRequest {
    private final int drawableId;
    private final int errorResId;
    private final String path;
    private final int placeholderResId;
    private final ScaleType scaleType;

    private ImageFetcherRequest(final Builder builder) {
        this.scaleType = builder.scaleType;
        this.path = builder.path;
        this.drawableId = builder.drawableId;
        this.errorResId = builder.errorResId;
        this.placeholderResId = builder.placeholderResId;
    }

    public int getDrawableId() {
        return drawableId;
    }

    /*package*/ int getErrorResId() {
        return errorResId;
    }

    /*package*/ String getPath() {
        return path;
    }

    /*package*/ int getPlaceholderResId() {
        return placeholderResId;
    }

    /*package*/ ScaleType getScaleType() {
        return scaleType;
    }

    public void load(final ImageFetcher fetcher, final ImageView target) {
        load(fetcher, target, null);
    }

    public void load(final ImageFetcher fetcher, final ImageView target, final ImageFetcherCallback callback) {
        fetcher.load(this, target, callback);
    }

    @Override
    public String toString() {
        return "ImageFetcherRequest{" +
                "drawableId=" + drawableId +
                ", errorResId=" + errorResId +
                ", path='" + path + '\'' +
                ", placeholderResId=" + placeholderResId +
                ", scaleType=" + scaleType +
                '}';
    }

    public static final class Builder {
        private int drawableId;
        private int errorResId;
        private String path;
        private int placeholderResId;
        private ScaleType scaleType;

        public ImageFetcherRequest build() {
            return new ImageFetcherRequest(this);
        }

        public Builder from(final ImageFetcherRequest request) {
            drawableId = request.getDrawableId();
            errorResId = request.getErrorResId();
            path = request.getPath();
            placeholderResId = request.getPlaceholderResId();
            scaleType = request.getScaleType();
            return this;
        }

        public Builder withDrawableResId(final int drawableId) {
            this.drawableId = drawableId;
            this.path = null;
            return this;
        }

        public Builder withErrorResId(final int errorResId) {
            this.errorResId = errorResId;
            return this;
        }

        public Builder withPath(final String path) {
            this.path = path;
            this.drawableId = 0;
            return this;
        }

        public Builder withPlaceholderResId(final int placeholderResId) {
            this.placeholderResId = placeholderResId;
            return this;
        }

        public Builder withScaleType(final ScaleType scaleType) {
            this.scaleType = scaleType;
            return this;
        }
    }
}
