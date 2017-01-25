package com.michaelfotiadis.moviedb.ui.core.common.viewbinder;

import android.app.Activity;
import android.view.View;

import com.michaelfotiadis.moviedb.ui.core.common.viewholder.BaseViewHolder;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;
import com.michaelfotiadis.moviedb.utils.view.ViewUtils;

/**
 *
 */
public abstract class BaseViewBinder<VH extends BaseViewHolder> {

    private final Activity mActivity;
    private final ImageFetcher mImageFetcher;
    private final IntentDispatcher mIntentDispatcher;

    protected BaseViewBinder(final Activity activity,
                             final ImageFetcher imageFetcher,
                             final IntentDispatcher intentDispatcher) {
        this.mActivity = activity;
        this.mImageFetcher = imageFetcher;
        this.mIntentDispatcher = intentDispatcher;
    }

    public Activity getActivity() {
        return mActivity;
    }

    protected ImageFetcher getImageFetcher() {
        return mImageFetcher;
    }

    public IntentDispatcher getIntentDispatcher() {
        return mIntentDispatcher;
    }

    public abstract void bind(final VH holder);

    public abstract void reset(final VH holder);

    public void showView(final View view, final boolean show) {
        ViewUtils.showView(view, show);
    }

}
