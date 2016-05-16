package com.michaelfotiadis.moviedb.ui.components.home;

import android.os.Bundle;

import com.crashlytics.android.Crashlytics;
import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.ui.core.common.activity.BaseActivity;

import io.fabric.sdk.android.Fabric;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_default_fragment_container);
    }
}
