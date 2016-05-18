package com.michaelfotiadis.moviedb.common.models.tv.details;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithLongId;

/**
 *
 */
public interface CreatedBy extends AppModel, WithLongId {
    String getName();

    String getProfilePath();
}
