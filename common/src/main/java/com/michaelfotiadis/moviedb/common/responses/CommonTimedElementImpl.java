package com.michaelfotiadis.moviedb.common.responses;

import java.util.Calendar;

/**
 *
 */
public class CommonTimedElementImpl implements CommonTimedElement {

    final long mCreationTime;

    public CommonTimedElementImpl() {
        this.mCreationTime = Calendar.getInstance().getTimeInMillis();
    }

    public long getCreationTime() {
        return mCreationTime;
    }
}
