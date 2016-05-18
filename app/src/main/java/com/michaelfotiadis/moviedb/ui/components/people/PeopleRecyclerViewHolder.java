package com.michaelfotiadis.moviedb.ui.components.people;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.viewholder.BaseRecyclerViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;


public final class PeopleRecyclerViewHolder extends BaseRecyclerViewHolder {

    private static final int LAYOUT_ID = R.layout.list_item_person_overview;
    @Bind(R.id.poster)
    protected ImageView poster;
    @Bind(R.id.title)
    protected TextView title;
    @Bind(R.id.movie_1)
    protected RelativeLayout firstMovie;
    @Bind(R.id.movie_2)
    protected RelativeLayout secondMovie;
    @Bind(R.id.movie_3)
    protected RelativeLayout thirdMovie;

    public PeopleRecyclerViewHolder(final View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public static int getLayoutId() {
        return LAYOUT_ID;
    }

}