package com.michaelfotiadis.moviedb.common.models.guest;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

public class GuestSessionImpl implements GuestSession {

    public static final Creator<GuestSession> CREATOR = new Creator<GuestSession>() {
        @Override
        public GuestSession createFromParcel(final Parcel source) {
            return new GuestSessionImpl(source);
        }

        @Override
        public GuestSession[] newArray(final int size) {
            return new GuestSession[size];
        }
    };
    @SerializedName("success")
    private final Boolean success;
    @SerializedName("guest_session_id")
    private final String guestSessionId;
    @SerializedName("expires_at")
    private final String expiresAt;

    private GuestSessionImpl(final Builder builder) {
        expiresAt = builder.expiresAt;
        success = builder.success;
        guestSessionId = builder.guestSessionId;
    }

    protected GuestSessionImpl(final Parcel in) {
        this.success = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.guestSessionId = in.readString();
        this.expiresAt = in.readString();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(final GuestSessionImpl copy) {
        final Builder builder = new Builder();
        builder.expiresAt = copy.expiresAt;
        builder.success = copy.success;
        builder.guestSessionId = copy.guestSessionId;
        return builder;
    }

    @Override
    public String getExpiresAt() {
        return expiresAt;
    }

    @Override
    public String getGuestSessionId() {
        return guestSessionId;
    }

    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public String getId() {
        return guestSessionId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeValue(this.success);
        dest.writeString(this.guestSessionId);
        dest.writeString(this.expiresAt);
    }

    public static final class Builder {
        private String expiresAt;
        private Boolean success;
        private String guestSessionId;

        private Builder() {
        }

        public Builder withExpiresAt(final String val) {
            expiresAt = val;
            return this;
        }

        public Builder withSuccess(final Boolean val) {
            success = val;
            return this;
        }

        public Builder withGuestSessionId(final String val) {
            guestSessionId = val;
            return this;
        }

        public GuestSession build() {
            return new GuestSessionImpl(this);
        }
    }
}
