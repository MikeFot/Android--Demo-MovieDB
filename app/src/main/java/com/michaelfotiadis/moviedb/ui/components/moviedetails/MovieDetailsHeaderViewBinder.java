package com.michaelfotiadis.moviedb.ui.components.moviedetails;

import android.app.Activity;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.common.models.movies.details.MovieDetails;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.ui.core.common.viewbinder.BaseViewDataBinder;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;
import com.michaelfotiadis.moviedb.utils.AppLog;
import com.michaelfotiadis.moviedb.utils.text.AppTextUtils;

import java.util.List;

/**
 *
 */
public class MovieDetailsHeaderViewBinder extends BaseViewDataBinder<MovieDetailsHeaderViewHolder, MovieDetails> {

    private static final int DEFAULT_IMAGE_PLACEHOLDER = R.drawable.ic_placeholder_reel;

    protected MovieDetailsHeaderViewBinder(final Activity activity,
                                           final ImageFetcher imageFetcher,
                                           final IntentDispatcher intentDispatcher) {
        super(activity, imageFetcher, intentDispatcher);
    }

    @Override
    public void bind(final MovieDetailsHeaderViewHolder holder, final MovieDetails item) {

        getImageFetcher().loadIntoImageView(
                buildUrl(item.getBackdropPath()),
                DEFAULT_IMAGE_PLACEHOLDER,
                holder.image);
        holder.title.setText(String.format("\"%s\"", item.getTagline()));

        if (AppTextUtils.containsIgnoreCase(item.getStatus(), "Released")) {
            holder.status.setText(R.string.text_out_now);
        } else {
            holder.status.setText(item.getStatus());
        }

    }

    @Override
    public void reset(final MovieDetailsHeaderViewHolder holder) {

    }

    private static String buildUrl(final String path) {
        final String base = DemoCore.getImageBaseUrl();


        final List<String> posterSizes = DemoCore.getPreferenceManager().getConfiguration().getImages().getPosterSizes();

        final int position;
        if (posterSizes.size() >= 2) {
            position = posterSizes.size() - 1;
        } else {
            position = 0;
        }

        final String size = posterSizes.get(position);
        final String url = base + size + path;
        AppLog.d("ImageUrl: Final image url is " + url);
        return url;
    }
}
