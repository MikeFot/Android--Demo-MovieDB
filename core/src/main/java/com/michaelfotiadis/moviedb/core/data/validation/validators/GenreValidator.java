package com.michaelfotiadis.moviedb.core.data.validation.validators;

import com.michaelfotiadis.moviedb.common.models.genre.Genre;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

/**
 *
 */
public class GenreValidator implements Validator<Genre> {

    @Override
    public ValidationResult validate(final Genre item) {
        if (item == null) {
            return new ValidationResult(false, "Null Genre container");
        } else {
            return new ValidationResult(true);
        }
    }
}
