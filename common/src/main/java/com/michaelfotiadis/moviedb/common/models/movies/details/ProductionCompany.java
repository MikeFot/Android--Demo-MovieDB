package com.michaelfotiadis.moviedb.common.models.movies.details;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.WithLongId;

/**
 *
 */
public interface ProductionCompany extends AppModel, WithLongId {
    String getName();
}
