package com.michaelfotiadis.moviedb.common.models.people;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.WithLongId;

import java.util.List;

/**
 *
 */
public interface Person extends AppModel, WithLongId {
    Boolean getAdult();

    List<KnownFor> getKnownFor();

    String getName();

    Float getPopularity();

    String getProfilePath();
}
