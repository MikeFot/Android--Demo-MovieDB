package com.michaelfotiadis.moviedb.ui.components.tv;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelfotiadis.moviedb.common.models.tv.TvSeries;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.adapter.BaseRecyclerViewAdapter;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TvRecyclerViewAdapter extends BaseRecyclerViewAdapter<TvSeries, TvRecyclerViewHolder> {

    private final TvRecyclerBinder mBinder;

    public TvRecyclerViewAdapter(final Activity activity, final IntentDispatcher intentDispatcher) {
        super(activity, intentDispatcher);
        mBinder = new TvRecyclerBinder(activity, intentDispatcher);
    }

    @Override
    protected boolean isItemValid(final TvSeries item) {
        return item != null && item.getId() != null;
    }

    @Override
    public TvRecyclerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        final View view = LayoutInflater.from(parent.getContext())
                .inflate(TvRecyclerViewHolder.getLayoutId(), parent, false);

        return new TvRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TvRecyclerViewHolder holder,
                                 final int position) {

        final TvSeries item = getItem(position);

        mBinder.bind(holder, item);

    }

    private List<TvSeries> filter(final List<TvSeries> items, String query) {
        query = query.toLowerCase();

        final List<TvSeries> filteredModelList = new ArrayList<>();
        for (TvSeries item : items) {
            final String text = item.getName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(item);
            }
        }
        return filteredModelList;
    }

}
