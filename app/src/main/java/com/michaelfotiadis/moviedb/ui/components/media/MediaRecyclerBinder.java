package com.michaelfotiadis.moviedb.ui.components.media;

import android.content.Context;
import android.view.View;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.data.model.UiMedia;
import com.michaelfotiadis.moviedb.data.model.UiMediaType;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.viewbinder.BaseRecyclerViewBinder;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;
import com.michaelfotiadis.moviedb.utils.AppLog;

import butterknife.ButterKnife;

/**
 *
 */
public class MediaRecyclerBinder extends BaseRecyclerViewBinder<MediaRecyclerViewHolder, UiMedia> {

    private static final int DEFAULT_IMAGE_PLACEHOLDER = R.drawable.ic_movie;

    protected MediaRecyclerBinder(final Context context,
                                  final ImageFetcher imageFetcher,
                                  final IntentDispatcher intentDispatcher) {
        super(context, imageFetcher, intentDispatcher);
    }

    @Override
    public void bind(final MediaRecyclerViewHolder holder, final UiMedia item) {
        ButterKnife.bind(holder, holder.getRoot());
        if (item != null) {
            holder.title.setText(item.getTitle());
            holder.description.setText(item.getDescription());
            holder.rating.setText(item.getRating());
            holder.date.setText(item.getYear());
            holder.genres.setText(item.getGenres());
            getImageFetcher().loadIntoImageView(
                    item.getPosterUrl(),
                    DEFAULT_IMAGE_PLACEHOLDER,
                    holder.poster
            );

            holder.moreInfoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {

                    if (item.getType().equals(UiMediaType.MOVIE)) {

                        getIntentDispatcher().openMovieDetailsActivity(holder.poster, String.valueOf(item.getId()));
                    } else {
                        AppLog.w("Not implemented yet");
                    }
                }
            });

        }
    }

    @Override
    public void reset(final MediaRecyclerViewHolder holder) {
        holder.title.setText("");
        holder.description.setText("");
        holder.rating.setText("");
        holder.date.setText("");
    }

}

