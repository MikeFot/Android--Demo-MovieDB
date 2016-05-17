package com.michaelfotiadis.moviedb.core.data.validation;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.common.models.configuration.Configuration;
import com.michaelfotiadis.moviedb.common.models.guest.GuestSession;
import com.michaelfotiadis.moviedb.common.models.movies.Movie;
import com.michaelfotiadis.moviedb.common.models.movies.MoviesContainer;
import com.michaelfotiadis.moviedb.common.models.people.KnownFor;
import com.michaelfotiadis.moviedb.common.models.people.PeopleContainer;
import com.michaelfotiadis.moviedb.common.models.people.Person;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeries;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesContainer;
import com.michaelfotiadis.moviedb.core.data.validation.validators.ConfigurationValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.GuestSessionValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.KnownForValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.MovieValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.MoviesContainerValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.PeopleContainerValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.PersonValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.TvSeriesContainerValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.TvSeriesValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.Validator;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public final class ValidatorProcessorImpl implements ValidatorProcessor {

    private final Map<Class<? extends AppModel>, Validator> mValidators;

    public ValidatorProcessorImpl() {
        mValidators = new HashMap<>();

        // add the validators
        mValidators.put(GuestSession.class, new GuestSessionValidator());
        mValidators.put(Movie.class, new MovieValidator());
        mValidators.put(MoviesContainer.class, new MoviesContainerValidator());
        mValidators.put(KnownFor.class, new KnownForValidator());
        mValidators.put(Person.class, new PersonValidator());
        mValidators.put(PeopleContainer.class, new PeopleContainerValidator());
        mValidators.put(TvSeries.class, new TvSeriesValidator());
        mValidators.put(TvSeriesContainer.class, new TvSeriesContainerValidator());
        mValidators.put(Configuration.class, new ConfigurationValidator());

    }

    @Override
    public <T extends AppModel> Validator<T> getValidator(final Class<T> clazz) {
        //noinspection unchecked
        return mValidators.get(clazz);
    }
}
