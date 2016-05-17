package com.michaelfotiadis.moviedb.common.models.movies.details;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.WithLongId;
import com.michaelfotiadis.moviedb.common.models.genre.Genre;

import java.util.List;

/**
 *
 */
public interface MovieDetails extends AppModel, WithLongId {
    Boolean getAdult();

    String getBackdropPath();

    BelongsToCollection getBelongsToCollection();

    Integer getBudget();

    List<Genre> getGenres();

    String getHomepage();

    String getImdbId();

    String getOriginalLanguage();

    String getOriginalTitle();

    String getOverview();

    Float getPopularity();

    String getPosterPath();

    List<ProductionCompany> getProductionCompanies();

    List<ProductionCountry> getProductionCountries();

    String getReleaseDate();

    Integer getRevenue();

    Integer getRuntime();

    List<SpokenLanguage> getSpokenLanguages();

    String getStatus();

    String getTagline();

    String getTitle();

    Boolean getVideo();

    Float getVoteAverage();

    Integer getVoteCount();
}
