package com.michaelfotiadis.moviedb.common.models.guest;

import com.michaelfotiadis.moviedb.common.models.base.app.AppModel;
import com.michaelfotiadis.moviedb.common.models.base.app.WithStringId;

/**
 *
 */
public interface GuestSession extends AppModel, WithStringId {
    String getExpiresAt();

    String getGuestSessionId();

    Boolean getSuccess();
}
