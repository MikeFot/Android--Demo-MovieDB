package com.michaelfotiadis.moviedb.ui.components.people;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.common.models.people.KnownFor;
import com.michaelfotiadis.moviedb.common.models.people.Person;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.viewbinder.BaseRecyclerViewBinder;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;
import com.michaelfotiadis.moviedb.utils.AppLog;
import com.michaelfotiadis.moviedb.utils.date.DateUtils;

import java.util.List;
import java.util.Random;

/**
 *
 */
public class PeopleRecyclerBinder extends BaseRecyclerViewBinder<PeopleRecyclerViewHolder, Person> {

    private static final int DEFAULT_IMAGE_PLACEHOLDER = R.drawable.ic_movie;

    protected PeopleRecyclerBinder(final Context context,
                                   final ImageFetcher imageFetcher,
                                   final IntentDispatcher intentDispatcher) {
        super(context, imageFetcher, intentDispatcher);
    }

    @Override
    public void bind(final PeopleRecyclerViewHolder holder,
                     final Person item) {
        if (item != null) {
            holder.title.setText(item.getName());
            getImageFetcher().loadIntoImageView(
                    buildUrl(item.getProfilePath()),
                    holder.poster);

            if (item.getKnownFor().size() >= 3) {
                setUpPreview(holder.thirdMovie, item.getKnownFor().get(2));
            } else {
                showView(holder.thirdMovie, false);
            }
            if (item.getKnownFor().size() >= 2) {
                setUpPreview(holder.secondMovie, item.getKnownFor().get(1));
            } else {
                showView(holder.secondMovie, false);
            }
            if (item.getKnownFor().size() >= 1) {
                setUpPreview(holder.firstMovie, item.getKnownFor().get(0));
            } else {
                showView(holder.firstMovie, false);
            }
        }
    }

    private void setUpPreview(final View view, final KnownFor knownFor) {
        final MoviePreviewViewHolder preview = new MoviePreviewViewHolder(view);
        preview.title.setText(knownFor.getTitle());
        preview.rating.setText(String.valueOf(knownFor.getVoteAverage()));
        preview.date.setText(DateUtils.getReleaseYear(knownFor.getReleaseDate()));
        final String url = buildUrl(knownFor.getPosterPath());
        getImageFetcher().loadIntoImageView(url, preview.poster);
    }

    @Override
    public void reset(final PeopleRecyclerViewHolder holder) {
//        holder.image.setImageDrawable(ActivityCompat.getDrawable(getContext(), DEFAULT_IMAGE_PLACEHOLDER));
//        holder.title.setText("");
//        holder.subTitle.setText("");
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

    private static String buildUrl(final String path) {
        final String base = DemoCore.getImageBaseUrl();


        final List<String> posterSizes = DemoCore.getPreferenceManager().getConfiguration().getImages().getPosterSizes();

        final int position;
        if (posterSizes.size() >= 3) {
            position = posterSizes.size() - 2;
        } else {
            position = 0;
        }

        final String size = posterSizes.get(position);
        final String url = base + size + path;
        AppLog.d("ImageUrl: Final image url is " + url);
        return url;
    }

}

