package com.michaelfotiadis.moviedb.ui.core.common.viewpager;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewPager;

import com.michaelfotiadis.moviedb.R;

/**
 *
 */
public final class SmartFragmentPagerBinder {
    private static final int TAB_SELECTED_COLOR_ID = R.color.accent;

    private final NavBarTitleNeedsChangingListener callback;
    private final boolean isLollipop;
    private final ViewPager pager;
    private final SmartFragmentPagerPages pages;
    private final TabLayout tabLayout;
    private final ColorFilter tabSelectedColorFilter;

    public SmartFragmentPagerBinder(final ViewPager pager,
                                    final SmartFragmentPagerPages pages,
                                    final TabLayout tabLayout) {
        this(pager, pages, tabLayout, null);
    }

    public SmartFragmentPagerBinder(final ViewPager pager,
                                    final SmartFragmentPagerPages pages,
                                    final TabLayout tabLayout,
                                    final NavBarTitleNeedsChangingListener callback) {
        final int selectedTabColor = ContextCompat.getColor(pager.getContext(), TAB_SELECTED_COLOR_ID);
        this.isLollipop = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
        this.pager = pager;
        this.pages = pages;
        this.tabLayout = tabLayout;
        this.callback = callback;
        this.tabSelectedColorFilter = new PorterDuffColorFilter(selectedTabColor, PorterDuff.Mode.MULTIPLY);
    }

    public void bind() {

        tabLayout.setupWithViewPager(pager);

        final int icons[] = pages.getIcons();

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            final int resId = icons[i];
            if (resId > 0) {
                //noinspection ConstantConditions
                tabLayout.getTabAt(i).setIcon(resId);
            }
        }

        pager.addOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrollStateChanged(final int state) {
                        // NOOP
                    }

                    @Override
                    public void onPageScrolled(final int position,
                                               final float positionOffset,
                                               final int positionOffsetPixels) {
                        // NOOP
                    }

                    @Override
                    public void onPageSelected(final int position) {
                        SmartFragmentPagerBinder.this.onPageSelected(position);
                    }
                }
        );
    }

    public void onPageSelected(final int position) {
        if (callback != null) {
            final CharSequence title = pages.getNavBarTitles()[position];
            callback.onNavBarTitleNeedsChanging(title);
        }

        final Resources resources = pager.getContext().getResources();

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            //noinspection ConstantConditions
            final Drawable drawable = tabLayout.getTabAt(i).getIcon();
            if (drawable != null) {
                if (position == i) {
                    if (isLollipop) {
                        DrawableCompat.setTint(
                                drawable,
                                resources.getColor(TAB_SELECTED_COLOR_ID));
                    } else {
                        drawable.setColorFilter(tabSelectedColorFilter);
                    }

                } else {
                    if (isLollipop) {
                        DrawableCompat.setTintList(
                                drawable,
                                null);
                    } else {
                        drawable.setColorFilter(null);
                    }
                }
            }
        }
    }


    public interface NavBarTitleNeedsChangingListener {
        void onNavBarTitleNeedsChanging(final CharSequence newTitle);
    }
}
