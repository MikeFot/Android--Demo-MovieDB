package com.michaelfotiadis.moviedb.common.models.configuration;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConfigurationImpl implements Configuration {

    public static final Creator<Configuration> CREATOR = new Creator<Configuration>() {
        @Override
        public Configuration createFromParcel(final Parcel source) {
            return new ConfigurationImpl(source);
        }

        @Override
        public Configuration[] newArray(final int size) {
            return new Configuration[size];
        }
    };
    @SerializedName("images")
    private final Images images;
    @SerializedName("change_keys")
    private final List<String> changeKeys;

    private ConfigurationImpl(final Builder builder) {
        changeKeys = builder.changeKeys;
        images = builder.images;
    }

    protected ConfigurationImpl(final Parcel in) {
        this.images = in.readParcelable(ImagesImpl.class.getClassLoader());
        this.changeKeys = in.createStringArrayList();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final ConfigurationImpl copy) {
        final Builder builder = new Builder();
        builder.changeKeys = copy.changeKeys;
        builder.images = copy.images;
        return builder;
    }

    @Override
    public List<String> getChangeKeys() {
        return changeKeys;
    }

    @Override
    public Images getImages() {
        return images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeParcelable(this.images, flags);
        dest.writeStringList(this.changeKeys);
    }

    @Override
    public Long getId() {
        return (long) hashCode();
    }

    public static final class Builder {
        private List<String> changeKeys;
        private Images images;

        private Builder() {
        }

        public Builder withChangeKeys(final List<String> val) {
            changeKeys = val;
            return this;
        }

        public Builder withImages(final Images val) {
            images = val;
            return this;
        }

        public Configuration build() {
            return new ConfigurationImpl(this);
        }
    }
}