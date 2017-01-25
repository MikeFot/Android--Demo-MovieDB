package com.michaelfotiadis.moviedb.core.data.validation.validators;

import android.text.TextUtils;

import com.michaelfotiadis.moviedb.common.models.people.KnownFor;
import com.michaelfotiadis.moviedb.common.models.people.Person;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

/**
 *
 */
public class PersonValidator implements Validator<Person> {

    @Override
    public ValidationResult validate(final Person item) {
        if (item == null) {
            return new ValidationResult(false, "Null Person container");
        } else if (item.getId() == null) {
            return new ValidationResult(false, "Null Person id");
        } else if (TextUtils.isEmpty(item.getName())) {
            return new ValidationResult(false, "Null Person name");
        } else {
            final KnownForValidator validator = new KnownForValidator();

            for (final KnownFor knownFor : item.getKnownFor()) {
                final ValidationResult result = validator.validate(knownFor);
                if (!result.isValid()) {
                    return result;
                }
            }

            return new ValidationResult(true);
        }
    }
}
