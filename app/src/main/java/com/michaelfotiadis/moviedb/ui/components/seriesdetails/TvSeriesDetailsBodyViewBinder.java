package com.michaelfotiadis.moviedb.ui.components.seriesdetails;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.common.models.tv.details.TvSeriesDetails;
import com.michaelfotiadis.moviedb.ui.components.moviedetails.utils.MovieDetailsUtils;
import com.michaelfotiadis.moviedb.ui.core.common.viewbinder.BaseViewDataBinder;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;

import java.util.Locale;

/**
 *
 */
public class TvSeriesDetailsBodyViewBinder extends BaseViewDataBinder<TvSeriesDetailsBodyViewHolder, TvSeriesDetails> {

    private static final int DEFAULT_IMAGE_PLACEHOLDER = R.drawable.ic_tv;

    protected TvSeriesDetailsBodyViewBinder(final Context context,
                                            final ImageFetcher imageFetcher,
                                            final IntentDispatcher intentDispatcher) {
        super(context, imageFetcher, intentDispatcher);
    }

    @Override
    public void bind(final TvSeriesDetailsBodyViewHolder holder, final TvSeriesDetails item) {

        // TODO do this properly, but good enough for the demo

        holder.duration.setText(String.format(Locale.UK, "Duration: %d mins", item.getEpisodeRunTime().get(0)));
        holder.releasedDate.setText(String.format("Last Episode: %s", item.getLastAirDate()));
        holder.description.setText(item.getOverview());

        holder.link.setClickable(true);
        holder.link.setText(Html.fromHtml(item.getHomepage()));
        holder.link.setMovementMethod(LinkMovementMethod.getInstance());

        holder.revenue.setText(String.format(Locale.UK, "Episodes: %d", item.getNumberOfEpisodes()));

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
    public void reset(final TvSeriesDetailsBodyViewHolder holder) {

    }

}
