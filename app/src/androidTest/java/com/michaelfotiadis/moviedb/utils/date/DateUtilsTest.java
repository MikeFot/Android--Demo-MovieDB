package com.michaelfotiadis.moviedb.utils.date;

import android.test.AndroidTestCase;

/**
 *
 */
public class DateUtilsTest extends AndroidTestCase {

    public void testGetReleaseYear() throws Exception {
        assertEquals("2004", DateUtils.getReleaseYear("2004-12-21"));
    }
}