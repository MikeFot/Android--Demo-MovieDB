package com.michaelfotiadis.moviedb.ui.core.common.layouts;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import com.michaelfotiadis.moviedb.R;

public class AspectRatioEnforcingLayout extends FrameLayout {
    private static final boolean DEBUG = false;
    private double mAspectRatio;
    private String mAspectRatioString;

    public AspectRatioEnforcingLayout(final Context context) {
        super(context);
        init(context, null);
    }

    public AspectRatioEnforcingLayout(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AspectRatioEnforcingLayout(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AspectRatioEnforcingLayout(final Context context, final AttributeSet attrs, final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(final Context context, final AttributeSet attrs) {
        if (attrs == null) {
            mAspectRatio = 0f;
        } else {
            final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.aspectRatioEnforcing);
            final String aspectRatio = a.getString(R.styleable.aspectRatioEnforcing_aspectRatio);

            setAspectRatio(aspectRatio);
            a.recycle();
        }
    }

    private void log(final String message) {
        if (DEBUG) {
            Log.d(getClass().getSimpleName(), String.valueOf(hashCode()).toUpperCase() + ": " + message);
        }
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        final double localRatio = mAspectRatio;

        if (localRatio == 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            log("Aspect ratio forcing is disabled");
        } else {
            final int originalWidth = MeasureSpec.getSize(widthMeasureSpec);
            final int originalHeight = MeasureSpec.getSize(heightMeasureSpec);

            if (originalWidth == 0 && originalHeight == 0) {
                throw new IllegalArgumentException(
                        "Both width and height cannot be zero -- watch out for scrollable containers");
            }

            int lockedWidth = originalWidth;
            int lockedHeight = originalHeight;

            // Get the padding of the border background.
            final int hPadding = getPaddingLeft() + getPaddingRight();
            final int vPadding = getPaddingTop() + getPaddingBottom();

            // Resize the preview frame with correct aspect ratio.
            lockedWidth -= hPadding;
            lockedHeight -= vPadding;

            if (lockedHeight > 0 && (lockedWidth > lockedHeight * localRatio)) {
                lockedWidth = (int) (lockedHeight * localRatio + .5);
            } else {
                lockedHeight = (int) (lockedWidth / localRatio + .5);
            }

            // Add the padding of the border.
            lockedWidth += hPadding;
            lockedHeight += vPadding;

            // Ask children to follow the new preview dimension.

            if (DEBUG) {
                final String mesage = "Aspect Ratio=%f. Received dimens:(%d,%d) will force to (%d,%d)";

                log(String.format(mesage,
                        localRatio,
                        originalWidth,
                        originalHeight,
                        lockedWidth,
                        lockedHeight));
            }
            super.onMeasure(
                    MeasureSpec.makeMeasureSpec(lockedWidth, MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(lockedHeight, MeasureSpec.EXACTLY));
        }
    }

    /**
     * Sets the aspect ratio. It has to be formatted as "4:3".
     * The values can be integers only.
     *
     * @param aspectRatio The aspect ratio.
     */
    public void setAspectRatio(final String aspectRatio) {
        final String oldAspectRatioString = mAspectRatioString;

        if (TextUtils.isEmpty(aspectRatio)) {
            mAspectRatio = 0f;
        } else {
            try {
                final String[] array = aspectRatio.split(":");
                final float aspectRatioWidth = Float.valueOf(array[0]);
                final float aspectRatioHeight = Float.valueOf(array[1]);

                if (aspectRatioWidth < 0 || aspectRatioHeight < 0) {
                    throw new IllegalArgumentException();
                }

                mAspectRatio = aspectRatioWidth / aspectRatioHeight;
                mAspectRatioString = aspectRatio;
            } catch (final Exception e) {
                throw new IllegalArgumentException("Invalid aspect ratio: '" + aspectRatio + "'");
            }
        }

        if (DEBUG) {
            final String message = "Requested aspect ratioString='%s', oldRatioString='%s' calculatedRatio='%f'";
            log(String.format(message,
                    mAspectRatioString,
                    oldAspectRatioString,
                    mAspectRatio));
        }

        requestLayout();
        invalidate();
    }
}