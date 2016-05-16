package com.michaelfotiadis.moviedb.common.models.people;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class KnownForImpl implements KnownFor {

    @SerializedName("adult")
    private final Boolean adult;
    @SerializedName("backdrop_path")
    private final String backdropPath;
    @SerializedName("id")
    private final Integer id;
    @SerializedName("original_title")
    private final String originalTitle;
    @SerializedName("release_date")
    private final String releaseDate;
    @SerializedName("poster_path")
    private final String posterPath;
    @SerializedName("popularity")
    private final Float popularity;
    @SerializedName("title")
    private final String title;
    @SerializedName("vote_average")
    private final Float voteAverage;
    @SerializedName("vote_count")
    private final Integer voteCount;
    @SerializedName("media_type")
    private final String mediaType;

    private KnownForImpl(Builder builder) {
        adult = builder.adult;
        backdropPath = builder.backdropPath;
        id = builder.id;
        originalTitle = builder.originalTitle;
        releaseDate = builder.releaseDate;
        posterPath = builder.posterPath;
        popularity = builder.popularity;
        title = builder.title;
        voteAverage = builder.voteAverage;
        voteCount = builder.voteCount;
        mediaType = builder.mediaType;
    }


    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(KnownForImpl copy) {
        Builder builder = new Builder();
        builder.adult = copy.adult;
        builder.backdropPath = copy.backdropPath;
        builder.id = copy.id;
        builder.originalTitle = copy.originalTitle;
        builder.releaseDate = copy.releaseDate;
        builder.posterPath = copy.posterPath;
        builder.popularity = copy.popularity;
        builder.title = copy.title;
        builder.voteAverage = copy.voteAverage;
        builder.voteCount = copy.voteCount;
        builder.mediaType = copy.mediaType;
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
    public Long getId() {
        return Long.valueOf(id);
    }

    @Override
    public String getMediaType() {
        return mediaType;
    }

    @Override
    public String getOriginalTitle() {
        return originalTitle;
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
    public Float getVoteAverage() {
        return voteAverage;
    }

    @Override
    public Integer getVoteCount() {
        return voteCount;
    }

    public static final class Builder {
        private Boolean adult;
        private String backdropPath;
        private Integer id;
        private String originalTitle;
        private String releaseDate;
        private String posterPath;
        private Float popularity;
        private String title;
        private Float voteAverage;
        private Integer voteCount;
        private String mediaType;

        private Builder() {
        }

        public Builder withAdult(Boolean val) {
            adult = val;
            return this;
        }

        public Builder withBackdropPath(String val) {
            backdropPath = val;
            return this;
        }

        public Builder withId(Integer val) {
            id = val;
            return this;
        }

        public Builder withOriginalTitle(String val) {
            originalTitle = val;
            return this;
        }

        public Builder withReleaseDate(String val) {
            releaseDate = val;
            return this;
        }

        public Builder withPosterPath(String val) {
            posterPath = val;
            return this;
        }

        public Builder withPopularity(Float val) {
            popularity = val;
            return this;
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withVoteAverage(Float val) {
            voteAverage = val;
            return this;
        }

        public Builder withVoteCount(Integer val) {
            voteCount = val;
            return this;
        }

        public Builder withMediaType(String val) {
            mediaType = val;
            return this;
        }

        public KnownFor build() {
            return new KnownForImpl(this);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.adult);
        dest.writeString(this.backdropPath);
        dest.writeValue(this.id);
        dest.writeString(this.originalTitle);
        dest.writeString(this.releaseDate);
        dest.writeString(this.posterPath);
        dest.writeValue(this.popularity);
        dest.writeString(this.title);
        dest.writeValue(this.voteAverage);
        dest.writeValue(this.voteCount);
        dest.writeString(this.mediaType);
    }

    protected KnownForImpl(Parcel in) {
        this.adult = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.backdropPath = in.readString();
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.originalTitle = in.readString();
        this.releaseDate = in.readString();
        this.posterPath = in.readString();
        this.popularity = (Float) in.readValue(Float.class.getClassLoader());
        this.title = in.readString();
        this.voteAverage = (Float) in.readValue(Float.class.getClassLoader());
        this.voteCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.mediaType = in.readString();
    }

    public static final Parcelable.Creator<KnownFor> CREATOR = new Parcelable.Creator<KnownFor>() {
        @Override
        public KnownFor createFromParcel(Parcel source) {
            return new KnownForImpl(source);
        }

        @Override
        public KnownFor[] newArray(int size) {
            return new KnownFor[size];
        }
    };
}