package com.michaelfotiadis.moviedb.core.data.loader;


import com.michaelfotiadis.moviedb.common.models.configuration.Configuration;
import com.michaelfotiadis.moviedb.common.models.movies.MoviesContainer;
import com.michaelfotiadis.moviedb.common.models.people.PeopleContainer;
import com.michaelfotiadis.moviedb.common.models.tv.TvSeriesContainer;
import com.michaelfotiadis.moviedb.common.responses.CommonCallback;
import com.michaelfotiadis.moviedb.common.responses.CommonDeliverable;
import com.michaelfotiadis.moviedb.core.data.loader.utils.LoaderUtils;
import com.michaelfotiadis.moviedb.core.data.rest.CoreRestClient;
import com.michaelfotiadis.moviedb.core.data.rest.CoreRestClientImpl;
import com.michaelfotiadis.moviedb.core.data.validation.ValidatorProcessorImpl;
import com.michaelfotiadis.moviedb.core.data.validation.results.ValidationResult;

import java.io.File;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LoaderNetwork {

    private final NetworkRequestForwarder mRequestForwarder;

    /*package*/ LoaderNetwork(final String apiKey, final File cacheDirectory) {
        // initialise the rest client with cache
        this(apiKey, new CoreRestClientImpl(cacheDirectory));
    }

    /*package*/ LoaderNetwork(final String apiKey, final CoreRestClient restClient) {
        // initialise the rest client with cache
        this.mRequestForwarder = new NetworkRequestForwarder(apiKey, restClient);
    }

    protected void getPopularMovies(final CommonCallback<MoviesContainer> masterCallback) {

        mRequestForwarder.forwardGetPopularMovies(new Callback<MoviesContainer>() {
            @Override
            public void success(final MoviesContainer result, final Response response) {

                final ValidationResult validationResult = new ValidatorProcessorImpl()
                        .getValidator(MoviesContainer.class)
                        .validate(result);
                if (validationResult.isValid()) {
                    masterCallback.onSuccess(CommonDeliverable.from(result));
                } else {
                    masterCallback.onFailure(validationResult.getError());
                }

            }

            @Override
            public void failure(final RetrofitError error) {
                masterCallback.onFailure(LoaderUtils.getErrorFromRetrofit(error));
            }
        });

    }

    protected void getPopularPeople(final CommonCallback<PeopleContainer> masterCallback) {

        mRequestForwarder.forwardGetPopularPeople(new Callback<PeopleContainer>() {
            @Override
            public void success(final PeopleContainer result, final Response response) {

                final ValidationResult validationResult = new ValidatorProcessorImpl()
                        .getValidator(PeopleContainer.class)
                        .validate(result);
                if (validationResult.isValid()) {
                    masterCallback.onSuccess(CommonDeliverable.from(result));
                } else {
                    masterCallback.onFailure(validationResult.getError());
                }

            }

            @Override
            public void failure(final RetrofitError error) {
                masterCallback.onFailure(LoaderUtils.getErrorFromRetrofit(error));
            }
        });

    }

    protected void getPopularSeries(final CommonCallback<TvSeriesContainer> masterCallback) {

        mRequestForwarder.forwardGetPopularSeries(new Callback<TvSeriesContainer>() {
            @Override
            public void success(final TvSeriesContainer result, final Response response) {

                final ValidationResult validationResult = new ValidatorProcessorImpl()
                        .getValidator(TvSeriesContainer.class)
                        .validate(result);
                if (validationResult.isValid()) {
                    masterCallback.onSuccess(CommonDeliverable.from(result));
                } else {
                    masterCallback.onFailure(validationResult.getError());
                }

            }

            @Override
            public void failure(final RetrofitError error) {
                masterCallback.onFailure(LoaderUtils.getErrorFromRetrofit(error));
            }
        });

    }

    protected void getConfiguration(final CommonCallback<Configuration> masterCallback) {

        mRequestForwarder.forwardGetConfiguration(new Callback<Configuration>() {
            @Override
            public void success(final Configuration result, final Response response) {

                final ValidationResult validationResult = new ValidatorProcessorImpl()
                        .getValidator(Configuration.class)
                        .validate(result);
                if (validationResult.isValid()) {
                    masterCallback.onSuccess(CommonDeliverable.from(result));
                } else {
                    masterCallback.onFailure(validationResult.getError());
                }

            }

            @Override
            public void failure(final RetrofitError error) {
                masterCallback.onFailure(LoaderUtils.getErrorFromRetrofit(error));
            }
        });

    }

}