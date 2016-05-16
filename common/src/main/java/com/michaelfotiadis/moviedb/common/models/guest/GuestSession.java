package com.michaelfotiadis.moviedb.common.models.guest;

import com.michaelfotiadis.moviedb.common.models.base.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.WithStringId;

/**
 *
 */
public interface GuestSession extends AppModel, WithStringId {
    String getExpiresAt();

    String getGuestSessionId();

    Boolean getSuccess();
}
