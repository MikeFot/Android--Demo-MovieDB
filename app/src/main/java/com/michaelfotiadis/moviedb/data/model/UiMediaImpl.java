package com.michaelfotiadis.moviedb.data.model;

import android.os.Parcel;

/**
 *
 */
public class UiMediaImpl implements UiMedia {

    public static final Creator<UiMedia> CREATOR = new Creator<UiMedia>() {
        @Override
        public UiMedia createFromParcel(final Parcel source) {
            return new UiMediaImpl(source);
        }

        @Override
        public UiMedia[] newArray(final int size) {
            return new UiMedia[size];
        }
    };
    private final Long id;
    private final String posterUrl;
    private final String title;
    private final String year;
    private final String rating;
    private final String description;
    private final String genres;

    private UiMediaImpl(final Builder builder) {
        description = builder.description;
        id = builder.id;
        posterUrl = builder.posterUrl;
        title = builder.title;
        year = builder.year;
        rating = builder.rating;
        genres = builder.genres;
    }

    protected UiMediaImpl(final Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.posterUrl = in.readString();
        this.title = in.readString();
        this.year = in.readString();
        this.rating = in.readString();
        this.description = in.readString();
        this.genres = in.readString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final UiMediaImpl copy) {
        final Builder builder = new Builder();
        builder.description = copy.description;
        builder.id = copy.id;
        builder.posterUrl = copy.posterUrl;
        builder.title = copy.title;
        builder.year = copy.year;
        builder.rating = copy.rating;
        builder.genres = copy.genres;
        return builder;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getGenres() {
        return genres;
    }

    @Override
    public String getPosterUrl() {
        return posterUrl;
    }

    @Override
    public String getRating() {
        return rating;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getYear() {
        return year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.posterUrl);
        dest.writeString(this.title);
        dest.writeString(this.year);
        dest.writeString(this.rating);
        dest.writeString(this.description);
        dest.writeString(this.genres);
    }

    @Override
    public Long getId() {
        return id;
    }

    public static final class Builder {
        private String description;
        private Long id;
        private String posterUrl;
        private String title;
        private String year;
        private String rating;
        private String genres;

        private Builder() {
        }

        public Builder withDescription(final String val) {
            description = val;
            return this;
        }

        public Builder withId(final Long val) {
            id = val;
            return this;
        }

        public Builder withPosterUrl(final String val) {
            posterUrl = val;
            return this;
        }

        public Builder withTitle(final String val) {
            title = val;
            return this;
        }

        public Builder withYear(final String val) {
            year = val;
            return this;
        }

        public Builder withRating(final String val) {
            rating = val;
            return this;
        }

        public Builder withGenres(final String val) {
            genres = val;
            return this;
        }

        public UiMedia build() {
            return new UiMediaImpl(this);
        }
    }
}
