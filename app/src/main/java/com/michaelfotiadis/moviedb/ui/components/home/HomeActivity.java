package com.michaelfotiadis.moviedb.ui.components.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;
import com.michaelfotiadis.moviedb.R;
import com.michaelfotiadis.moviedb.ui.components.movie.MovieFeedFragment;
import com.michaelfotiadis.moviedb.ui.components.people.PeopleFeedFragment;
import com.michaelfotiadis.moviedb.ui.components.tv.TvSeriesFeedFragment;
import com.michaelfotiadis.moviedb.ui.core.common.activity.BaseActivity;
import com.michaelfotiadis.moviedb.ui.core.common.fragment.Searchable;
import com.michaelfotiadis.moviedb.ui.core.common.viewpager.SmartFragmentPagerAdapter;
import com.michaelfotiadis.moviedb.ui.core.common.viewpager.SmartFragmentPagerBinder;
import com.michaelfotiadis.moviedb.ui.core.common.viewpager.SmartFragmentPagerPage;
import com.michaelfotiadis.moviedb.ui.core.common.viewpager.SmartFragmentPagerPages;
import com.michaelfotiadis.moviedb.utils.AppLog;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;

public class HomeActivity extends BaseActivity {

    private static final int LAYOUT_ID = R.layout.activity_default_view_pager;

    private static final int OFF_PAGE_LIMIT = 2;
    @Bind(R.id.view_pager)
    protected ViewPager mPager;
    @Bind(R.id.tabs)
    protected TabLayout mTabLayout;
    private SmartFragmentPagerAdapter mAdapter;
    private SearchView mSearchView;
    private MenuItem mSearchMenu;

    public static Intent getInstance(final Context context) {
        return new Intent(context, HomeActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(LAYOUT_ID);


        ButterKnife.bind(this);

        final SmartFragmentPagerPages pages = getPages();
        mAdapter = new SmartFragmentPagerAdapter(getSupportFragmentManager());
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

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        mSearchMenu = menu.findItem(R.id.action_search);

        // Initialise the searchview
        mSearchView = new SearchView(this.getSupportActionBar().getThemedContext());
        MenuItemCompat.setShowAsAction(mSearchMenu, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(mSearchMenu, mSearchView);
        mSearchView.setQueryHint(getString(R.string.hint_search));
        // Add a OnQueryTextListener


        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(final String query) {
                submitQuery(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(final String searchText) {
                submitQuery(searchText);
                return false;
            }
        });

        // Add an expand listener
        MenuItemCompat.setOnActionExpandListener(mSearchMenu, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(final MenuItem item) {
                return true; // Return true to expand action view
            }

            @Override
            public boolean onMenuItemActionCollapse(final MenuItem item) {
                return true; // Return true to collapse action view
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void submitQuery(final String query) {
        if (getCurrentFragment() instanceof Searchable) {
            AppLog.d("Submitting query to fragment: " + query);
            ((Searchable) getCurrentFragment()).setFilter(query);
        }
    }

    private Fragment getCurrentFragment() {
        return mAdapter.getItem(mPager.getCurrentItem());
    }
}
