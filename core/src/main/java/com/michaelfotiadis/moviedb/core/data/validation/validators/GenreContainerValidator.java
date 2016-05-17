package com.michaelfotiadis.moviedb.core.data.validation.validators;

import com.michaelfotiadis.moviedb.common.models.genre.Genre;
import com.michaelfotiadis.moviedb.common.models.genre.GenreContainer;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

/**
 *
 */
public class GenreContainerValidator implements Validator<GenreContainer> {

    @Override
    public ValidationResult validate(final GenreContainer items) {

        if (items == null) {
            return new ValidationResult(false, "Null genres");
        } else {

            final GenreValidator validator = new GenreValidator();

            for (final Genre genre : items.getGenres()) {

                final ValidationResult result = validator.validate(genre);

                if (!result.isValid()) {
                    return result;
                }
            }
        }
        return new ValidationResult(true);
    }
}
