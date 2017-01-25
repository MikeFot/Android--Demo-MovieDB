package com.michaelfotiadis.moviedb.ui.components.moviedetails.utils;

import com.michaelfotiadis.moviedb.common.models.genre.Genre;
import com.michaelfotiadis.moviedb.common.models.movies.details.ProductionCompany;
import com.michaelfotiadis.moviedb.common.models.movies.details.ProductionCountry;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.utils.AppLog;

import java.util.List;
import java.util.Locale;

/**
 *
 */
public class MovieDetailsUtils {

    public static String getRevenue(final Integer value) {

        if (value == null) {
            return "";
        } else {
            return String.format(Locale.UK, "Revenue: $%dm", value / 1000000);
        }

    }

    public static String getStudios(final List<ProductionCompany> companies) {

        if (companies == null) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (final ProductionCompany company : companies) {
            sb.append(prefix);
            prefix = "\n";
            sb.append(company.getName());
        }

        return sb.toString();
    }

    public static String getCountries(final List<ProductionCountry> countries) {

        if (countries == null) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (final ProductionCountry country : countries) {
            sb.append(prefix);
            prefix = "\n";
            sb.append(country.getName());
        }

        return sb.toString();
    }

    public static String getGenres(final List<Genre> genres) {

        if (genres == null) {
            return "";
        }

        final StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (final Genre genre : genres) {
            sb.append(prefix);
            prefix = "\n";
            sb.append(genre.getName());
        }

        return sb.toString();
    }

    public static String getPosterUrl(final String path) {
        final String base = DemoCore.getImageBaseUrl();
        final List<String> posterSizes = DemoCore.getPreferenceManager().getConfiguration().getImages().getPosterSizes();

        final int position;
        if (posterSizes.size() >= 3) {
            position = posterSizes.size() - 2;
        } else {
            position = 0;
        }

        final String size = posterSizes.get(position);
        final String url = base + size + path;
        AppLog.d("ImageUrl: Final image url is " + url);
        return url;
    }
}
