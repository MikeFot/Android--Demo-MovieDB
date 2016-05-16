package com.michaelfotiadis.moviedb.common.models.movies;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MovieImpl implements Movie {

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(final Parcel source) {
            return new MovieImpl(source);
        }

        @Override
        public Movie[] newArray(final int size) {
            return new Movie[size];
        }
    };
    @SerializedName("adult")
    private final Boolean adult;
    @SerializedName("backdrop_path")
    private final String backdropPath;
    @SerializedName("genre_ids")
    private final List<Integer> genreIds;
    @SerializedName("id")
    private final Integer id;
    @SerializedName("original_language")
    private final String originalLanguage;
    @SerializedName("original_title")
    private final String originalTitle;
    @SerializedName("overview")
    private final String overview;
    @SerializedName("release_date")
    private final String releaseDate;
    @SerializedName("poster_path")
    private final String posterPath;
    @SerializedName("popularity")
    private final Float popularity;
    @SerializedName("title")
    private final String title;
    @SerializedName("video")
    private final Boolean video;
    @SerializedName("vote_average")
    private final Float voteAverage;
    @SerializedName("vote_count")
    private final Integer voteCount;

    private MovieImpl(final Builder builder) {
        adult = builder.adult;
        backdropPath = builder.backdropPath;
        genreIds = builder.genreIds;
        id = builder.id;
        originalLanguage = builder.originalLanguage;
        originalTitle = builder.originalTitle;
        overview = builder.overview;
        releaseDate = builder.releaseDate;
        posterPath = builder.posterPath;
        popularity = builder.popularity;
        title = builder.title;
        video = builder.video;
        voteAverage = builder.voteAverage;
        voteCount = builder.voteCount;
    }

    protected MovieImpl(final Parcel in) {
        this.adult = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.backdropPath = in.readString();
        this.genreIds = new ArrayList<>();
        in.readList(this.genreIds, Integer.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.originalLanguage = in.readString();
        this.originalTitle = in.readString();
        this.overview = in.readString();
        this.releaseDate = in.readString();
        this.posterPath = in.readString();
        this.popularity = (Float) in.readValue(Float.class.getClassLoader());
        this.title = in.readString();
        this.video = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.voteAverage = (Float) in.readValue(Float.class.getClassLoader());
        this.voteCount = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final MovieImpl copy) {
        final Builder builder = new Builder();
        builder.adult = copy.adult;
        builder.backdropPath = copy.backdropPath;
        builder.genreIds = copy.genreIds;
        builder.id = copy.id;
        builder.originalLanguage = copy.originalLanguage;
        builder.originalTitle = copy.originalTitle;
        builder.overview = copy.overview;
        builder.releaseDate = copy.releaseDate;
        builder.posterPath = copy.posterPath;
        builder.popularity = copy.popularity;
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
    public List<Integer> getGenreIds() {
        return genreIds;
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
    public String getReleaseDate() {
        return releaseDate;
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
        dest.writeList(this.genreIds);
        dest.writeValue(this.id);
        dest.writeString(this.originalLanguage);
        dest.writeString(this.originalTitle);
        dest.writeString(this.overview);
        dest.writeString(this.releaseDate);
        dest.writeString(this.posterPath);
        dest.writeValue(this.popularity);
        dest.writeString(this.title);
        dest.writeValue(this.video);
        dest.writeValue(this.voteAverage);
        dest.writeValue(this.voteCount);
    }

    public static final class Builder {
        private Boolean adult;
        private String backdropPath;
        private List<Integer> genreIds;
        private Integer id;
        private String originalLanguage;
        private String originalTitle;
        private String overview;
        private String releaseDate;
        private String posterPath;
        private Float popularity;
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

        public Builder withOriginalTitle(final String val) {
            originalTitle = val;
            return this;
        }

        public Builder withOverview(final String val) {
            overview = val;
            return this;
        }

        public Builder withReleaseDate(final String val) {
            releaseDate = val;
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

        public Movie build() {
            return new MovieImpl(this);
        }
    }
}