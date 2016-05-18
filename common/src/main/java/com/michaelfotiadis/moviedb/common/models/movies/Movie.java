package com.michaelfotiadis.moviedb.common.models.movies;

import com.michaelfotiadis.moviedb.common.models.base.Media;

/**
 *
 */
public interface Movie extends Media {

    Boolean getAdult();

    Boolean getVideo();
}
