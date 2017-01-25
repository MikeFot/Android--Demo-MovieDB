package com.michaelfotiadis.moviedb.core.data.validation.validators;

import com.michaelfotiadis.moviedb.common.models.movies.Movie;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

/**
 *
 */
public class MovieValidator implements Validator<Movie> {

    @Override
    public ValidationResult validate(final Movie item) {
        if (item == null) {
            return new ValidationResult(false, "Null Movie container");
        } else if (item.getId() == null) {
            return new ValidationResult(false, "Null Movie id");
        } else {
            return new ValidationResult(true);
        }
    }
}
