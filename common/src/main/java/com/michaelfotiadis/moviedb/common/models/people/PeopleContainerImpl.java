package com.michaelfotiadis.moviedb.common.models.people;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeopleContainerImpl implements PeopleContainer {

    public static final Parcelable.Creator<PeopleContainer> CREATOR = new Parcelable.Creator<PeopleContainer>() {
        @Override
        public PeopleContainer createFromParcel(Parcel source) {
            return new PeopleContainerImpl(source);
        }

        @Override
        public PeopleContainer[] newArray(int size) {
            return new PeopleContainer[size];
        }
    };
    @SerializedName("page")
    private final Integer page;
    @SerializedName("results")
    private final List<Person> people;
    @SerializedName("total_pages")
    private final Integer totalPages;
    @SerializedName("total_results")
    private final Integer totalResults;

    private PeopleContainerImpl(Builder builder) {
        page = builder.page;
        people = builder.people;
        totalPages = builder.totalPages;
        totalResults = builder.totalResults;
    }

    protected PeopleContainerImpl(Parcel in) {
        this.page = (Integer) in.readValue(Integer.class.getClassLoader());
        this.people = in.createTypedArrayList(PersonImpl.CREATOR);
        this.totalPages = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalResults = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(PeopleContainerImpl copy) {
        Builder builder = new Builder();
        builder.page = copy.page;
        builder.people = copy.people;
        builder.totalPages = copy.totalPages;
        builder.totalResults = copy.totalResults;
        return builder;
    }

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public List<Person> getPeople() {
        return people;
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
    public Long getId() {
        return (long) hashCode();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.page);
        dest.writeTypedList(this.people);
        dest.writeValue(this.totalPages);
        dest.writeValue(this.totalResults);
    }

    public static final class Builder {
        private Integer page;
        private List<Person> people;
        private Integer totalPages;
        private Integer totalResults;

        private Builder() {
        }

        public Builder withPage(Integer val) {
            page = val;
            return this;
        }

        public Builder withPeople(List<Person> val) {
            people = val;
            return this;
        }

        public Builder withTotalPages(Integer val) {
            totalPages = val;
            return this;
        }

        public Builder withTotalResults(Integer val) {
            totalResults = val;
            return this;
        }

        public PeopleContainer build() {
            return new PeopleContainerImpl(this);
        }
    }
}
