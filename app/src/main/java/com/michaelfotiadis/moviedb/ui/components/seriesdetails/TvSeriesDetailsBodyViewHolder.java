package com.michaelfotiadis.moviedb.ui.components.seriesdetails;

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
public class TvSeriesDetailsBodyViewHolder extends BaseViewHolder {

    @Bind(R.id.description)
    protected TextView description;
    @Bind(R.id.poster)
    protected ImageView poster;
    @Bind(R.id.duration)
    protected TextView duration;
    @Bind(R.id.revenue)
    protected TextView revenue;
    @Bind(R.id.released_date)
    protected TextView releasedDate;
    @Bind(R.id.link)
    protected TextView link;
    @Bind(R.id.genres)
    protected TextView genres;
    @Bind(R.id.language)
    protected TextView language;
    @Bind(R.id.rating)
    protected TextView rating;

    public TvSeriesDetailsBodyViewHolder(final View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
