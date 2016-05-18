package com.michaelfotiadis.moviedb.common.models.configuration;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithLongId;

import java.util.List;

/**
 *
 */
public interface Configuration extends AppModel, WithLongId {
    List<String> getChangeKeys();

    Images getImages();
}
