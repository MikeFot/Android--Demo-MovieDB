package com.michaelfotiadis.moviedb.data.model;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithLongId;

/**
 *
 */
public interface UiMedia extends AppModel, WithLongId {
    UiMediaType getType();

    String getDescription();

    String getGenres();

    String getPosterUrl();

    String getRating();

    String getTitle();

    String getYear();
}
