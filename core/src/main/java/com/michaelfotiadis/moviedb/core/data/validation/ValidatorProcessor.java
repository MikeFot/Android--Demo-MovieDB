package com.michaelfotiadis.moviedb.core.data.validation;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.core.data.validation.validators.Validator;

/**
 *
 */
public interface ValidatorProcessor {
    <T extends AppModel> Validator<T> getValidator(Class<T> clazz);
}
