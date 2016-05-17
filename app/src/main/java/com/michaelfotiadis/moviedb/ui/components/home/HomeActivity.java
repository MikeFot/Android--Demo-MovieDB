package com.michaelfotiadis.moviedb.ui.components.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.crashlytics.android.Crashlytics;
import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.ui.components.movie.MovieFeedFragment;
import com.michaelfotiadis.moviedb.ui.components.people.PeopleFeedFragment;
import com.michaelfotiadis.moviedb.ui.components.tv.TvSeriesFeedFragment;
import com.michaelfotiadis.moviedb.ui.core.common.activity.BaseActivity;
import com.michaelfotiadis.moviedb.ui.core.common.viewpager.SmartFragmentPagerAdapter;
import com.michaelfotiadis.moviedb.ui.core.common.viewpager.SmartFragmentPagerBinder;
import com.michaelfotiadis.moviedb.ui.core.common.viewpager.SmartFragmentPagerPage;
import com.michaelfotiadis.moviedb.ui.core.common.viewpager.SmartFragmentPagerPages;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;

public class HomeActivity extends BaseActivity {

    private static final int LAYOUT_ID = R.layout.activity_default_view_pager;

    private static final int OFF_PAGE_LIMIT = 2;

    public static Intent getInstance(final Context context) {
        return new Intent(context, HomeActivity.class);
    }


    @Bind(R.id.view_pager)
    protected ViewPager mPager;
    @Bind(R.id.tabs)
    protected TabLayout mTabLayout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(LAYOUT_ID);


        ButterKnife.bind(this);

        final SmartFragmentPagerPages pages = getPages();
        final SmartFragmentPagerAdapter mAdapter = new SmartFragmentPagerAdapter(getSupportFragmentManager());
        mAdapter.setFragments(pages);
        mPager.setAdapter(mAdapter);
        mPager.setOffscreenPageLimit(OFF_PAGE_LIMIT);

        final SmartFragmentPagerBinder binder =
                new SmartFragmentPagerBinder(mPager, pages, mTabLayout,
                        new SmartFragmentPagerBinder.NavBarTitleNeedsChangingListener() {
                            @Override
                            public void onNavBarTitleNeedsChanging(final CharSequence newTitle) {
                                setTitle(newTitle);
                            }
                        });

        binder.bind();

        final int startingPage = 0;
        mPager.setCurrentItem(startingPage);
        //noinspection ConstantConditions
        if (startingPage == 0) {
            // The onPageSelectedEvent of OnPageChangeListener is not called for the first page
            binder.onPageSelected(0);
        }
    }

    private SmartFragmentPagerPages getPages() {
        final SmartFragmentPagerPages pages = new SmartFragmentPagerPages();

        pages.add(new SmartFragmentPagerPage.Builder()
                .setNavBarTitle(getString(R.string.tab_title_movie_feed))
                .setTabIcon(R.drawable.ic_movie)
                .setFragment(MovieFeedFragment.newInstance())
                .build());

        pages.add(new SmartFragmentPagerPage.Builder()
                .setNavBarTitle(getString(R.string.tab_title_people))
                .setTabIcon(R.drawable.ic_people)
                .setFragment(PeopleFeedFragment.newInstance())
                .build());

        pages.add(new SmartFragmentPagerPage.Builder()
                .setNavBarTitle(getString(R.string.tab_title_tv_series))
                .setTabIcon(R.drawable.ic_tv)
                .setFragment(TvSeriesFeedFragment.newInstance())
                .build());

        return pages;
    }

}
