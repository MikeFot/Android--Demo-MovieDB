package com.michaelfotiadis.moviedb.common.responses;

/**
 * Callback interface
 *
 * @param <T> object
 */
public interface CommonCallback<T> {

    void onFailure(final CommonError error);

    void onSuccess(final CommonDeliverable<T> deliverable);
}