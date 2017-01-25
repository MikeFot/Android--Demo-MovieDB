package com.michaelfotiadis.moviedb.common.models.movies.details;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class BelongsToCollectionImpl implements BelongsToCollection {

    public static final Creator<BelongsToCollection> CREATOR = new Creator<BelongsToCollection>() {
        @Override
        public BelongsToCollection createFromParcel(final Parcel source) {
            return new BelongsToCollectionImpl(source);
        }

        @Override
        public BelongsToCollection[] newArray(final int size) {
            return new BelongsToCollection[size];
        }
    };
    @SerializedName("id")
    private final Integer id;
    @SerializedName("name")
    private final String name;
    @SerializedName("poster_path")
    private final String posterPath;
    @SerializedName("backdrop_path")
    private final String backdropPath;

    private BelongsToCollectionImpl(final Builder builder) {
        backdropPath = builder.backdropPath;
        id = builder.id;
        name = builder.name;
        posterPath = builder.posterPath;
    }

    protected BelongsToCollectionImpl(final Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.posterPath = in.readString();
        this.backdropPath = in.readString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final BelongsToCollectionImpl copy) {
        final Builder builder = new Builder();
        builder.backdropPath = copy.backdropPath;
        builder.id = copy.id;
        builder.name = copy.name;
        builder.posterPath = copy.posterPath;
        return builder;
    }

    @Override
    public String getBackdropPath() {
        return backdropPath;
    }

    public Long getId() {
        return Long.valueOf(id);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPosterPath() {
        return posterPath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.posterPath);
        dest.writeString(this.backdropPath);
    }

    public static final class Builder {
        private String backdropPath;
        private Integer id;
        private String name;
        private String posterPath;

        private Builder() {
        }

        public Builder withBackdropPath(final String val) {
            backdropPath = val;
            return this;
        }

        public Builder withId(final Integer val) {
            id = val;
            return this;
        }

        public Builder withName(final String val) {
            name = val;
            return this;
        }

        public Builder withPosterPath(final String val) {
            posterPath = val;
            return this;
        }

        public BelongsToCollection build() {
            return new BelongsToCollectionImpl(this);
        }
    }
}