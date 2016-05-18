package com.michaelfotiadis.moviedb.ui.components.movie;

import android.support.v4.app.Fragment;

import com.michaelfotiadis.moviedb.data.error.UiDataLoadError;
import com.michaelfotiadis.moviedb.data.loader.DataFeedLoaderCallback;
import com.michaelfotiadis.moviedb.data.loader.UiMovieLoader;
import com.michaelfotiadis.moviedb.data.model.UiMedia;
import com.michaelfotiadis.moviedb.ui.components.media.MediaFeedFragment;
import com.michaelfotiadis.moviedb.ui.components.media.MediaSearcher;
import com.michaelfotiadis.moviedb.ui.core.common.search.DataFilter;
import com.michaelfotiadis.moviedb.ui.core.common.search.FilterFinishedCallback;
import com.michaelfotiadis.moviedb.utils.AppLog;

import java.util.List;
import java.util.Locale;

/**
 *
 */
public class MovieFeedFragment extends MediaFeedFragment {

    public static Fragment newInstance() {
        return new MovieFeedFragment();
    }

    @Override
    protected void loadData() {

        final UiMovieLoader loader = new UiMovieLoader(getActivity());

        loader.setCallback(new DataFeedLoaderCallback<UiMedia>() {
            @Override
            public void onError(final UiDataLoadError error) {
                AppLog.e(String.format("Error %s", error));
                handleError(error);
            }

            @Override
            public void onSuccess(final List<UiMedia> items) {
                AppLog.d(String.format(Locale.UK, "Loaded %d Ui movies", items.size()));
                mRecyclerManager.clearError();
                mSearcher = new MediaSearcher(items);
                mSearcher.setEmptyQueryBehaviour(DataFilter.EmptyQueryBehaviour.SHOW_ALL);
                mSearcher.filter(null, new FilterFinishedCallback<UiMedia>() {
                    @Override
                    public void onSearchFinished(final List<UiMedia> results) {
                        mRecyclerManager.setItems(results);
                    }
                });

            }
        });
        AppLog.d("Loading UiMovies");
        loader.loadData();
    }

}
