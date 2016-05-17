package com.michaelfotiadis.moviedb.core.data.validation.validators;

import android.text.TextUtils;

import com.michaelfotiadis.moviedb.common.models.configuration.Configuration;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

/**
 *
 */
public class ConfigurationValidator implements Validator<Configuration> {

    @Override
    public ValidationResult validate(final Configuration item) {
        if (item == null) {
            return new ValidationResult(false, "Null Configuration container");
        } else if (item.getImages() == null) {
            return new ValidationResult(false, "Null Configuration images");
        } else if (TextUtils.isEmpty(item.getImages().getBaseUrl())) {
            return new ValidationResult(false, "Null base url");
        } else {
            return new ValidationResult(true);
        }
    }
}
