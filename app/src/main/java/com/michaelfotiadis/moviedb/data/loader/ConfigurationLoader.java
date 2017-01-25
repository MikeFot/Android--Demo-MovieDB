package com.michaelfotiadis.moviedb.data.loader;

import android.app.Activity;

import com.michaelfotiadis.moviedb.common.models.configuration.Configuration;
import com.michaelfotiadis.moviedb.common.responses.CommonCallback;
import com.michaelfotiadis.moviedb.common.responses.CommonDeliverable;
import com.michaelfotiadis.moviedb.common.responses.CommonError;
import com.michaelfotiadis.moviedb.core.DemoCore;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadError;
import com.michaelfotiadis.moviedb.data.error.UiDataLoadErrorFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ConfigurationLoader extends DataFeedLoaderAbstract<Configuration> {

    public ConfigurationLoader(final Activity activity) {
        super(activity);
    }

    @Override
    public void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                // move the current Thread into the background
                android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);

                DemoCore.getDataProvider().getConfiguration(new CommonCallback<Configuration>() {
                    @Override
                    public void onFailure(final CommonError error) {
                        final UiDataLoadError uiError = UiDataLoadErrorFactory.createError(getActivity(), error);
                        notifyError(uiError);
                    }

                    @Override
                    public void onSuccess(final CommonDeliverable<Configuration> deliverable) {

                        final List<Configuration> result = new ArrayList<Configuration>();
                        result.add(deliverable.getContent());

                        notifySuccess(result);
                    }
                });

            }
        }).start();

    }
}
