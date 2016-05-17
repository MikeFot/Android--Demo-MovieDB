package com.michaelfotiadis.moviedb.data.factory;

import com.michaelfotiadis.moviedb.common.models.genre.Genre;
import com.michaelfotiadis.moviedb.common.models.movies.Movie;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.data.model.UiMovie;
import com.michaelfotiadis.moviedb.utils.AppLog;
import com.michaelfotiadis.moviedb.utils.date.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class UiMovieFactory {

    final List<Movie> mMovies = new ArrayList<>();
    final List<Genre> mGenres = new ArrayList<>();
    final List<UiMovie> mUiMovies = new ArrayList<>();

    public List<UiMovie> create() {
        mUiMovies.clear();

        for (final Movie movie : mMovies) {
            mUiMovies.add(UiMovie.newBuilder()
                    .withId(movie.getId())
                    .withDescription(movie.getOverview())
                    .withTitle(movie.getTitle())
                    .withYear(DateUtils.getReleaseYear(movie.getReleaseDate()))
                    .withGenres(buildGenreText(movie.getGenreIds(), mGenres))
                    .withPosterUrl(buildUrl(movie.getPosterPath()))
                    .withRating(String.valueOf(movie.getVoteAverage()))
                    .build());

        }

        return mUiMovies;
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

    public void setMovies(final List<Movie> movies) {
        mMovies.clear();
        mMovies.addAll(movies);
    }
}
