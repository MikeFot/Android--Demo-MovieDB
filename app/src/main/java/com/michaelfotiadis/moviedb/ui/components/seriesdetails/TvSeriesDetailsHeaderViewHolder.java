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
public class TvSeriesDetailsHeaderViewHolder extends BaseViewHolder {

    @Bind(R.id.image)
    protected ImageView image;
    @Bind(R.id.title)
    protected TextView title;
    @Bind(R.id.status)
    protected TextView status;

    public TvSeriesDetailsHeaderViewHolder(final View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
