package com.michaelfotiadis.moviedb.ui.components.movie;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.graphics.drawable.DrawableCompat;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.data.model.UiMovie;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.viewbinder.BaseRecyclerViewBinder;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;

import java.util.Random;

import butterknife.ButterKnife;

/**
 *
 */
public class MovieRecyclerBinder extends BaseRecyclerViewBinder<MovieRecyclerViewHolder, UiMovie> {

    private static final int DEFAULT_IMAGE_PLACEHOLDER = R.drawable.ic_movie;

    protected MovieRecyclerBinder(final Context context,
                                  final ImageFetcher imageFetcher,
                                  final IntentDispatcher intentDispatcher) {
        super(context, imageFetcher, intentDispatcher);
    }

    @Override
    public void bind(final MovieRecyclerViewHolder holder, final UiMovie item) {
        ButterKnife.bind(holder, holder.getRoot());
        if (item != null) {
            holder.title.setText(item.getTitle());
            holder.description.setText(item.getDescription());
            holder.rating.setText(item.getRating());
            holder.date.setText(item.getYear());
            holder.genres.setText(item.getGenres());
            getImageFetcher().loadIntoImageView(
                    item.getPosterUrl(),
                    holder.poster
            );
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

