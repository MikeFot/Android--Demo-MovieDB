package com.michaelfotiadis.moviedb.ui.components.movie;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelfotiadis.moviedb.common.models.movies.Movie;
import com.michaelfotiadis.moviedb.data.model.UiMovie;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.adapter.BaseRecyclerViewAdapter;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MovieRecyclerViewAdapter extends BaseRecyclerViewAdapter<UiMovie, MovieRecyclerViewHolder> {

    private final MovieRecyclerBinder mBinder;

    public MovieRecyclerViewAdapter(final Activity activity) {
        super(activity);
        mBinder = new MovieRecyclerBinder(activity, getImageFetcher(), getIntentDispatcher());
    }

    public MovieRecyclerViewAdapter(final Activity activity,
                                    final ImageFetcher imageFetcher,
                                    final IntentDispatcher intentDispatcher) {
        super(activity, imageFetcher, intentDispatcher);
        mBinder = new MovieRecyclerBinder(activity, getImageFetcher(), getIntentDispatcher());
    }

    @Override
    protected boolean isItemValid(final UiMovie item) {
        return item != null;
    }

    @Override
    public MovieRecyclerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        final View view = LayoutInflater.from(parent.getContext())
                .inflate(MovieRecyclerViewHolder.getLayoutId(), parent, false);

        return new MovieRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieRecyclerViewHolder holder,
                                 final int position) {

        final UiMovie item = getItem(position);

        mBinder.bind(holder, item);

    }

    private List<Movie> filter(final List<Movie> items, String query) {
        query = query.toLowerCase();

        final List<Movie> filteredModelList = new ArrayList<>();
        for (final Movie item : items) {
            final String text = item.getTitle().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(item);
            }
        }
        return filteredModelList;
    }

}
