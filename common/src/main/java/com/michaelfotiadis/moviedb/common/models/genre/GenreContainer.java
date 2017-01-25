package com.michaelfotiadis.moviedb.common.models.genre;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithLongId;

import java.util.List;

/**
 *
 */
public interface GenreContainer extends AppModel, WithLongId {
    List<Genre> getGenres();
}
