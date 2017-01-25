package com.michaelfotiadis.moviedb.common.models.genre;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithLongId;

/**
 *
 */
public interface Genre extends AppModel, WithLongId {
    String getName();
}
