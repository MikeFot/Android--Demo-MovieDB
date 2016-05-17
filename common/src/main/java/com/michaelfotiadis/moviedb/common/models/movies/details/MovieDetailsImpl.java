package com.michaelfotiadis.moviedb.common.models.movies.details;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;
import com.michaelfotiadis.moviedb.common.models.genre.Genre;
import com.michaelfotiadis.moviedb.common.models.genre.GenreImpl;

import java.util.List;

public class MovieDetailsImpl implements MovieDetails {

    public static final Creator<MovieDetailsImpl> CREATOR = new Creator<MovieDetailsImpl>() {
        @Override
        public MovieDetailsImpl createFromParcel(final Parcel source) {
            return new MovieDetailsImpl(source);
        }

        @Override
        public MovieDetailsImpl[] newArray(final int size) {
            return new MovieDetailsImpl[size];
        }
    };
    @SerializedName("adult")
    private final Boolean adult;
    @SerializedName("backdrop_path")
    private final String backdropPath;
    @SerializedName("belongs_to_collection")
    private final BelongsToCollection belongsToCollection;
    @SerializedName("budget")
    private final Integer budget;
    @SerializedName("genres")
    private final List<Genre> genres;
    @SerializedName("homepage")
    private final String homepage;
    @SerializedName("id")
    private final Integer id;
    @SerializedName("imdb_id")
    private final String imdbId;
    @SerializedName("original_language")
    private final String originalLanguage;
    @SerializedName("original_title")
    private final String originalTitle;
    @SerializedName("overview")
    private final String overview;
    @SerializedName("popularity")
    private final Float popularity;
    @SerializedName("poster_path")
    private final String posterPath;
    @SerializedName("production_companies")
    private final List<ProductionCompany> productionCompanies;
    @SerializedName("production_countries")
    private final List<ProductionCountry> productionCountries;
    @SerializedName("release_date")
    private final String releaseDate;
    @SerializedName("revenue")
    private final Integer revenue;
    @SerializedName("runtime")
    private final Integer runtime;
    @SerializedName("spoken_languages")
    private final List<SpokenLanguage> spokenLanguages;
    @SerializedName("status")
    private final String status;
    @SerializedName("tagline")
    private final String tagline;
    @SerializedName("title")
    private final String title;
    @SerializedName("video")
    private final Boolean video;
    @SerializedName("vote_average")
    private final Float voteAverage;
    @SerializedName("vote_count")
    private final Integer voteCount;

    private MovieDetailsImpl(final Builder builder) {
        adult = builder.adult;
        backdropPath = builder.backdropPath;
        belongsToCollection = builder.belongsToCollection;
        budget = builder.budget;
        genres = builder.genres;
        homepage = builder.homepage;
        id = builder.id;
        imdbId = builder.imdbId;
        originalLanguage = builder.originalLanguage;
        originalTitle = builder.originalTitle;
        overview = builder.overview;
        popularity = builder.popularity;
        posterPath = builder.posterPath;
        productionCompanies = builder.productionCompanies;
        productionCountries = builder.productionCountries;
        releaseDate = builder.releaseDate;
        revenue = builder.revenue;
        runtime = builder.runtime;
        spokenLanguages = builder.spokenLanguages;
        status = builder.status;
        tagline = builder.tagline;
        title = builder.title;
        video = builder.video;
        voteAverage = builder.voteAverage;
        voteCount = builder.voteCount;
    }

    protected MovieDetailsImpl(final Parcel in) {
        this.adult = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.backdropPath = in.readString();
        this.belongsToCollection = in.readParcelable(BelongsToCollection.class.getClassLoader());
        this.budget = (Integer) in.readValue(Integer.class.getClassLoader());
        this.genres = in.createTypedArrayList(GenreImpl.CREATOR);
        this.homepage = in.readString();
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.imdbId = in.readString();
        this.originalLanguage = in.readString();
        this.originalTitle = in.readString();
        this.overview = in.readString();
        this.popularity = (Float) in.readValue(Float.class.getClassLoader());
        this.posterPath = in.readString();
        this.productionCompanies = in.createTypedArrayList(ProductionCompanyImpl.CREATOR);
        this.productionCountries = in.createTypedArrayList(ProductionCountryImpl.CREATOR);
        this.releaseDate = in.readString();
        this.revenue = (Integer) in.readValue(Integer.class.getClassLoader());
        this.runtime = (Integer) in.readValue(Integer.class.getClassLoader());
        this.spokenLanguages = in.createTypedArrayList(SpokenLanguageImpl.CREATOR);
        this.status = in.readString();
        this.tagline = in.readString();
        this.title = in.readString();
        this.video = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.voteAverage = (Float) in.readValue(Float.class.getClassLoader());
        this.voteCount = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final MovieDetailsImpl copy) {
        final Builder builder = new Builder();
        builder.adult = copy.adult;
        builder.backdropPath = copy.backdropPath;
        builder.belongsToCollection = copy.belongsToCollection;
        builder.budget = copy.budget;
        builder.genres = copy.genres;
        builder.homepage = copy.homepage;
        builder.id = copy.id;
        builder.imdbId = copy.imdbId;
        builder.originalLanguage = copy.originalLanguage;
        builder.originalTitle = copy.originalTitle;
        builder.overview = copy.overview;
        builder.popularity = copy.popularity;
        builder.posterPath = copy.posterPath;
        builder.productionCompanies = copy.productionCompanies;
        builder.productionCountries = copy.productionCountries;
        builder.releaseDate = copy.releaseDate;
        builder.revenue = copy.revenue;
        builder.runtime = copy.runtime;
        builder.spokenLanguages = copy.spokenLanguages;
        builder.status = copy.status;
        builder.tagline = copy.tagline;
        builder.title = copy.title;
        builder.video = copy.video;
        builder.voteAverage = copy.voteAverage;
        builder.voteCount = copy.voteCount;
        return builder;
    }

