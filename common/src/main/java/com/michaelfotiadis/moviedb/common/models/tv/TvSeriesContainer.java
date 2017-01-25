package com.michaelfotiadis.moviedb.common.models.tv;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithLongId;

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
