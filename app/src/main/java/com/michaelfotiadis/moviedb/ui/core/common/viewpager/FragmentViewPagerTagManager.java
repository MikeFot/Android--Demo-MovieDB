package com.michaelfotiadis.moviedb.ui.core.common.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.HashMap;

public class FragmentViewPagerTagManager {
    final FragmentManager fragmentManager;
    private final HashMap<Integer, String> fragmentTags = new HashMap<>();

    public FragmentViewPagerTagManager(final FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public Fragment get(final int position) {
        return this.fragmentManager.findFragmentByTag(this.fragmentTags.get(Integer.valueOf(position)));
    }

    public boolean has(final int position) {
        return this.fragmentTags.containsKey(Integer.valueOf(position)) && this.fragmentManager.findFragmentByTag(this.fragmentTags.get(Integer.valueOf(position))) != null;
    }

    public Fragment itemInstantiated(final int position, final Fragment fragment) {
        this.fragmentTags.put(position, fragment.getTag());
        return fragment;
    }
}
