package com.michaelfotiadis.moviedb.ui.core.common.viewbinder;

import android.content.Context;
import android.view.View;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.ui.core.common.viewholder.BaseViewHolder;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;
import com.michaelfotiadis.moviedb.utils.view.ViewUtils;

/**
 *
 */
public abstract class BaseViewDataBinder<VH extends BaseViewHolder, D extends AppModel> {

    private final Context mContext;
    private final IntentDispatcher mIntentDispatcher;

    protected BaseViewDataBinder(final Context context, final IntentDispatcher intentDispatcher) {
        this.mContext = context;
        this.mIntentDispatcher = intentDispatcher;
    }

    public Context getContext() {
        return mContext;
    }

    public IntentDispatcher getIntentDispatcher() {
        return mIntentDispatcher;
    }

    public abstract void bind(final VH holder, final D item);

    public abstract void reset(final VH holder);

    public void showView(final View view, final boolean show) {
        ViewUtils.showView(view, show);
    }

}
