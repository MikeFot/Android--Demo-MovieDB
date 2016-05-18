package com.michaelfotiadis.moviedb.ui.components.moviedetails;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.common.models.movies.details.MovieDetails;
import com.michaelfotiadis.moviedb.ui.components.moviedetails.utils.MovieDetailsUtils;
import com.michaelfotiadis.moviedb.ui.core.common.viewbinder.BaseViewDataBinder;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;

import java.util.Locale;

/**
 *
 */
public class MovieDetailsBodyViewBinder extends BaseViewDataBinder<MovieDetailsBodyViewHolder, MovieDetails> {

    private static final int DEFAULT_IMAGE_PLACEHOLDER = R.drawable.ic_placeholder_reel;

    protected MovieDetailsBodyViewBinder(final Context context,
                                         final ImageFetcher imageFetcher,
                                         final IntentDispatcher intentDispatcher) {
        super(context, imageFetcher, intentDispatcher);
    }

    @Override
    public void bind(final MovieDetailsBodyViewHolder holder, final MovieDetails item) {

        holder.duration.setText(String.format(Locale.UK, "Duration: %d mins", item.getRuntime()));
        holder.releasedDate.setText(String.format("Release: %s", item.getReleaseDate()));
        holder.description.setText(item.getOverview());

        holder.link.setClickable(true);
        holder.link.setText(Html.fromHtml(item.getHomepage()));
        holder.link.setMovementMethod(LinkMovementMethod.getInstance());

        holder.revenue.setText(MovieDetailsUtils.getRevenue(item.getRevenue()));

        holder.rating.setText(String.valueOf(item.getVoteAverage()));

        holder.genres.setText(MovieDetailsUtils.getGenres(item.getGenres()));

        holder.language.setText(String.format("Language: %s", item.getOriginalLanguage().toUpperCase()));

        getImageFetcher().loadIntoImageView(
                MovieDetailsUtils.getPosterUrl(item.getPosterPath()),
                DEFAULT_IMAGE_PLACEHOLDER,
                holder.poster
        );
    }

    @Override
    public void reset(final MovieDetailsBodyViewHolder holder) {

    }

}
