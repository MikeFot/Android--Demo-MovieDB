package com.michaelfotiadis.moviedb.common.models.movies.details;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class ProductionCountryImpl implements ProductionCountry {

    public static final Creator<ProductionCountry> CREATOR = new Creator<ProductionCountry>() {
        @Override
        public ProductionCountry createFromParcel(final Parcel source) {
            return new ProductionCountryImpl(source);
        }

        @Override
        public ProductionCountry[] newArray(final int size) {
            return new ProductionCountry[size];
        }
    };
    @SerializedName("iso_3166_1")
    private final String iso31661;
    @SerializedName("name")
    private final String name;

    private ProductionCountryImpl(final Builder builder) {
        iso31661 = builder.iso31661;
        name = builder.name;
    }

    protected ProductionCountryImpl(final Parcel in) {
        this.iso31661 = in.readString();
        this.name = in.readString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final ProductionCountryImpl copy) {
        final Builder builder = new Builder();
        builder.iso31661 = copy.iso31661;
        builder.name = copy.name;
        return builder;
    }

    @Override
    public String getIso31661() {
        return iso31661;
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
        dest.writeString(this.iso31661);
        dest.writeString(this.name);
    }

    @Override
    public String getId() {
        return name;
    }

    public static final class Builder {
        private String iso31661;
        private String name;

        private Builder() {
        }

        public Builder withIso31661(final String val) {
            iso31661 = val;
            return this;
        }

        public Builder withName(final String val) {
            name = val;
            return this;
        }

        public ProductionCountry build() {
            return new ProductionCountryImpl(this);
        }
    }
}