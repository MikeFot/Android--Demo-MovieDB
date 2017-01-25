package com.michaelfotiadis.moviedb.common.models.tv.details;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;
import com.michaelfotiadis.moviedb.common.models.genre.Genre;
import com.michaelfotiadis.moviedb.common.models.genre.GenreImpl;
import com.michaelfotiadis.moviedb.common.models.movies.details.ProductionCompany;
import com.michaelfotiadis.moviedb.common.models.movies.details.ProductionCompanyImpl;

import java.util.ArrayList;
import java.util.List;

public class TvSeriesDetailsImpl implements TvSeriesDetails {

    public static final Creator<TvSeriesDetails> CREATOR = new Creator<TvSeriesDetails>() {
        @Override
        public TvSeriesDetails createFromParcel(final Parcel source) {
            return new TvSeriesDetailsImpl(source);
        }

        @Override
        public TvSeriesDetails[] newArray(final int size) {
            return new TvSeriesDetails[size];
        }
    };
    @SerializedName("backdrop_path")
    private final String backdropPath;
    @SerializedName("created_by")
    private final List<CreatedBy> createdBy;
    @SerializedName("episode_run_time")
    private final List<Integer> episodeRunTime;
    @SerializedName("first_air_date")
    private final String firstAirDate;
    @SerializedName("genres")
    private final List<Genre> genres;
    @SerializedName("homepage")
    private final String homepage;
    @SerializedName("id")
    private final Integer id;
    @SerializedName("in_production")
    private final Boolean inProduction;
    @SerializedName("languages")
    private final List<String> languages;
    @SerializedName("last_air_date")
    private final String lastAirDate;
    @SerializedName("name")
    private final String name;
    @SerializedName("networks")
    private final List<Network> networks;
    @SerializedName("number_of_episodes")
    private final Integer numberOfEpisodes;
    @SerializedName("number_of_seasons")
    private final Integer numberOfSeasons;
    @SerializedName("origin_country")
    private final List<String> originCountry;
    @SerializedName("original_language")
    private final String originalLanguage;
    @SerializedName("original_name")
    private final String originalName;
    @SerializedName("overview")
    private final String overview;
    @SerializedName("popularity")
    private final Float popularity;
    @SerializedName("poster_path")
    private final String posterPath;
    @SerializedName("production_companies")
    private final List<ProductionCompany> productionCompanies;
    @SerializedName("seasons")
    private final List<Season> seasons;
    @SerializedName("status")
    private final String status;
    @SerializedName("type")
    private final String type;
    @SerializedName("vote_average")
    private final Float voteAverage;
    @SerializedName("vote_count")
    private final Integer voteCount;

    private TvSeriesDetailsImpl(final Builder builder) {
        backdropPath = builder.backdropPath;
        createdBy = builder.createdBy;
        episodeRunTime = builder.episodeRunTime;
        firstAirDate = builder.firstAirDate;
        genres = builder.genres;
        homepage = builder.homepage;
        id = builder.id;
        inProduction = builder.inProduction;
        languages = builder.languages;
        lastAirDate = builder.lastAirDate;
        name = builder.name;
        networks = builder.networks;
        numberOfEpisodes = builder.numberOfEpisodes;
        numberOfSeasons = builder.numberOfSeasons;
        originCountry = builder.originCountry;
        originalLanguage = builder.originalLanguage;
        originalName = builder.originalName;
        overview = builder.overview;
        popularity = builder.popularity;
        posterPath = builder.posterPath;
        productionCompanies = builder.productionCompanies;
        seasons = builder.seasons;
        status = builder.status;
        type = builder.type;
        voteAverage = builder.voteAverage;
        voteCount = builder.voteCount;
    }

