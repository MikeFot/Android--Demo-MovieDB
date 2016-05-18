package com.michaelfotiadis.moviedb.common.models.base;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithLongId;

import java.util.List;

/**
 *
 */
public interface Media extends AppModel, WithLongId {

    String getBackdropPath();

    List<Integer> getGenreIds();

    String getOriginalLanguage();

    String getOriginalTitle();

    String getOverview();

    Float getPopularity();

    String getPosterPath();

    String getReleaseDate();

    String getTitle();

    Float getVoteAverage();

    Integer getVoteCount();
}
