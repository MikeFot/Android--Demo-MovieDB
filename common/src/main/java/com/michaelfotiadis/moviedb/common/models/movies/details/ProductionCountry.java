package com.michaelfotiadis.moviedb.common.models.movies.details;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithStringId;

/**
 *
 */
public interface ProductionCountry extends AppModel, WithStringId {
    String getIso31661();

    String getName();
}
