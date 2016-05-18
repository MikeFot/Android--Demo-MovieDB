package com.michaelfotiadis.moviedb.common.models.tv.details;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class SeasonImpl implements Season {

    public static final Creator<Season> CREATOR = new Creator<Season>() {
        @Override
        public Season createFromParcel(Parcel source) {
            return new SeasonImpl(source);
        }

        @Override
        public Season[] newArray(int size) {
            return new Season[size];
        }
    };
    @SerializedName("air_date")
    private final String airDate;
    @SerializedName("episode_count")
    private final Integer episodeCount;
    @SerializedName("id")
    private final Integer id;
    @SerializedName("poster_path")
    private final String posterPath;
    @SerializedName("season_number")
    private final Integer seasonNumber;

    @Override
    public Integer getEpisodeCount() {
        return episodeCount;
    }

    @Override
    public Long getId() {
        return Long.valueOf(id);
    }

    @Override
    public String getPosterPath() {
        return posterPath;
    }

    @Override
    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    private SeasonImpl(Builder builder) {
        airDate = builder.airDate;
        episodeCount = builder.episodeCount;
        id = builder.id;
        posterPath = builder.posterPath;
        seasonNumber = builder.seasonNumber;
    }

    protected SeasonImpl(Parcel in) {
        this.airDate = in.readString();
        this.episodeCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.posterPath = in.readString();
        this.seasonNumber = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(SeasonImpl copy) {
        Builder builder = new Builder();
        builder.airDate = copy.airDate;
        builder.episodeCount = copy.episodeCount;
        builder.id = copy.id;
        builder.posterPath = copy.posterPath;
        builder.seasonNumber = copy.seasonNumber;
        return builder;
    }

    @Override
    public String getAirDate() {
        return airDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.airDate);
        dest.writeValue(this.episodeCount);
        dest.writeValue(this.id);
        dest.writeString(this.posterPath);
        dest.writeValue(this.seasonNumber);
    }

    public static final class Builder {
        private String airDate;
        private Integer episodeCount;
        private Integer id;
        private String posterPath;
        private Integer seasonNumber;

        private Builder() {
        }

        public Builder withAirDate(String val) {
            airDate = val;
            return this;
        }

        public Builder withEpisodeCount(Integer val) {
            episodeCount = val;
            return this;
        }

        public Builder withId(Integer val) {
            id = val;
            return this;
        }

        public Builder withPosterPath(String val) {
            posterPath = val;
            return this;
        }

        public Builder withSeasonNumber(Integer val) {
            seasonNumber = val;
            return this;
        }

        public Season build() {
            return new SeasonImpl(this);
        }
    }
}