package com.michaelfotiadis.moviedb.ui.components.tv;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.viewholder.BaseRecyclerViewHolder;

import butterknife.Bind;


public final class TvRecyclerViewHolder extends BaseRecyclerViewHolder {

    private static final int LAYOUT_ID = R.layout.list_item_two_lines_image;
    @Bind(R.id.line1)
    protected TextView title;
    @Bind(R.id.line2)
    protected TextView subTitle;
    @Bind(R.id.image)
    protected ImageView image;

    public TvRecyclerViewHolder(final View view) {
        super(view);
    }

    public static int getLayoutId() {
        return LAYOUT_ID;
    }

}