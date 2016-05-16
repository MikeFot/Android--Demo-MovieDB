package com.michaelfotiadis.moviedb.core.data.validation.validators;

import android.text.TextUtils;

import com.michaelfotiadis.moviedb.common.models.tv.TvSeries;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

/**
 *
 */
public class TvSeriesValidator implements Validator<TvSeries> {

    @Override
    public ValidationResult validate(final TvSeries item) {
        if (item == null) {
            return new ValidationResult(false, "Null TvSeries container");
        } else if (item.getId() == null) {
            return new ValidationResult(false, "Null TvSeries id");
        } else if (TextUtils.isEmpty(item.getName())) {
            return new ValidationResult(false, "Empty name in TvSeries");
        } else {
            return new ValidationResult(true);
        }
    }
}
