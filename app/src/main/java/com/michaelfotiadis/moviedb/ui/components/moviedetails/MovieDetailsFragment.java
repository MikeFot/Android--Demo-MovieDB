package com.michaelfotiadis.moviedb.ui.components.moviedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.common.models.movies.details.MovieDetails;
import com.michaelfotiadis.moviedb.ui.core.common.fragment.BaseFragment;

/**
 *
 */
public class MovieDetailsFragment extends BaseFragment {

    private static final String EXTRA = MovieDetailsFragment.class.getSimpleName() + "_extra_1";

    private MovieDetailsBodyViewHolder mHolder;
    private MovieDetailsBodyViewBinder mBinder;

    private String mId;

    public static BaseFragment newInstance(final String id) {

        final BaseFragment fragment = new MovieDetailsFragment();

        final Bundle args = new Bundle();
        args.putString(EXTRA, id);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_movie_details, container, false);

        return view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mHolder = new MovieDetailsBodyViewHolder(view);
        mBinder = new MovieDetailsBodyViewBinder(getActivity(), getImageFetcher(), getIntentDispatcher());

    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mId = getArguments().getString(EXTRA);
        } else {
            getActivity().finish();
        }
    }

    protected void setData(final MovieDetails details) {

        mBinder.bind(mHolder, details);

    }

}
