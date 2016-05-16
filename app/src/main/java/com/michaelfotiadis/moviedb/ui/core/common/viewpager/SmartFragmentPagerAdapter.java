package com.michaelfotiadis.moviedb.ui.core.common.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class SmartFragmentPagerAdapter extends FragmentPagerAdapter {

    private final FragmentManager fragmentManager;
    private final FragmentViewPagerTagManager fragmentViewPagerTagManager;
    private FragmentAttachedListener fragmentAttachedListener;
    private Fragment[] fragments = {};
    private CharSequence[] titles = {};

    public SmartFragmentPagerAdapter(final FragmentManager fragmentManager) {
        super(fragmentManager);
        this.fragmentViewPagerTagManager = new FragmentViewPagerTagManager(fragmentManager);
        this.fragmentManager = fragmentManager;
    }

    public void clear() {
        for (final Fragment fragment : fragments) {
            fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
        }
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public Fragment getItem(final int position) {
        final Fragment result;
        if (fragmentViewPagerTagManager.has(position)) {
            result = fragmentViewPagerTagManager.get(position);
        } else {
            result = fragments[position];
        }

        if (fragmentAttachedListener != null) {
            fragmentAttachedListener.onFragmentAttached(position, result);
        }

        return result;
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        return titles[position];
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        return fragmentViewPagerTagManager.itemInstantiated(position,
                (Fragment) super.instantiateItem(container, position));
    }

    public void setFragmentAttachedListener(final FragmentAttachedListener fragmentAttachedListener) {
        this.fragmentAttachedListener = fragmentAttachedListener;
    }

    public void setFragments(final Fragment[] fragments, final CharSequence[] titles) {
        if (fragments.length != titles.length) {
            throw new IllegalArgumentException("The fragments and titles arrays must have the same length");
        }

        this.fragments = fragments;
        this.titles = titles;
    }

    public void setFragments(final SmartFragmentPagerPages pages) {
        setFragments(pages.getFragments(), pages.getTabTitles());
    }

    public static void onEnterPage(final Fragment fragment) {
        if (fragment instanceof SmartFragmentPagerAdapter.PagingFragment) {
            ((PagingFragment) fragment).onEnterPage();
        }
    }

    public static void onLeavePage(final Fragment fragment) {
        if (fragment instanceof PagingFragment) {
            ((PagingFragment) fragment).onLeavePage();
        }
    }

    public static void onScrollToTop(final Fragment fragment) {
        if (fragment instanceof PagingFragment) {
            ((PagingFragment) fragment).scrollToTop();
        }
    }

    public interface FragmentAttachedListener {
        void onFragmentAttached(int position, Fragment fragment);
    }

    public interface PagingFragment {

        void onEnterPage();

        void onLeavePage();

        void scrollToTop();
    }
}