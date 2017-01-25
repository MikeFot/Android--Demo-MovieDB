package com.michaelfotiadis.moviedb.ui.core.common.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michaelfotiadis.moviedb.ui.core.common.activity.BaseActivity;
import com.michaelfotiadis.moviedb.ui.core.common.notifications.ActivityNotificationController;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcher;
import com.michaelfotiadis.moviedb.ui.core.imagefetcher.ImageFetcherImpl;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcher;
import com.michaelfotiadis.moviedb.ui.core.intent.dispatch.IntentDispatcherImpl;
import com.michaelfotiadis.moviedb.utils.error.CrashlyticsLogKeyController;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    private ImageFetcher mImageFetcher;
    private IntentDispatcher mIntentDispatcher;

    protected ImageFetcher getImageFetcher() {
        return mImageFetcher;
    }

    protected IntentDispatcher getIntentDispatcher() {
        return mIntentDispatcher;
    }

    protected ActivityNotificationController getNotificationController() {
        return ((BaseActivity) getActivity()).getNotificationController();
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            mImageFetcher = new ImageFetcherImpl((Activity) context);
            mIntentDispatcher = new IntentDispatcherImpl((Activity) context);
        }
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        CrashlyticsLogKeyController.onCreate(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        CrashlyticsLogKeyController.onPause(this);
        super.onPause();
    }

    @Override
    public void onResume() {
        CrashlyticsLogKeyController.onResume(this);
        super.onResume();
    }
}