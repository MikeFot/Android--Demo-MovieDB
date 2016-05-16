package com.michaelfotiadis.moviedb.common.models.tv;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TvSeriesImpl implements TvSeries {

    public static final Creator<TvSeries> CREATOR = new Creator<TvSeries>() {
        @Override
        public TvSeries createFromParcel(final Parcel source) {
            return new TvSeriesImpl(source);
        }

        @Override
        public TvSeries[] newArray(final int size) {
            return new TvSeries[size];
        }
    };
    @SerializedName("backdrop_path")
    private final String backdropPath;
    @SerializedName("first_air_date")
    private final String firstAirDate;
    @SerializedName("genre_ids")
    private final List<Integer> genreIds;
    @SerializedName("id")
    private final Integer id;
    @SerializedName("original_language")
    private final String originalLanguage;
    @SerializedName("original_name")
    private final String originalName;
    @SerializedName("overview")
    private final String overview;
    @SerializedName("origin_country")
    private final List<String> originCountry;
    @SerializedName("poster_path")
    private final String posterPath;
    @SerializedName("popularity")
    private final Float popularity;
    @SerializedName("name")
    private final String name;
    @SerializedName("vote_average")
    private final Float voteAverage;
    @SerializedName("vote_count")
    private final Integer voteCount;

    private TvSeriesImpl(final Builder builder) {
        backdropPath = builder.backdropPath;
        firstAirDate = builder.firstAirDate;
        genreIds = builder.genreIds;
        id = builder.id;
        originalLanguage = builder.originalLanguage;
        originalName = builder.originalName;
        overview = builder.overview;
        originCountry = builder.originCountry;
        posterPath = builder.posterPath;
        popularity = builder.popularity;
        name = builder.name;
        voteAverage = builder.voteAverage;
        voteCount = builder.voteCount;
    }

    protected TvSeriesImpl(final Parcel in) {
        this.backdropPath = in.readString();
        this.firstAirDate = in.readString();
        this.genreIds = new ArrayList<>();
        in.readList(this.genreIds, Integer.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.originalLanguage = in.readString();
        this.originalName = in.readString();
        this.overview = in.readString();
        this.originCountry = in.createStringArrayList();
        this.posterPath = in.readString();
        this.popularity = (Float) in.readValue(Float.class.getClassLoader());
        this.name = in.readString();
        this.voteAverage = (Float) in.readValue(Float.class.getClassLoader());
        this.voteCount = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final TvSeriesImpl copy) {
        final Builder builder = new Builder();
        builder.backdropPath = copy.backdropPath;
        builder.firstAirDate = copy.firstAirDate;
        builder.genreIds = copy.genreIds;
        builder.id = copy.id;
        builder.originalLanguage = copy.originalLanguage;
        builder.originalName = copy.originalName;
        builder.overview = copy.overview;
        builder.originCountry = copy.originCountry;
        builder.posterPath = copy.posterPath;
        builder.popularity = copy.popularity;
        builder.name = copy.name;
        builder.voteAverage = copy.voteAverage;
        builder.voteCount = copy.voteCount;
        return builder;
    }

    @Override
    public String getBackdropPath() {
        return backdropPath;
    }

    @Override
    public String getFirstAirDate() {
        return firstAirDate;
    }

    @Override
    public List<Integer> getGenreIds() {
        return genreIds;
    }

    @Override
    public Long getId() {
        return Long.valueOf(id);
    }

    @Override
    public String getName() {
        return name;
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
        dest.writeString(this.firstAirDate);
        dest.writeList(this.genreIds);
        dest.writeValue(this.id);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.originalName);
        dest.writeString(this.overview);
        dest.writeStringList(this.originCountry);
        dest.writeString(this.posterPath);
        dest.writeValue(this.popularity);
        dest.writeString(this.name);
        dest.writeValue(this.voteAverage);
        dest.writeValue(this.voteCount);
    }

    public static final class Builder {
        private String backdropPath;
        private String firstAirDate;
        private List<Integer> genreIds;
        private Integer id;
        private String originalLanguage;
        private String originalName;
        private String overview;
        private List<String> originCountry;
        private String posterPath;
        private Float popularity;
        private String name;
        private Float voteAverage;
        private Integer voteCount;

        private Builder() {
        }

        public Builder withBackdropPath(final String val) {
            backdropPath = val;
            return this;
        }

        public Builder withFirstAirDate(final String val) {
            firstAirDate = val;
            return this;
        }

        public Builder withGenreIds(final List<Integer> val) {
            genreIds = val;
            return this;
        }

        public Builder withId(final Integer val) {
            id = val;
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

        public Builder withOriginCountry(final List<String> val) {
            originCountry = val;
            return this;
        }

        public Builder withPosterPath(final String val) {
            posterPath = val;
            return this;
        }

        public Builder withPopularity(final Float val) {
            popularity = val;
            return this;
        }

        public Builder withName(final String val) {
            name = val;
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

        public TvSeries build() {
            return new TvSeriesImpl(this);
        }
    }
}