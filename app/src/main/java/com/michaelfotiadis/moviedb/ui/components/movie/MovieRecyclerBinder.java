package com.michaelfotiadis.moviedb.ui.components.movie;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.graphics.drawable.DrawableCompat;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.common.models.movies.Movie;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.viewbinder.BaseRecyclerViewBinder;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;

import java.util.Random;

/**
 *
 */
public class MovieRecyclerBinder extends BaseRecyclerViewBinder<MovieRecyclerViewHolder, Movie> {

    private static final int DEFAULT_IMAGE_PLACEHOLDER = R.drawable.ic_movie;

    protected MovieRecyclerBinder(final Context context, final IntentDispatcher intentDispatcher) {
        super(context, intentDispatcher);
    }

    @Override
    public void bind(final MovieRecyclerViewHolder holder, final Movie item) {
        if (item != null) {
            holder.title.setText(item.getTitle());
            holder.subTitle.setText(item.getOriginalLanguage());
        }
    }

    @Override
    public void reset(final MovieRecyclerViewHolder holder) {
        holder.image.setImageDrawable(ActivityCompat.getDrawable(getContext(), DEFAULT_IMAGE_PLACEHOLDER));
        holder.title.setText("");
        holder.subTitle.setText("");
    }

    private Drawable getDrawable(final Integer resId) {
        final Drawable drawable;
        if (resId == null) {
            drawable = ActivityCompat.getDrawable(getContext(), DEFAULT_IMAGE_PLACEHOLDER);
            final Random rnd = new Random();
            final int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            DrawableCompat.setTint(drawable, color);
        } else {
            drawable = ActivityCompat.getDrawable(getContext(), resId);
        }
        return drawable;
    }

}

