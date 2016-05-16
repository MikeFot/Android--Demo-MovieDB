package com.michaelfotiadis.moviedb.core.data.validation.validators;

import com.michaelfotiadis.moviedb.common.models.movies.Movie;
import com.michaelfotiadis.moviedb.common.models.movies.MoviesContainer;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

/**
 *
 */
public class MoviesContainerValidator implements Validator<MoviesContainer> {

    @Override
    public ValidationResult validate(final MoviesContainer items) {

        if (items == null) {
            return new ValidationResult(false, "Null movies");
        } else {

            final MovieValidator validator = new MovieValidator();

            for (final Movie movie : items.getMovies()) {

                final ValidationResult result = validator.validate(movie);

                if (!result.isValid()) {
                    return result;
                }
            }
        }
        return new ValidationResult(true);
    }
}
