package com.michaelfotiadis.moviedb.common.models.movies.details;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.WithStringId;

/**
 *
 */
public interface ProductionCountry extends AppModel, WithStringId {
    String getIso31661();

    String getName();
}
