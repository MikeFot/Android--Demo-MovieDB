package com.michaelfotiadis.moviedb.common.responses;

/**
 * Wrapper object for loading results.
 * Contains the object and the datasource type
 */
public final class CommonDeliverable<T> implements CommonTimedElement {

    private final T mObjectContent;
    private final CommonTimedElement mTimedElement;

    public CommonDeliverable(final T parcelableObject) {
        this.mObjectContent = parcelableObject;
        this.mTimedElement = new CommonTimedElementImpl();
    }

    public T getContent() {
        return mObjectContent;
    }

    @Override
    public long getCreationTime() {
        return mTimedElement.getCreationTime();
    }


    public static <T> CommonDeliverable<T> from(final T parcelableObject) {
        return new CommonDeliverable<>(parcelableObject);
    }

}
