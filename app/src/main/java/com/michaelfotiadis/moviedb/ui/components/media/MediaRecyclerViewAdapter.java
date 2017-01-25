package com.michaelfotiadis.moviedb.ui.components.media;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelfotiadis.moviedb.data.model.UiMedia;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.adapter.BaseRecyclerViewAdapter;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MediaRecyclerViewAdapter extends BaseRecyclerViewAdapter<UiMedia, MediaRecyclerViewHolder> {

    private final MediaRecyclerBinder mBinder;

    public MediaRecyclerViewAdapter(final Activity activity,
                                    final ImageFetcher imageFetcher,
                                    final IntentDispatcher intentDispatcher) {
        super(activity, imageFetcher, intentDispatcher);
        mBinder = new MediaRecyclerBinder(activity, getImageFetcher(), getIntentDispatcher());
    }

    @Override
    protected boolean isItemValid(final UiMedia item) {
        return item != null;
    }

    @Override
    public MediaRecyclerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        final View view = LayoutInflater.from(parent.getContext())
                .inflate(MediaRecyclerViewHolder.getLayoutId(), parent, false);

        return new MediaRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MediaRecyclerViewHolder holder,
                                 final int position) {

        final UiMedia item = getItem(position);

        mBinder.bind(holder, item);

    }

    private List<UiMedia> filter(final List<UiMedia> items, String query) {
        query = query.toLowerCase();

        final List<UiMedia> filteredModelList = new ArrayList<>();
        for (final UiMedia item : items) {
            final String text = item.getTitle().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(item);
            }
        }
        return filteredModelList;
    }

}
