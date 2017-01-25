package com.michaelfotiadis.moviedb.common.models.genre;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GenreContainerImpl implements GenreContainer {

    public static final Parcelable.Creator<GenreContainer> CREATOR = new Parcelable.Creator<GenreContainer>() {
        @Override
        public GenreContainer createFromParcel(final Parcel source) {
            return new GenreContainerImpl(source);
        }

        @Override
        public GenreContainer[] newArray(final int size) {
            return new GenreContainer[size];
        }
    };
    @SerializedName("genres")
    private final List<Genre> genres;

    private GenreContainerImpl(final Builder builder) {
        genres = builder.genres;
    }

    protected GenreContainerImpl(final Parcel in) {
        this.genres = in.createTypedArrayList(GenreImpl.CREATOR);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final GenreContainerImpl copy) {
        final Builder builder = new Builder();
        builder.genres = copy.genres;
        return builder;
    }

    @Override
    public List<Genre> getGenres() {
        return genres;
    }

    @Override
    public Long getId() {
        return (long) hashCode();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeTypedList(this.genres);
    }

    public static final class Builder {
        private List<Genre> genres;

        private Builder() {
        }

        public Builder withGenres(final List<Genre> val) {
            genres = val;
            return this;
        }

        public GenreContainer build() {
            return new GenreContainerImpl(this);
        }
    }
}