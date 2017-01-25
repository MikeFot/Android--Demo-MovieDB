package com.michaelfotiadis.moviedb.common.models.tv;

import com.michaelfotiadis.moviedb.common.models.base.Media;

import java.util.List;

/**
 *
 */
public interface TvSeries extends Media {

    List<String> getOriginCountry();
}
