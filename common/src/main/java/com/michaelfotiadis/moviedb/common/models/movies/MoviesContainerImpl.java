package com.michaelfotiadis.moviedb.common.models.movies;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesContainerImpl implements MoviesContainer {

    public static final Parcelable.Creator<MoviesContainer> CREATOR = new Parcelable.Creator<MoviesContainer>() {
        @Override
        public MoviesContainer createFromParcel(final Parcel source) {
            return new MoviesContainerImpl(source);
        }

        @Override
        public MoviesContainer[] newArray(final int size) {
            return new MoviesContainer[size];
        }
    };
    @SerializedName("page")
    private final Integer page;
    @SerializedName("results")
    private final List<Movie> movies;
    @SerializedName("total_pages")
    private final Integer totalPages;
    @SerializedName("total_results")
    private final Integer totalResults;

    private MoviesContainerImpl(final Builder builder) {
        page = builder.page;
        movies = builder.results;
        totalPages = builder.totalPages;
        totalResults = builder.totalResults;
    }

    protected MoviesContainerImpl(final Parcel in) {
        this.page = (Integer) in.readValue(Integer.class.getClassLoader());
        this.movies = in.createTypedArrayList(MovieImpl.CREATOR);
        this.totalPages = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalResults = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final MoviesContainerImpl copy) {
        final Builder builder = new Builder();
        builder.page = copy.page;
        builder.results = copy.movies;
        builder.totalPages = copy.totalPages;
        builder.totalResults = copy.totalResults;
        return builder;
    }

    @Override
    public Long getId() {
        return (long) hashCode();
    }

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public Integer getTotalPages() {
        return totalPages;
    }

    @Override
    public Integer getTotalResults() {
        return totalResults;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeValue(this.page);
        dest.writeTypedList(this.movies);
        dest.writeValue(this.totalPages);
        dest.writeValue(this.totalResults);
    }

    public static final class Builder {
        private Integer page;
        private List<Movie> results;
        private Integer totalPages;
        private Integer totalResults;

        private Builder() {
        }

        public Builder withPage(final Integer val) {
            page = val;
            return this;
        }

        public Builder withResults(final List<Movie> val) {
            results = val;
            return this;
        }

        public Builder withTotalPages(final Integer val) {
            totalPages = val;
            return this;
        }

        public Builder withTotalResults(final Integer val) {
            totalResults = val;
            return this;
        }

        public MoviesContainer build() {
            return new MoviesContainerImpl(this);
        }
    }
}