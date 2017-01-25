package com.michaelfotiadis.moviedb.common.models.tv.details;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithLongId;

/**
 *
 */
public interface Network extends AppModel, WithLongId {
    String getName();
}
