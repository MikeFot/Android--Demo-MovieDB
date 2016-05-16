package com.michaelfotiadis.moviedb.ui.core.common.viewpager;

import android.support.v4.app.Fragment;

public final class SmartFragmentPagerPage {
    private final Fragment fragment;
    private final CharSequence navBarTitle;
    private final int tabIcon;
    private final CharSequence tabTitle;

    private SmartFragmentPagerPage(final Builder builder) {
        this.fragment = builder.fragment;
        this.tabIcon = builder.iconResId;
        this.tabTitle = builder.tabTitle;
        this.navBarTitle = builder.navBarTitle;

        if (fragment == null) {
            throw new IllegalStateException("Fragment cannot be null!");
        }
    }

    public Fragment getFragment() {
        return fragment;
    }

    public CharSequence getNavBarTitle() {
        return navBarTitle;
    }

    public int getTabIcon() {
        return tabIcon;
    }

    public CharSequence getTabTitle() {
        return tabTitle;
    }

    public static final class Builder {
        private Fragment fragment;
        private int iconResId;
        private CharSequence navBarTitle;
        private CharSequence tabTitle;

        public SmartFragmentPagerPage build() {
            return new SmartFragmentPagerPage(this);
        }

        public Builder setFragment(final Fragment fragment) {
            this.fragment = fragment;
            return this;
        }

        public Builder setNavBarTitle(final CharSequence navBarTitle) {
            this.navBarTitle = navBarTitle;
            return this;
        }

        public Builder setTabIcon(final int iconResId) {
            this.iconResId = iconResId;
            return this;
        }

        public Builder setTabTitle(final CharSequence tabTitle) {
            this.tabTitle = tabTitle;
            return this;
        }
    }
}
