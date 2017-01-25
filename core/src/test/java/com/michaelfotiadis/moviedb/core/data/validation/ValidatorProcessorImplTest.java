package com.michaelfotiadis.moviedb.core.data.validation;

import com.michaelfotiadis.moviedb.common.models.configuration.Configuration;
import com.michaelfotiadis.moviedb.common.models.genre.Genre;
import com.michaelfotiadis.moviedb.common.models.movies.Movie;
import com.michaelfotiadis.moviedb.common.models.movies.MoviesContainer;
import com.michaelfotiadis.moviedb.common.models.people.PeopleContainer;
import com.michaelfotiadis.moviedb.common.models.people.Person;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesContainer;
import com.michaelfotiadis.moviedb.core.data.validation.validators.ConfigurationValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.GenreValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.MovieValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.MoviesContainerValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.PeopleContainerValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.PersonValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.TvSeriesContainerValidator;
import com.michaelfotiadis.moviedb.core.data.validation.validators.Validator;

import junit.framework.TestCase;

/**
 *
 */
public class ValidatorProcessorImplTest extends TestCase {

    public void testGetValidator() throws Exception {

        final ValidatorProcessor processor = new ValidatorProcessorImpl();

        Validator validator = processor.getValidator(Movie.class);
        assertNotNull("Null validator", validator);
        assertTrue(MovieValidator.class.isInstance(validator));

        validator = processor.getValidator(Genre.class);
        assertNotNull("Null validator", validator);
        assertTrue(GenreValidator.class.isInstance(validator));

        validator = processor.getValidator(Person.class);
        assertNotNull("Null validator", validator);
        assertTrue(PersonValidator.class.isInstance(validator));

        validator = processor.getValidator(MoviesContainer.class);
        assertNotNull("Null validator", validator);
        assertTrue(MoviesContainerValidator.class.isInstance(validator));

        validator = processor.getValidator(TvSeriesContainer.class);
        assertNotNull("Null validator", validator);
        assertTrue(TvSeriesContainerValidator.class.isInstance(validator));

        validator = processor.getValidator(PeopleContainer.class);
        assertNotNull("Null validator", validator);
        assertTrue(PeopleContainerValidator.class.isInstance(validator));

        validator = processor.getValidator(Configuration.class);
        assertNotNull("Null validator", validator);
        assertTrue(ConfigurationValidator.class.isInstance(validator));

    }
}