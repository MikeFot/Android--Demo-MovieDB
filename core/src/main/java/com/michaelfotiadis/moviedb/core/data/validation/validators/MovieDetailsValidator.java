package com.michaelfotiadis.moviedb.core.data.validation.validators;

import com.michaelfotiadis.moviedb.common.models.movies.details.MovieDetails;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

/**
 *
 */
public class MovieDetailsValidator implements Validator<MovieDetails> {

    @Override
    public ValidationResult validate(final MovieDetails item) {
        if (item == null) {
            return new ValidationResult(false, "Null MovieDetails container");
        } else if (item.getId() == null) {
            return new ValidationResult(false, "Null MovieDetails id");
        } else {
            return new ValidationResult(true);
        }
    }
}
