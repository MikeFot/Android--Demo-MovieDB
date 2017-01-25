package com.michaelfotiadis.moviedb.core.data.validation.validators;

import com.michaelfotiadis.moviedb.common.models.tv.TvSeries;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesContainer;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

/**
 *
 */
public class TvSeriesContainerValidator implements Validator<TvSeriesContainer> {

    @Override
    public ValidationResult validate(final TvSeriesContainer items) {

        if (items == null) {
            return new ValidationResult(false, "Null TvSeriesContainer container");
        } else {

            final TvSeriesValidator validator = new TvSeriesValidator();

            for (final TvSeries series : items.getSeries()) {
                if (!validator.validate(series).isValid()) {
                    return validator.validate(series);
                }
            }
        }
        return new ValidationResult(true);
    }
}
