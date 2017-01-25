package com.michaelfotiadis.moviedb.common.models.configuration;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImagesImpl implements Images {

    public static final Creator<Images> CREATOR = new Creator<Images>() {
        @Override
        public Images createFromParcel(final Parcel source) {
            return new ImagesImpl(source);
        }

        @Override
        public Images[] newArray(final int size) {
            return new Images[size];
        }
    };
    @SerializedName("base_url")
    private final String baseUrl;
    @SerializedName("secure_base_url")
    private final String secureBaseUrl;
    @SerializedName("backdrop_sizes")
    private final List<String> backdropSizes;
    @SerializedName("logo_sizes")
    private final List<String> logoSizes;
    @SerializedName("poster_sizes")
    private final List<String> posterSizes;
    @SerializedName("profile_sizes")
    private final List<String> profileSizes;
    @SerializedName("still_sizes")
    private final List<String> stillSizes;

    private ImagesImpl(final Builder builder) {
        backdropSizes = builder.backdropSizes;
        baseUrl = builder.baseUrl;
        secureBaseUrl = builder.secureBaseUrl;
        logoSizes = builder.logoSizes;
        posterSizes = builder.posterSizes;
        profileSizes = builder.profileSizes;
        stillSizes = builder.stillSizes;
    }

    protected ImagesImpl(final Parcel in) {
        this.baseUrl = in.readString();
        this.secureBaseUrl = in.readString();
        this.backdropSizes = in.createStringArrayList();
        this.logoSizes = in.createStringArrayList();
        this.posterSizes = in.createStringArrayList();
        this.profileSizes = in.createStringArrayList();
        this.stillSizes = in.createStringArrayList();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final ImagesImpl copy) {
        final Builder builder = new Builder();
        builder.backdropSizes = copy.backdropSizes;
        builder.baseUrl = copy.baseUrl;
        builder.secureBaseUrl = copy.secureBaseUrl;
        builder.logoSizes = copy.logoSizes;
        builder.posterSizes = copy.posterSizes;
        builder.profileSizes = copy.profileSizes;
        builder.stillSizes = copy.stillSizes;
        return builder;
    }

    @Override
    public List<String> getBackdropSizes() {
        return backdropSizes;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public List<String> getLogoSizes() {
        return logoSizes;
    }

    @Override
    public List<String> getPosterSizes() {
        return posterSizes;
    }

    @Override
    public List<String> getProfileSizes() {
        return profileSizes;
    }

    @Override
    public String getSecureBaseUrl() {
        return secureBaseUrl;
    }

    @Override
    public List<String> getStillSizes() {
        return stillSizes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(this.baseUrl);
        dest.writeString(this.secureBaseUrl);
        dest.writeStringList(this.backdropSizes);
        dest.writeStringList(this.logoSizes);
        dest.writeStringList(this.posterSizes);
        dest.writeStringList(this.profileSizes);
        dest.writeStringList(this.stillSizes);
    }

    @Override
    public Long getId() {
        return (long) hashCode();
    }

    public static final class Builder {
        private List<String> backdropSizes;
        private String baseUrl;
        private String secureBaseUrl;
        private List<String> logoSizes;
        private List<String> posterSizes;
        private List<String> profileSizes;
        private List<String> stillSizes;

        private Builder() {
        }

        public Builder withBackdropSizes(final List<String> val) {
            backdropSizes = val;
            return this;
        }

        public Builder withBaseUrl(final String val) {
            baseUrl = val;
            return this;
        }

        public Builder withSecureBaseUrl(final String val) {
            secureBaseUrl = val;
            return this;
        }

        public Builder withLogoSizes(final List<String> val) {
            logoSizes = val;
            return this;
        }

        public Builder withPosterSizes(final List<String> val) {
            posterSizes = val;
            return this;
        }

        public Builder withProfileSizes(final List<String> val) {
            profileSizes = val;
            return this;
        }

        public Builder withStillSizes(final List<String> val) {
            stillSizes = val;
            return this;
        }

        public Images build() {
            return new ImagesImpl(this);
        }
    }
}