package com.michaelfotiadis.moviedb.utils.date;

import android.text.TextUtils;

import com.michaelfotiadis.moviedb.utils.AppConstants;
import com.michaelfotiadis.moviedb.utils.AppLog;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public final class DateUtils {

    private DateUtils() {
        // NOOP
    }

    public static String getReleaseYear(final String releaseDate) {

        if (TextUtils.isEmpty(releaseDate)) {
            return "";
        }

        try {
            AppLog.d("Parsing date " + releaseDate);
            final UtcDateFormatter utcDateFormatter = new UtcDateFormatter(AppConstants.RELEASE_DATE_FORMAT);
            final Date date = utcDateFormatter.parse(releaseDate.trim());
            final Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return String.valueOf(calendar.get(Calendar.YEAR));
        } catch (final ParseException e) {
            e.printStackTrace();
            return "";
        }

    }

}
