package com.michaelfotiadis.moviedb.ui.components.media;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.viewholder.BaseRecyclerViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;


public final class MediaRecyclerViewHolder extends BaseRecyclerViewHolder {

    private static final int LAYOUT_ID = R.layout.list_item_media_overview;
    @Bind(R.id.poster)
    protected ImageView poster;
    @Bind(R.id.description)
    protected TextView description;
    @Bind(R.id.title)
    protected TextView title;
    @Bind(R.id.rating)
    protected TextView rating;
    @Bind(R.id.date)
    protected TextView date;
    @Bind(R.id.genres)
    protected TextView genres;
    @Bind(R.id.more_info_button)
    protected Button moreInfoButton;


    public MediaRecyclerViewHolder(final View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public static int getLayoutId() {
        return LAYOUT_ID;
    }

}