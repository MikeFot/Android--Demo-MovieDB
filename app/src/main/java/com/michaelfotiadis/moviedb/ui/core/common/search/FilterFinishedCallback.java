package com.michaelfotiadis.moviedb.ui.core.common.search;

import java.util.List;

public interface FilterFinishedCallback<D> {

    void onSearchFinished(final List<D> results);
}