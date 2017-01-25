package com.michaelfotiadis.moviedb.ui.components.people;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.ui.core.common.viewholder.BaseViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 */
public class MoviePreviewViewHolder extends BaseViewHolder {

    @Bind(R.id.poster)
    protected ImageView poster;
    @Bind(R.id.title)
    protected TextView title;
    @Bind(R.id.rating)
    protected TextView rating;
    @Bind(R.id.date)
    protected TextView date;

    public MoviePreviewViewHolder(final View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
