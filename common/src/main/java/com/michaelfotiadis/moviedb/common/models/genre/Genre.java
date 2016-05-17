package com.michaelfotiadis.moviedb.common.models.genre;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.WithLongId;

/**
 *
 */
public interface Genre extends AppModel, WithLongId {
    String getName();
}
