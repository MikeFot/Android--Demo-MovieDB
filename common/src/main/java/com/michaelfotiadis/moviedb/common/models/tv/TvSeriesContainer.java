package com.michaelfotiadis.moviedb.common.models.tv;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.WithLongId;

import java.util.List;

/**
 *
 */
public interface TvSeriesContainer extends AppModel, WithLongId {
    Integer getPage();

    List<TvSeries> getSeries();

    Integer getTotalPages();

    Integer getTotalResults();
}
