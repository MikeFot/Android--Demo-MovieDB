package com.michaelfotiadis.moviedb.data.error;

import android.content.Context;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.common.responses.CommonError;
import com.michaelfotiadis.moviedb.common.responses.CommonErrorKind;

/**
 *
 */
public final class UiDataLoadErrorFactory {


    private UiDataLoadErrorFactory() {
    }

    public static UiDataLoadError createDeviceOfflineError(final Context context) {
        return new UiDataLoadError(
                context.getString(R.string.friendly_error_you_are_offline),
                UiDataLoadError.ErrorKind.NO_NETWORK,
                true);
    }

    public static UiDataLoadError createError(final Context context,
                                              final CommonError error) {
        final UiDataLoadError.ErrorKind kind = translate(error.getKind());

        if (error.getKind() == CommonErrorKind.NO_NETWORK) {
            return createDeviceOfflineError(context);
        } else {

            final CharSequence message = getMessageFromKind(context, kind);

            return new UiDataLoadError(message, kind, false);
        }
    }


    private static CharSequence getMessageFromKind(final Context context,
                                                   final UiDataLoadError.ErrorKind kind) {

        switch (kind) {
            case UNKNOWN:
                return context.getString(R.string.friendly_error_something_went_wrong);
            case NO_NETWORK:
                return context.getString(R.string.friendly_error_no_connection);
            case NO_DATA:
                return context.getString(R.string.friendly_error_missing_data);
            default:
                return context.getString(R.string.friendly_error_something_went_wrong);
        }

    }

    private static UiDataLoadError.ErrorKind translate(final CommonErrorKind kind) {
        final UiDataLoadError.ErrorKind result;

        switch (kind) {
            case COMMUNICATION:
                result = UiDataLoadError.ErrorKind.NO_NETWORK;
                break;
            case UNEXPECTED:
                result = UiDataLoadError.ErrorKind.UNKNOWN;
                break;
            case NO_NETWORK:
                result = UiDataLoadError.ErrorKind.NO_NETWORK;
                break;
            case NO_LOCATION:
                result = UiDataLoadError.ErrorKind.NO_LOCATION;
                break;
            case ERROR_ACCESSING_LOCAL_STORAGE:
                result = UiDataLoadError.ErrorKind.NO_DATA;
                break;
            case ERROR_RETRIEVING_FROM_CACHE:
                result = UiDataLoadError.ErrorKind.NO_DATA;
                break;
            case IO_EXCEPTION:
                result = UiDataLoadError.ErrorKind.NO_DATA;
                break;
            case REQUEST_FAILED:
                result = UiDataLoadError.ErrorKind.UNKNOWN;
                break;
            case NOT_FOUND:
                result = UiDataLoadError.ErrorKind.NO_DATA;
                break;
            case DESERIALIZATION_ERROR:
                result = UiDataLoadError.ErrorKind.UNKNOWN;
                break;
            case SERVER:
                result = UiDataLoadError.ErrorKind.NO_DATA;
                break;
            case INVALID_REQUEST_PARAMETERS:
                result = UiDataLoadError.ErrorKind.UNKNOWN;
                break;
            case INVALID_CONTENT:
                result = UiDataLoadError.ErrorKind.UNKNOWN;
                break;
            case NO_CONTENT_RETURNED:
                result = UiDataLoadError.ErrorKind.NO_DATA;
                break;
            default:
                result = UiDataLoadError.ErrorKind.UNKNOWN;
        }
        return result;
    }
}