    protected TvSeriesDetailsImpl(final Parcel in) {
        this.backdropPath = in.readString();
        this.createdBy = in.createTypedArrayList(CreatedByImpl.CREATOR);
        this.episodeRunTime = new ArrayList<Integer>();
        in.readList(this.episodeRunTime, Integer.class.getClassLoader());
        this.firstAirDate = in.readString();
        this.genres = in.createTypedArrayList(GenreImpl.CREATOR);
        this.homepage = in.readString();
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.inProduction = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.languages = in.createStringArrayList();
        this.lastAirDate = in.readString();
        this.name = in.readString();
        this.networks = in.createTypedArrayList(NetworkImpl.CREATOR);
        this.numberOfEpisodes = (Integer) in.readValue(Integer.class.getClassLoader());
        this.numberOfSeasons = (Integer) in.readValue(Integer.class.getClassLoader());
        this.originCountry = in.createStringArrayList();
        this.originalLanguage = in.readString();
        this.originalName = in.readString();
        this.overview = in.readString();
        this.popularity = (Float) in.readValue(Float.class.getClassLoader());
        this.posterPath = in.readString();
        this.productionCompanies = in.createTypedArrayList(ProductionCompanyImpl.CREATOR);
        this.seasons = in.createTypedArrayList(SeasonImpl.CREATOR);
        this.status = in.readString();
        this.type = in.readString();
        this.voteAverage = (Float) in.readValue(Float.class.getClassLoader());
        this.voteCount = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final TvSeriesDetailsImpl copy) {
        final Builder builder = new Builder();
        builder.backdropPath = copy.backdropPath;
        builder.createdBy = copy.createdBy;
        builder.episodeRunTime = copy.episodeRunTime;
        builder.firstAirDate = copy.firstAirDate;
        builder.genres = copy.genres;
        builder.homepage = copy.homepage;
        builder.id = copy.id;
        builder.inProduction = copy.inProduction;
        builder.languages = copy.languages;
        builder.lastAirDate = copy.lastAirDate;
        builder.name = copy.name;
        builder.networks = copy.networks;
        builder.numberOfEpisodes = copy.numberOfEpisodes;
        builder.numberOfSeasons = copy.numberOfSeasons;
        builder.originCountry = copy.originCountry;
        builder.originalLanguage = copy.originalLanguage;
        builder.originalName = copy.originalName;
        builder.overview = copy.overview;
        builder.popularity = copy.popularity;
        builder.posterPath = copy.posterPath;
        builder.productionCompanies = copy.productionCompanies;
        builder.seasons = copy.seasons;
        builder.status = copy.status;
        builder.type = copy.type;
        builder.voteAverage = copy.voteAverage;
        builder.voteCount = copy.voteCount;
        return builder;
    }

    @Override
    public String getBackdropPath() {
        return backdropPath;
    }

    @Override
    public List<CreatedBy> getCreatedBy() {
        return createdBy;
    }

    @Override
    public List<Integer> getEpisodeRunTime() {
        return episodeRunTime;
    }

    @Override
    public String getFirstAirDate() {
        return firstAirDate;
    }

    @Override
    public List<Genre> getGenres() {
        return genres;
    }

    @Override
    public String getHomepage() {
        return homepage;
    }

    @Override
    public Long getId() {
        return Long.valueOf(id);
    }

    @Override
    public Boolean getInProduction() {
        return inProduction;
    }

    @Override
    public List<String> getLanguages() {
        return languages;
    }

