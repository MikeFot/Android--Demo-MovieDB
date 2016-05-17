package com.michaelfotiadis.moviedb.utils.date;

import android.text.TextUtils;

import com.michaelfotiadis.moviedb.utils.AppConstants;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public class DateUtils {

    public static String getReleaseYear(final String releaseDate) {

        if (TextUtils.isEmpty(releaseDate)) {
            return "";
        }

        try {
            final Date date = new UtcDateFormatter(AppConstants.RELEASE_DATE_FORMAT).parse(releaseDate);
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return String.valueOf(calendar.get(Calendar.YEAR));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }

    }

}
