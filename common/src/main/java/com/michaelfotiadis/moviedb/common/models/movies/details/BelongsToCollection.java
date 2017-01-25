package com.michaelfotiadis.moviedb.common.models.movies.details;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithLongId;

/**
 *
 */
public interface BelongsToCollection extends AppModel, WithLongId {
    String getBackdropPath();

    String getName();

    String getPosterPath();
}
