package com.michaelfotiadis.moviedb.ui.components.movie;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.graphics.drawable.DrawableCompat;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.common.models.movies.Movie;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.viewbinder.BaseRecyclerViewBinder;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;
import com.michaelfotiadis.moviedb.utils.date.DateUtils;

import java.util.Random;

import butterknife.ButterKnife;

/**
 *
 */
public class MovieRecyclerBinder extends BaseRecyclerViewBinder<MovieRecyclerViewHolder, Movie> {

    private static final int DEFAULT_IMAGE_PLACEHOLDER = R.drawable.ic_movie;

    protected MovieRecyclerBinder(final Context context,
                                  final ImageFetcher imageFetcher,
                                  final IntentDispatcher intentDispatcher) {
        super(context, imageFetcher, intentDispatcher);
    }

    @Override
    public void bind(final MovieRecyclerViewHolder holder, final Movie item) {
        ButterKnife.bind(holder, holder.getRoot());
        if (item != null) {
            holder.title.setText(item.getTitle());
            holder.description.setText(item.getOverview());
            holder.rating.setText(String.valueOf(item.getVoteAverage()));
            holder.date.setText(DateUtils.getReleaseYear(item.getReleaseDate()));
        }
    }

    @Override
    public void reset(final MovieRecyclerViewHolder holder) {
        holder.title.setText("");
        holder.description.setText("");
        holder.rating.setText("");
        holder.date.setText("");
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

