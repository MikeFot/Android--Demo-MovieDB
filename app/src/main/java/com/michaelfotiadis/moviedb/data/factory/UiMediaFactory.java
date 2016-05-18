package com.michaelfotiadis.moviedb.data.factory;

import com.michaelfotiadis.moviedb.common.models.base.Media;
import com.michaelfotiadis.moviedb.common.models.genre.Genre;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.data.model.UiMedia;
import com.michaelfotiadis.moviedb.data.model.UiMediaImpl;
import com.michaelfotiadis.moviedb.utils.AppLog;
import com.michaelfotiadis.moviedb.utils.date.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class UiMediaFactory<T extends Media> {

    final List<T> mMediaList = new ArrayList<>();
    final List<Genre> mGenres = new ArrayList<>();
    final List<UiMedia> mUiMedia = new ArrayList<>();

    public List<UiMedia> create() {
        mUiMedia.clear();

        for (final T media : mMediaList) {
            mUiMedia.add(UiMediaImpl.newBuilder()
                    .withId(media.getId())
                    .withDescription(media.getOverview())
                    .withTitle(media.getTitle())
                    .withYear(DateUtils.getReleaseYear(media.getReleaseDate()))
                    .withGenres(buildGenreText(media.getGenreIds(), mGenres))
                    .withPosterUrl(buildUrl(media.getPosterPath()))
                    .withRating(String.valueOf(media.getVoteAverage()))
                    .build());

        }

        return mUiMedia;
    }

    private String buildGenreText(final List<Integer> genreIds, final List<Genre> genres) {
        final StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (final Integer id : genreIds) {
            for (final Genre genre : genres) {

                if (genre.getId().equals(Long.valueOf(id))) {
                    sb.append(prefix);
                    prefix = ", ";
                    sb.append(genre.getName());
                }
            }

        }
        return sb.toString();

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


    public void setGenres(final List<Genre> genres) {
        mGenres.clear();
        mGenres.addAll(genres);
    }

    public void setMedia(final List<T> mediaList) {
        mMediaList.clear();
        mMediaList.addAll(mediaList);
    }
}
