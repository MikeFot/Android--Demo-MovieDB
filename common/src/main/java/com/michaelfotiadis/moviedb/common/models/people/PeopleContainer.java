package com.michaelfotiadis.moviedb.common.models.people;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.WithLongId;

import java.util.List;

/**
 *
 */
public interface PeopleContainer extends AppModel, WithLongId {
    Integer getPage();

    List<Person> getPeople();

    Integer getTotalPages();

    Integer getTotalResults();
}
