package com.michaelfotiadis.moviedb.ui.components.media;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadError;
import com.michaelfotiadis.moviedb.data.model.UiMedia;
import com.michaelfotiadis.moviedb.ui.core.common.error.errorpage.QuoteOnClickListenerWrapper;
import com.michaelfotiadis.moviedb.ui.core.common.fragment.BaseFragment;
import com.michaelfotiadis.moviedb.ui.core.common.fragment.Searchable;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.manager.RecyclerManager;
import com.michaelfotiadis.moviedb.ui.core.common.search.FilterFinishedCallback;
import com.michaelfotiadis.moviedb.ui.core.common.viewmanagement.SimpleUiStateKeeper;
import com.michaelfotiadis.moviedb.ui.core.common.viewmanagement.UiStateKeeper;
import com.michaelfotiadis.moviedb.utils.AppLog;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 */
public abstract class MediaFeedFragment extends BaseFragment implements Searchable {
    @Bind(R.id.recycler_view)
    protected RecyclerView mRecyclerView;
    protected RecyclerManager<UiMedia> mRecyclerManager;
    protected MediaSearcher mSearcher;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             @Nullable final Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_default_recycler, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
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

    protected abstract void loadData();

    protected void handleError(final UiDataLoadError error) {
        if (error.isRecoverable()) {
            final QuoteOnClickListenerWrapper wrapper = new QuoteOnClickListenerWrapper(
                    R.string.button_label_error_try_again,
                    new View.OnClickListener() {
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
        if (mSearcher != null) {
            mSearcher.filter(filter, new FilterFinishedCallback<UiMedia>() {
                @Override
                public void onSearchFinished(final List<UiMedia> results) {
                    mRecyclerManager.setItems(results);
                }
            });
        }
    }
}
