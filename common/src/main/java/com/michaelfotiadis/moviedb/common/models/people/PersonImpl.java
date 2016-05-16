package com.michaelfotiadis.moviedb.common.models.people;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonImpl implements Person {

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new PersonImpl(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
    @SerializedName("adult")
    private final Boolean adult;
    @SerializedName("id")
    private final Integer id;
    @SerializedName("known_for")
    private final List<KnownFor> knownFor;
    @SerializedName("name")
    private final String name;
    @SerializedName("popularity")
    private final Float popularity;
    @SerializedName("profile_path")
    private final String profilePath;

    protected PersonImpl(Parcel in) {
        this.adult = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.knownFor = in.createTypedArrayList(KnownForImpl.CREATOR);
        this.name = in.readString();
        this.popularity = (Float) in.readValue(Float.class.getClassLoader());
        this.profilePath = in.readString();
    }

    private PersonImpl(Builder builder) {
        adult = builder.adult;
        id = builder.id;
        knownFor = builder.knownFor;
        name = builder.name;
        popularity = builder.popularity;
        profilePath = builder.profilePath;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(PersonImpl copy) {
        Builder builder = new Builder();
        builder.adult = copy.adult;
        builder.id = copy.id;
        builder.knownFor = copy.knownFor;
        builder.name = copy.name;
        builder.popularity = copy.popularity;
        builder.profilePath = copy.profilePath;
        return builder;
    }

    @Override
    public Boolean getAdult() {
        return adult;
    }

    @Override
    public Long getId() {
        return Long.valueOf(id);
    }

    @Override
    public List<KnownFor> getKnownFor() {
        return knownFor;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Float getPopularity() {
        return popularity;
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.adult);
        dest.writeValue(this.id);
        dest.writeTypedList(this.knownFor);
        dest.writeString(this.name);
        dest.writeValue(this.popularity);
        dest.writeString(this.profilePath);
    }

    public static final class Builder {
        private Boolean adult;
        private Integer id;
        private List<KnownFor> knownFor;
        private String name;
        private Float popularity;
        private String profilePath;

        private Builder() {
        }

        public Builder withAdult(Boolean val) {
            adult = val;
            return this;
        }

        public Builder withId(Integer val) {
            id = val;
            return this;
        }

        public Builder withKnownFor(List<KnownFor> val) {
            knownFor = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withPopularity(Float val) {
            popularity = val;
            return this;
        }

        public Builder withProfilePath(String val) {
            profilePath = val;
            return this;
        }

        public Person build() {
            return new PersonImpl(this);
        }
    }
}