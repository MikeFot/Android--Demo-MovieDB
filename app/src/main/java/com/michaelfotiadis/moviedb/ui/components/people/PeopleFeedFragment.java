package com.michaelfotiadis.moviedb.ui.components.people;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.common.models.people.Person;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadError;
import com.michaelfotiadis.moviedb.data.loader.DataFeedLoaderCallback;
import com.michaelfotiadis.moviedb.data.loader.PeopleLoader;
import com.michaelfotiadis.moviedb.ui.core.common.error.errorpage.QuoteOnClickListenerWrapper;
import com.michaelfotiadis.moviedb.ui.core.common.fragment.BaseFragment;
import com.michaelfotiadis.moviedb.ui.core.common.recyclerview.manager.RecyclerManager;
import com.michaelfotiadis.moviedb.ui.core.common.viewmanagement.SimpleUiStateKeeper;
import com.michaelfotiadis.moviedb.ui.core.common.viewmanagement.UiStateKeeper;
import com.michaelfotiadis.moviedb.utils.AppLog;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 */
public class PeopleFeedFragment extends BaseFragment {


    @Bind(R.id.recycler_view)
    protected RecyclerView mRecyclerView;
    private RecyclerManager<Person> mRecyclerManager;

    public static PeopleFeedFragment newInstance() {
        return new PeopleFeedFragment();
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
                new PeopleRecyclerViewAdapter(getActivity(), getImageFetcher(), getIntentDispatcher()))
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
        final PeopleLoader loader = new PeopleLoader(getActivity());

        loader.setCallback(new DataFeedLoaderCallback<Person>() {
            @Override
            public void onError(final UiDataLoadError error) {
                AppLog.e(String.format("Error %s", error));
                handleError(error);
            }

            @Override
            public void onSuccess(final List<Person> items) {
                AppLog.d(String.format("Loaded %d movies", items.size()));
                mRecyclerManager.clearError();
                mRecyclerManager.setItems(items);
            }
        });
        AppLog.d("Loading Movies");
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

}
