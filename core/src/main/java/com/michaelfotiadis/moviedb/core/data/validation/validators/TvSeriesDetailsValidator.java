package com.michaelfotiadis.moviedb.core.data.validation.validators;

import com.michaelfotiadis.moviedb.common.models.tv.details.TvSeriesDetails;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

/**
 *
 */
public class TvSeriesDetailsValidator implements Validator<TvSeriesDetails> {

    @Override
    public ValidationResult validate(final TvSeriesDetails item) {
        if (item == null) {
            return new ValidationResult(false, "Null TvSeriesDetails container");
        } else if (item.getId() == null) {
            return new ValidationResult(false, "Null TvSeriesDetails id");
        } else {
            return new ValidationResult(true);
        }
    }
}
