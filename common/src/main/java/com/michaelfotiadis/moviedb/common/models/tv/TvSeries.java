package com.michaelfotiadis.moviedb.common.models.tv;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.WithLongId;

import java.util.List;

/**
 *
 */
public interface TvSeries extends AppModel, WithLongId {
    String getBackdropPath();

    String getFirstAirDate();

    List<Integer> getGenreIds();

    String getName();

    String getOriginalLanguage();

    String getOriginalName();

    List<String> getOriginCountry();

    String getOverview();

    Float getPopularity();

    String getPosterPath();

    Float getVoteAverage();

    Integer getVoteCount();
}
