package com.michaelfotiadis.moviedb.core.data.validation.validators;

import com.michaelfotiadis.moviedb.common.models.people.PeopleContainer;
import com.michaelfotiadis.moviedb.common.models.people.Person;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

/**
 *
 */
public class PeopleContainerValidator implements Validator<PeopleContainer> {

    @Override
    public ValidationResult validate(final PeopleContainer items) {

        if (items == null) {
            return new ValidationResult(false, "Null people container");
        } else {

            final PersonValidator validator = new PersonValidator();

            for (final Person person : items.getPeople()) {
                if (!validator.validate(person).isValid()) {
                    return validator.validate(person);
                }
            }
        }
        return new ValidationResult(true);
    }
}
