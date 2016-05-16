package com.michaelfotiadis.moviedb.common.models.movies;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.WithLongId;

import java.util.List;

/**
 *
 */
public interface Movie extends AppModel, WithLongId {
    Boolean getAdult();

    String getBackdropPath();

    List<Integer> getGenreIds();

    String getOriginalLanguage();

    String getOriginalTitle();

    String getOverview();

    Float getPopularity();

    String getPosterPath();

    String getReleaseDate();

    String getTitle();

    Boolean getVideo();

    Float getVoteAverage();

    Integer getVoteCount();
}
