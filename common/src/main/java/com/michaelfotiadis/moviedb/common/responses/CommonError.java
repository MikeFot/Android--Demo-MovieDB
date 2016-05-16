package com.michaelfotiadis.moviedb.common.responses;

/**
 * Custom Common Error object
 */
public final class CommonError implements CommonTimedElement {

    private final String mErrorMessage;
    private final CommonErrorKind mKind;
    private final CommonTimedElement mTimedElement;

    /**
     * Constructor for the CommonError object
     *
     * @param errorMessage String message
     * @param kind         CommonErrorKind enum
     */
    private CommonError(final String errorMessage, final CommonErrorKind kind) {
        this.mErrorMessage = errorMessage;
        this.mKind = kind;
        this.mTimedElement = new CommonTimedElementImpl();
    }

    @Override
    public long getCreationTime() {
        return mTimedElement.getCreationTime();
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public CommonErrorKind getKind() {
        return mKind;
    }

    @Override
    public String toString() {
        return "CommonError{" +
                "ErrorMessage='" + mErrorMessage + '\'' +
                ", Kind=" + mKind +
                '}';
    }

    public static CommonError from(final String message, final CommonErrorKind kind) {
        return new CommonError(message, kind);
    }

}
