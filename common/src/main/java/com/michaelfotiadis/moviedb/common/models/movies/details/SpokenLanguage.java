package com.michaelfotiadis.moviedb.common.models.movies.details;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.WithStringId;

/**
 *
 */
public interface SpokenLanguage extends AppModel, WithStringId {
    String getIso6391();

    String getName();
}
