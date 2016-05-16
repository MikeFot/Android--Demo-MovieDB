package com.michaelfotiadis.moviedb.ui.core.common.recyclerview.viewbinder;

import android.content.Context;
import android.view.View;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.viewholder.BaseRecyclerViewHolder;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;
import com.michaelfotiadis.moviedb.utils.view.ViewUtils;

/**
 *
 */
public abstract class BaseRecyclerViewBinder<VH extends BaseRecyclerViewHolder, D extends AppModel> {

    private final Context mContext;
    private final IntentDispatcher mIntentDispatcher;

    protected BaseRecyclerViewBinder(final Context context, final IntentDispatcher intentDispatcher) {
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
