package com.michaelfotiadis.moviedb.ui.core.common.recyclerview.viewbinder;

import android.content.Context;
import android.view.View;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.viewholder.BaseRecyclerViewHolder;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;
import com.michaelfotiadis.moviedb.utils.view.ViewUtils;

/**
 *
 */
public abstract class BaseRecyclerViewBinder<VH extends BaseRecyclerViewHolder, D extends AppModel> {

    private final Context mContext;
    private final ImageFetcher mImageFetcher;
    private final IntentDispatcher mIntentDispatcher;

    protected BaseRecyclerViewBinder(final Context context,
                                     final ImageFetcher imageFetcher,
                                     final IntentDispatcher intentDispatcher) {
        this.mContext = context;
        this.mImageFetcher = imageFetcher;
        this.mIntentDispatcher = intentDispatcher;
    }

    protected Context getContext() {
        return mContext;
    }

    protected ImageFetcher getImageFetcher() {
        return mImageFetcher;
    }

    protected IntentDispatcher getIntentDispatcher() {
        return mIntentDispatcher;
    }

    protected abstract void bind(final VH holder, final D item);

    protected abstract void reset(final VH holder);

    protected void showView(final View view, final boolean show) {
        ViewUtils.showView(view, show);
    }

}
