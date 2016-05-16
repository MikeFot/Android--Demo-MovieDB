package com.michaelfotiadis.moviedb.core.data.validation.validators;

import com.michaelfotiadis.moviedb.common.models.people.KnownFor;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

/**
 *
 */
public class KnownForValidator implements Validator<KnownFor> {

    @Override
    public ValidationResult validate(final KnownFor item) {
        if (item == null) {
            return new ValidationResult(false, "Null KnownFor container");
        } else if (item.getId() == null) {
            return new ValidationResult(false, "Null KnownFor id");
        } else {
            return new ValidationResult(true);
        }
    }
}
