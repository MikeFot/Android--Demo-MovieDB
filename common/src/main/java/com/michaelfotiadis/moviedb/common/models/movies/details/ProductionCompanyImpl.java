package com.michaelfotiadis.moviedb.common.models.movies.details;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class ProductionCompanyImpl implements ProductionCompany {

    public static final Creator<ProductionCompany> CREATOR = new Creator<ProductionCompany>() {
        @Override
        public ProductionCompany createFromParcel(final Parcel source) {
            return new ProductionCompanyImpl(source);
        }

        @Override
        public ProductionCompany[] newArray(final int size) {
            return new ProductionCompany[size];
        }
    };
    @SerializedName("name")
    private final String name;
    @SerializedName("id")
    private final Integer id;

    private ProductionCompanyImpl(final Builder builder) {
        id = builder.id;
        name = builder.name;
    }

    protected ProductionCompanyImpl(final Parcel in) {
        this.name = in.readString();
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final ProductionCompanyImpl copy) {
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
        dest.writeString(this.name);
        dest.writeValue(this.id);
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

        public ProductionCompany build() {
            return new ProductionCompanyImpl(this);
        }
    }
}