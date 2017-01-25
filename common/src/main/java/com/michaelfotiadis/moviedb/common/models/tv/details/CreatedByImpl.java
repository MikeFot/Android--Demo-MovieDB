package com.michaelfotiadis.moviedb.common.models.tv.details;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class CreatedByImpl implements CreatedBy {

    public static final Creator<CreatedBy> CREATOR = new Creator<CreatedBy>() {
        @Override
        public CreatedBy createFromParcel(final Parcel source) {
            return new CreatedByImpl(source);
        }

        @Override
        public CreatedBy[] newArray(final int size) {
            return new CreatedBy[size];
        }
    };
    @SerializedName("id")
    private final Integer id;
    @SerializedName("name")
    private final String name;
    @SerializedName("profile_path")
    private final String profilePath;

    private CreatedByImpl(final Builder builder) {
        id = builder.id;
        name = builder.name;
        profilePath = builder.profilePath;
    }

    protected CreatedByImpl(final Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.profilePath = in.readString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final CreatedByImpl copy) {
        final Builder builder = new Builder();
        builder.id = copy.id;
        builder.name = copy.name;
        builder.profilePath = copy.profilePath;
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
    public String getProfilePath() {
        return profilePath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.profilePath);
    }

    public static final class Builder {
        private Integer id;
        private String name;
        private String profilePath;

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

        public Builder withProfilePath(final String val) {
            profilePath = val;
            return this;
        }

        public CreatedBy build() {
            return new CreatedByImpl(this);
        }
    }
}