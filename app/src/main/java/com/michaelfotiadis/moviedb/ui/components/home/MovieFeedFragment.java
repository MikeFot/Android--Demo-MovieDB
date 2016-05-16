package com.michaelfotiadis.moviedb.ui.components.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.ui.core.common.fragment.BaseFragment;

/**
 *
 */
public class MovieFeedFragment extends BaseFragment {


    public static MovieFeedFragment newInstance() {
        return new MovieFeedFragment();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_default_recycler, container, false);

        return view;
    }

}
