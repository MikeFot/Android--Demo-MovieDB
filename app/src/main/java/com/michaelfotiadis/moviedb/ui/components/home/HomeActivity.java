package com.michaelfotiadis.moviedb.ui.components.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.michaelfotiadis.moviedb.R;

import io.fabric.sdk.android.Fabric;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_default_fragment_container);
    }
}