    @Override
    public Boolean getAdult() {
        return adult;
    }

    @Override
    public String getBackdropPath() {
        return backdropPath;
    }

    @Override
    public BelongsToCollection getBelongsToCollection() {
        return belongsToCollection;
    }

    @Override
    public Integer getBudget() {
        return budget;
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
    public String getImdbId() {
        return imdbId;
    }

    @Override
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    @Override
    public String getOriginalTitle() {
        return originalTitle;
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
    public List<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    @Override
    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public Integer getRevenue() {
        return revenue;
    }

    @Override
    public Integer getRuntime() {
        return runtime;
    }

    @Override
    public List<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getTagline() {
        return tagline;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Boolean getVideo() {
        return video;
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
    public Long getId() {
        return Long.valueOf(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeValue(this.adult);
        dest.writeString(this.backdropPath);
        dest.writeParcelable(this.belongsToCollection, flags);
        dest.writeValue(this.budget);
        dest.writeTypedList(this.genres);
        dest.writeString(this.homepage);
        dest.writeValue(this.id);
        dest.writeString(this.imdbId);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.originalTitle);
        dest.writeString(this.overview);
        dest.writeValue(this.popularity);
        dest.writeString(this.posterPath);
        dest.writeTypedList(this.productionCompanies);
        dest.writeTypedList(this.productionCountries);
        dest.writeString(this.releaseDate);
        dest.writeValue(this.revenue);
        dest.writeValue(this.runtime);
        dest.writeTypedList(this.spokenLanguages);
        dest.writeString(this.status);
        dest.writeString(this.tagline);
        dest.writeString(this.title);
        dest.writeValue(this.video);
        dest.writeValue(this.voteAverage);
        dest.writeValue(this.voteCount);
    }

    public static final class Builder {
        private Boolean adult;
        private String backdropPath;
        private BelongsToCollection belongsToCollection;
        private Integer budget;
        private List<Genre> genres;
        private String homepage;
        private Integer id;
        private String imdbId;
        private String originalLanguage;
        private String originalTitle;
        private String overview;
        private Float popularity;
        private String posterPath;
        private List<ProductionCompany> productionCompanies;
        private List<ProductionCountry> productionCountries;
        private String releaseDate;
        private Integer revenue;
        private Integer runtime;
        private List<SpokenLanguage> spokenLanguages;
        private String status;
        private String tagline;
        private String title;
        private Boolean video;
        private Float voteAverage;
        private Integer voteCount;

        private Builder() {
        }

        public Builder withAdult(final Boolean val) {
            adult = val;
            return this;
        }

        public Builder withBackdropPath(final String val) {
            backdropPath = val;
            return this;
        }

        public Builder withBelongsToCollection(final BelongsToCollection val) {
            belongsToCollection = val;
            return this;
        }

        public Builder withBudget(final Integer val) {
            budget = val;
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

        public Builder withImdbId(final String val) {
            imdbId = val;
            return this;
        }

        public Builder withOriginalLanguage(final String val) {
            originalLanguage = val;
            return this;
        }

        public Builder withOriginalTitle(final String val) {
            originalTitle = val;
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

        public Builder withProductionCountries(final List<ProductionCountry> val) {
            productionCountries = val;
            return this;
        }

        public Builder withReleaseDate(final String val) {
            releaseDate = val;
            return this;
        }

        public Builder withRevenue(final Integer val) {
            revenue = val;
            return this;
        }

        public Builder withRuntime(final Integer val) {
            runtime = val;
            return this;
        }

        public Builder withSpokenLanguages(final List<SpokenLanguage> val) {
            spokenLanguages = val;
            return this;
        }

        public Builder withStatus(final String val) {
            status = val;
            return this;
        }

        public Builder withTagline(final String val) {
            tagline = val;
            return this;
        }

        public Builder withTitle(final String val) {
            title = val;
            return this;
        }

        public Builder withVideo(final Boolean val) {
            video = val;
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

        public MovieDetailsImpl build() {
            return new MovieDetailsImpl(this);
        }
    }
}