package com.michaelfotiadis.moviedb.common.models.movies;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithLongId;

import java.util.List;

/**
 *
 */
public interface MoviesContainer extends AppModel, WithLongId {
    Integer getPage();

    List<Movie> getMovies();

    Integer getTotalPages();

    Integer getTotalResults();
}
