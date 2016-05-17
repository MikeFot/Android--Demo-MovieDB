package com.michaelfotiadis.moviedb.common.models.movies.details;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class SpokenLanguageImpl implements SpokenLanguage {

    public static final Creator<SpokenLanguage> CREATOR = new Creator<SpokenLanguage>() {
        @Override
        public SpokenLanguage createFromParcel(final Parcel source) {
            return new SpokenLanguageImpl(source);
        }

        @Override
        public SpokenLanguage[] newArray(final int size) {
            return new SpokenLanguage[size];
        }
    };
    @SerializedName("iso_639_1")
    private final String iso6391;
    @SerializedName("name")
    private final String name;

    private SpokenLanguageImpl(final Builder builder) {
        iso6391 = builder.iso6391;
        name = builder.name;
    }

    protected SpokenLanguageImpl(final Parcel in) {
        this.iso6391 = in.readString();
        this.name = in.readString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final SpokenLanguageImpl copy) {
        final Builder builder = new Builder();
        builder.iso6391 = copy.iso6391;
        builder.name = copy.name;
        return builder;
    }

    @Override
    public String getIso6391() {
        return iso6391;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(this.iso6391);
        dest.writeString(this.name);
    }

    public static final class Builder {
        private String iso6391;
        private String name;

        private Builder() {
        }

        public Builder withIso6391(final String val) {
            iso6391 = val;
            return this;
        }

        public Builder withName(final String val) {
            name = val;
            return this;
        }

        public SpokenLanguage build() {
            return new SpokenLanguageImpl(this);
        }
    }
}