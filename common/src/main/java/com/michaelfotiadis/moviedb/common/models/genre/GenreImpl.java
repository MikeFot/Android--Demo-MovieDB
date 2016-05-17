package com.michaelfotiadis.moviedb.common.models.genre;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class GenreImpl implements Genre {

    public static final Creator<Genre> CREATOR = new Creator<Genre>() {
        @Override
        public Genre createFromParcel(final Parcel source) {
            return new GenreImpl(source);
        }

        @Override
        public Genre[] newArray(final int size) {
            return new Genre[size];
        }
    };
    @SerializedName("id")
    private final Integer id;
    @SerializedName("name")
    private final String name;

    private GenreImpl(final Builder builder) {
        id = builder.id;
        name = builder.name;
    }

    protected GenreImpl(final Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final GenreImpl copy) {
        final Builder builder = new Builder();
        builder.id = copy.id;
        builder.name = copy.name;
        return builder;
    }

    @Override
    public String getName() {
        return name;
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
        dest.writeValue(this.id);
        dest.writeString(this.name);
    }

    public static final class Builder {
        private Integer id;
        private String name;

        private Builder() {
        }

        public Builder withId(final Integer val) {
            id = val;
            return this;
        }

        public Builder withName(final String val) {
            name = val;
            return this;
        }

        public Genre build() {
            return new GenreImpl(this);
        }
    }
}