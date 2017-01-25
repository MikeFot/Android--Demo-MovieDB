package com.michaelfotiadis.moviedb.common.models.tv;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvSeriesContainerImpl implements TvSeriesContainer {

    public static final Creator<TvSeriesContainer> CREATOR = new Creator<TvSeriesContainer>() {
        @Override
        public TvSeriesContainer createFromParcel(final Parcel source) {
            return new TvSeriesContainerImpl(source);
        }

        @Override
        public TvSeriesContainer[] newArray(final int size) {
            return new TvSeriesContainer[size];
        }
    };
    @SerializedName("page")
    private final Integer page;
    @SerializedName("results")
    private final List<TvSeries> series;
    @SerializedName("total_pages")
    private final Integer totalPages;
    @SerializedName("total_results")
    private final Integer totalResults;

    private TvSeriesContainerImpl(final Builder builder) {
        page = builder.page;
        series = builder.series;
        totalPages = builder.totalPages;
        totalResults = builder.totalResults;
    }

    protected TvSeriesContainerImpl(final Parcel in) {
        this.page = (Integer) in.readValue(Integer.class.getClassLoader());
        this.series = in.createTypedArrayList(TvSeriesImpl.CREATOR);
        this.totalPages = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalResults = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final TvSeriesContainerImpl copy) {
        final Builder builder = new Builder();
        builder.page = copy.page;
        builder.series = copy.series;
        builder.totalPages = copy.totalPages;
        builder.totalResults = copy.totalResults;
        return builder;
    }

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public List<TvSeries> getSeries() {
        return series;
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
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeValue(this.page);
        dest.writeTypedList(this.series);
        dest.writeValue(this.totalPages);
        dest.writeValue(this.totalResults);
    }

    public static final class Builder {
        private Integer page;
        private List<TvSeries> series;
        private Integer totalPages;
        private Integer totalResults;

        private Builder() {
        }

        public Builder withPage(final Integer val) {
            page = val;
            return this;
        }

        public Builder withSeries(final List<TvSeries> val) {
            series = val;
            return this;
        }

        public Builder withTotalPages(final Integer val) {
            totalPages = val;
            return this;
        }

        public Builder withTotalResults(final Integer val) {
            totalResults = val;
            return this;
        }

        public TvSeriesContainer build() {
            return new TvSeriesContainerImpl(this);
        }
    }
}