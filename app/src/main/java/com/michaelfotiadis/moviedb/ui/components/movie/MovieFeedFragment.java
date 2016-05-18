package com.michaelfotiadis.moviedb.ui.components.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadError;
import com.michaelfotiadis.moviedb.data.loader.DataFeedLoaderCallback;
import com.michaelfotiadis.moviedb.data.loader.UiMovieLoader;
import com.michaelfotiadis.moviedb.data.model.UiMedia;
import com.michaelfotiadis.moviedb.ui.components.media.MediaRecyclerViewAdapter;
import com.michaelfotiadis.moviedb.ui.core.common.error.errorpage.QuoteOnClickListenerWrapper;
import com.michaelfotiadis.moviedb.ui.core.common.fragment.BaseFragment;
import com.michaelfotiadis.moviedb.ui.core.common.fragment.Searchable;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.manager.RecyclerManager;
import com.michaelfotiadis.moviedb.ui.core.common.viewmanagement.SimpleUiStateKeeper;
import com.michaelfotiadis.moviedb.ui.core.common.viewmanagement.UiStateKeeper;
import com.michaelfotiadis.moviedb.utils.AppLog;

import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 */
public class MovieFeedFragment extends BaseFragment implements Searchable {

    @Bind(R.id.recycler_view)
    protected RecyclerView mRecyclerView;
    private RecyclerManager<UiMedia> mRecyclerManager;

    public static Fragment newInstance() {
        return new MovieFeedFragment();
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_default_recycler, container, false);
        ButterKnife.bind(this, view);

        final UiStateKeeper uiStateKeeper = new SimpleUiStateKeeper(view, mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerManager = new RecyclerManager.Builder<>(
                new MediaRecyclerViewAdapter(
                        getActivity(),
                        getImageFetcher(),
                        getIntentDispatcher()))
                .setRecycler(mRecyclerView)
                .setStateKeeper(uiStateKeeper)
                .setEmptyMessage(getString(R.string.friendly_error_no_data))
                .build();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mRecyclerManager.updateUiState();
        if (mRecyclerManager.getItemCount() == 0) {
            AppLog.d("Adapter is empty. Loading data.");
            loadData();
        }
    }

    private void loadData() {

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
                mRecyclerManager.setItems(items);
            }
        });
        AppLog.d("Loading UiMovies");
        loader.loadData();
    }

    private void handleError(final UiDataLoadError error) {
        if (error.isRecoverable()) {
            final QuoteOnClickListenerWrapper wrapper = new QuoteOnClickListenerWrapper(R.string.button_label_error_try_again, new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    loadData();
                }
            });
            mRecyclerManager.setError(error.getMessage(), wrapper);
        } else {
            mRecyclerManager.setError(error.getMessage());
        }
    }

    @Override
    public void setFilter(final String filter) {
        AppLog.d("Fragment got filter " + filter);
    }
}
