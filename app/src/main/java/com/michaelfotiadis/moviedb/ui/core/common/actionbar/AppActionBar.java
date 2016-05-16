package com.michaelfotiadis.moviedb.ui.core.common.actionbar;

import android.view.View;

/**
 *
 */
public interface AppActionBar {

    View findViewById(final int id);

    void goTransparent();

    void hide();

    void setTitle(final CharSequence charSequence);

    void setTitle(final CharSequence charSequence, final int[] color);

    void setTitleAlpha(final float alpha);

    void show();
}
