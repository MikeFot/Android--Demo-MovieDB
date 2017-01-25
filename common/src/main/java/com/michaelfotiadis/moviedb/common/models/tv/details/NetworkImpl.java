package com.michaelfotiadis.moviedb.common.models.tv.details;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class NetworkImpl implements Network {

    public static final Creator<Network> CREATOR = new Creator<Network>() {
        @Override
        public Network createFromParcel(final Parcel source) {
            return new NetworkImpl(source);
        }

        @Override
        public Network[] newArray(final int size) {
            return new Network[size];
        }
    };
    @SerializedName("id")
    private final Integer id;
    @SerializedName("name")
    private final String name;

    private NetworkImpl(final Builder builder) {
        id = builder.id;
        name = builder.name;
    }

    protected NetworkImpl(final Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final NetworkImpl copy) {
        final Builder builder = new Builder();
        builder.id = copy.id;
        builder.name = copy.name;
        return builder;
    }

    @Override
    public Long getId() {
        return Long.valueOf(id);
    }

    @Override
    public String getName() {
        return name;
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

        public Network build() {
            return new NetworkImpl(this);
        }
    }
}