package com.michaelfotiadis.moviedb.core.data.loader.utils;

import com.michaelfotiadis.moviedb.common.responses.CommonError;
import com.michaelfotiadis.moviedb.common.responses.CommonErrorKind;

import retrofit.RetrofitError;

/**
 *
 */
public final class LoaderUtils {


    private LoaderUtils() {
        // DO NOT INSTANTIATE
    }

    private static CommonErrorKind convertErrorKind(final RetrofitError.Kind kind) {
        final CommonErrorKind result;

        switch (kind) {

            case NETWORK:
                result = CommonErrorKind.COMMUNICATION;
                break;
            case CONVERSION:
                result = CommonErrorKind.DESERIALIZATION_ERROR;
                break;
            case HTTP:
                result = CommonErrorKind.COMMUNICATION;
                break;
            case UNEXPECTED:
                result = CommonErrorKind.UNEXPECTED;
                break;
            default:
                result = CommonErrorKind.UNEXPECTED;
        }

        return result;
    }

    public static CommonError getErrorFromRetrofit(final RetrofitError error) {

        if (error == null) {
            throw new NullPointerException("Null Retrofit Error");
        }

        return CommonError.from(
                getErrorMessage(error),
                convertErrorKind(error.getKind())
        );

    }

    public static String getErrorMessage(final RetrofitError error) {
        return String.format("%s: URL='%s'", error.getKind(), error.getUrl());
    }

}
