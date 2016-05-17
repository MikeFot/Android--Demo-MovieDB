package com.michaelfotiadis.moviedb.common.models.configuration;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.WithLongId;

import java.util.List;

/**
 *
 */
public interface Images extends AppModel, WithLongId {
    List<String> getBackdropSizes();

    String getBaseUrl();

    List<String> getLogoSizes();

    List<String> getPosterSizes();

    List<String> getProfileSizes();

    String getSecureBaseUrl();

    List<String> getStillSizes();
}