    @Override
    public String getLastAirDate() {
        return lastAirDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Network> getNetworks() {
        return networks;
    }

    @Override
    public Integer getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    @Override
    public Integer getNumberOfSeasons() {
        return numberOfSeasons;
    }

    @Override
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    @Override
    public String getOriginalName() {
        return originalName;
    }

    @Override
    public List<String> getOriginCountry() {
        return originCountry;
    }

    @Override
    public String getOverview() {
        return overview;
    }

    @Override
    public Float getPopularity() {
        return popularity;
    }

    @Override
    public String getPosterPath() {
        return posterPath;
    }

    @Override
    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    @Override
    public List<Season> getSeasons() {
        return seasons;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Float getVoteAverage() {
        return voteAverage;
    }

    @Override
    public Integer getVoteCount() {
        return voteCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(this.backdropPath);
        dest.writeTypedList(this.createdBy);
        dest.writeList(this.episodeRunTime);
        dest.writeString(this.firstAirDate);
        dest.writeTypedList(this.genres);
        dest.writeString(this.homepage);
        dest.writeValue(this.id);
        dest.writeValue(this.inProduction);
        dest.writeStringList(this.languages);
        dest.writeString(this.lastAirDate);
        dest.writeString(this.name);
        dest.writeTypedList(this.networks);
        dest.writeValue(this.numberOfEpisodes);
        dest.writeValue(this.numberOfSeasons);
        dest.writeStringList(this.originCountry);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.originalName);
        dest.writeString(this.overview);
        dest.writeValue(this.popularity);
        dest.writeString(this.posterPath);
        dest.writeTypedList(this.productionCompanies);
        dest.writeTypedList(this.seasons);
        dest.writeString(this.status);
        dest.writeString(this.type);
        dest.writeValue(this.voteAverage);
        dest.writeValue(this.voteCount);
    }

    public static final class Builder {
        private String backdropPath;
        private List<CreatedBy> createdBy;
        private List<Integer> episodeRunTime;
        private String firstAirDate;
        private List<Genre> genres;
        private String homepage;
        private Integer id;
        private Boolean inProduction;
        private List<String> languages;
        private String lastAirDate;
        private String name;
        private List<Network> networks;
        private Integer numberOfEpisodes;
        private Integer numberOfSeasons;
        private List<String> originCountry;
        private String originalLanguage;
        private String originalName;
        private String overview;
        private Float popularity;
        private String posterPath;
        private List<ProductionCompany> productionCompanies;
        private List<Season> seasons;
        private String status;
        private String type;
        private Float voteAverage;
        private Integer voteCount;

        private Builder() {
        }

        public Builder withBackdropPath(final String val) {
            backdropPath = val;
            return this;
        }

        public Builder withCreatedBy(final List<CreatedBy> val) {
            createdBy = val;
            return this;
        }

        public Builder withEpisodeRunTime(final List<Integer> val) {
            episodeRunTime = val;
            return this;
        }

        public Builder withFirstAirDate(final String val) {
            firstAirDate = val;
            return this;
        }

        public Builder withGenres(final List<Genre> val) {
            genres = val;
            return this;
        }

        public Builder withHomepage(final String val) {
            homepage = val;
            return this;
        }

        public Builder withId(final Integer val) {
            id = val;
            return this;
        }

        public Builder withInProduction(final Boolean val) {
            inProduction = val;
            return this;
        }

        public Builder withLanguages(final List<String> val) {
            languages = val;
            return this;
        }

        public Builder withLastAirDate(final String val) {
            lastAirDate = val;
            return this;
        }

        public Builder withName(final String val) {
            name = val;
            return this;
        }

        public Builder withNetworks(final List<Network> val) {
            networks = val;
            return this;
        }

        public Builder withNumberOfEpisodes(final Integer val) {
            numberOfEpisodes = val;
            return this;
        }

        public Builder withNumberOfSeasons(final Integer val) {
            numberOfSeasons = val;
            return this;
        }

        public Builder withOriginCountry(final List<String> val) {
            originCountry = val;
            return this;
        }

        public Builder withOriginalLanguage(final String val) {
            originalLanguage = val;
            return this;
        }

        public Builder withOriginalName(final String val) {
            originalName = val;
            return this;
        }

        public Builder withOverview(final String val) {
            overview = val;
            return this;
        }

        public Builder withPopularity(final Float val) {
            popularity = val;
            return this;
        }

        public Builder withPosterPath(final String val) {
            posterPath = val;
            return this;
        }

        public Builder withProductionCompanies(final List<ProductionCompany> val) {
            productionCompanies = val;
            return this;
        }

        public Builder withSeasons(final List<Season> val) {
            seasons = val;
            return this;
        }

        public Builder withStatus(final String val) {
            status = val;
            return this;
        }

        public Builder withType(final String val) {
            type = val;
            return this;
        }

        public Builder withVoteAverage(final Float val) {
            voteAverage = val;
            return this;
        }

        public Builder withVoteCount(final Integer val) {
            voteCount = val;
            return this;
        }

        public TvSeriesDetails build() {
            return new TvSeriesDetailsImpl(this);
        }
    }
}