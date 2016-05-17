package com.michaelfotiadis.moviedb.ui.components.moviedetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.ui.core.common.activity.BaseActivity;
import com.michaelfotiadis.moviedb.utils.AppLog;

public class MovieDetailsActivity extends BaseActivity {

    private static final String EXTRA = MovieDetailsActivity.class.getSimpleName() + "_extra_1";

    private static final String FRAGMENT_TAG =
            MovieDetailsActivity.class.getSimpleName() + "_fragment_tag";

    public static Intent getInstance(final Context context,
                                     final String movieId) {

        final Intent intent = new Intent(context, MovieDetailsActivity.class);
        intent.putExtra(EXTRA, movieId);
        return intent;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_default_fragment_container);
        setTitle(getString(R.string.title_movie_details));

        final Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final String id = extras.getString(EXTRA);
            if (!TextUtils.isEmpty(id)) {
                AppLog.d("Got id " + id);
                addContentFragmentIfMissing(
                        MovieDetailsFragment.newInstance(id),
                        FRAGMENT_TAG);
            }
        }
    }

}
