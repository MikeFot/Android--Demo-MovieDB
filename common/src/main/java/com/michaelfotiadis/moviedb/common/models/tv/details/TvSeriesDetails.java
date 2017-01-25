package com.michaelfotiadis.moviedb.common.models.tv.details;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithLongId;
import com.michaelfotiadis.moviedb.common.models.genre.Genre;
import com.michaelfotiadis.moviedb.common.models.movies.details.ProductionCompany;

import java.util.List;

/**
 *
 */
public interface TvSeriesDetails extends AppModel, WithLongId {
    String getBackdropPath();

    List<CreatedBy> getCreatedBy();

    List<Integer> getEpisodeRunTime();

    String getFirstAirDate();

    List<Genre> getGenres();

    String getHomepage();

    Boolean getInProduction();

    List<String> getLanguages();

    String getLastAirDate();

    String getName();

    List<Network> getNetworks();

    Integer getNumberOfEpisodes();

    Integer getNumberOfSeasons();

    String getOriginalLanguage();

    String getOriginalName();

    List<String> getOriginCountry();

    String getOverview();

    Float getPopularity();

    String getPosterPath();

    List<ProductionCompany> getProductionCompanies();

    List<Season> getSeasons();

    String getStatus();

    String getType();

    Float getVoteAverage();

    Integer getVoteCount();
}
