package com.michaelfotiadis.moviedb.core.data.validation.validators;

import android.text.TextUtils;

import com.michaelfotiadis.moviedb.common.models.guest.GuestSession;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

/**
 *
 */
public class GuestSessionValidator implements Validator<GuestSession> {

    @Override
    public ValidationResult validate(final GuestSession item) {
        if (item == null) {
            return new ValidationResult(false, "Null GuestSession container");
        } else if (TextUtils.isEmpty(item.getId())) {
            return new ValidationResult(false, "Empty session id");
        } else {
            return new ValidationResult(true);
        }
    }
}
