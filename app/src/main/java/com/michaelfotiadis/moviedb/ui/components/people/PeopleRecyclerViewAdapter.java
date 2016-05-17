package com.michaelfotiadis.moviedb.ui.components.people;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelfotiadis.moviedb.common.models.people.Person;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.adapter.BaseRecyclerViewAdapter;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class PeopleRecyclerViewAdapter extends BaseRecyclerViewAdapter<Person, PeopleRecyclerViewHolder> {

    private final PeopleRecyclerBinder mBinder;

    public PeopleRecyclerViewAdapter(final Activity activity,
                                     final ImageFetcher imageFetcher,
                                     final IntentDispatcher intentDispatcher) {
        super(activity, imageFetcher, intentDispatcher);
        mBinder = new PeopleRecyclerBinder(activity, imageFetcher, intentDispatcher);
    }

    @Override
    protected boolean isItemValid(final Person item) {
        return item != null && item.getId() != null;
    }

    @Override
    public PeopleRecyclerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        final View view = LayoutInflater.from(parent.getContext())
                .inflate(PeopleRecyclerViewHolder.getLayoutId(), parent, false);

        return new PeopleRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PeopleRecyclerViewHolder holder,
                                 final int position) {

        final Person item = getItem(position);

        mBinder.bind(holder, item);

    }

    private List<Person> filter(final List<Person> items, String query) {
        query = query.toLowerCase();

        final List<Person> filteredModelList = new ArrayList<>();
        for (final Person item : items) {
            final String text = item.getName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(item);
            }
        }
        return filteredModelList;
    }

}
