package com.michaelfotiadis.moviedb.common.models.movies.details;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithStringId;

/**
 *
 */
public interface SpokenLanguage extends AppModel, WithStringId {
    String getIso6391();

    String getName();
}
