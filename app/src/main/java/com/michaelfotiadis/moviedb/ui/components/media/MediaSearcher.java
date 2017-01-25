package com.michaelfotiadis.moviedb.ui.components.media;

import android.text.TextUtils;

import com.michaelfotiadis.moviedb.data.model.UiMedia;
import com.michaelfotiadis.moviedb.ui.core.common.search.DataFilter;
import com.michaelfotiadis.moviedb.ui.core.common.search.FilterFinishedCallback;
import com.michaelfotiadis.moviedb.utils.AppLog;
import com.michaelfotiadis.moviedb.utils.text.AppTextUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class MediaSearcher implements DataFilter<UiMedia> {
    private final List<UiMedia> mAllItems;
    private EmptyQueryBehaviour mBehaviour = EmptyQueryBehaviour.SHOW_ALL;

    public MediaSearcher(final List<UiMedia> allItems) {
        mAllItems = Collections.unmodifiableList(allItems);
    }

    @Override
    public void filter(final String query, final FilterFinishedCallback<UiMedia> callback) {
        final List<UiMedia> result = new ArrayList<>();
        AppLog.d("Searcher is looking for " + query);
        // TODO: Do the search in a BG thread

        if (TextUtils.isEmpty(query)) {
            switch (mBehaviour) {
                case SHOW_ALL:
                    result.addAll(mAllItems);
                    break;
                case SHOW_NONE:
                    break;
                default:
                    throw new IllegalStateException("Unknown EmptyQueryBehaviour: " + mBehaviour);
            }
        } else {
            for (final UiMedia movie : mAllItems) {
                if (matches(query, movie)) {
                    result.add(movie);
                }
            }
        }

        Collections.sort(result, new MediaComparator());
        AppLog.d("Filtering data for '" + query + "', result count: " + result.size());
        callback.onSearchFinished(Collections.unmodifiableList(result));
    }

    @Override
    public void setEmptyQueryBehaviour(final EmptyQueryBehaviour behaviour) {
        mBehaviour = behaviour;
    }

    private static boolean matches(final String query, final UiMedia movie) {
        if (movie.getTitle() == null) {
            return false;
        }


        final boolean hasYear = AppTextUtils.containsIgnoreCase(movie.getYear(), query);

        if (hasYear) {
            return true;
        }

        final boolean hasGenre = AppTextUtils.containsIgnoreCase(movie.getGenres(), query);

        if (hasGenre) {
            return true;
        }

        final boolean hasTitle = AppTextUtils.containsIgnoreCase(movie.getTitle(), query);

        if (hasTitle) {
            return true;
        }

        return false;
    }

    private static class MediaComparator implements Comparator<UiMedia> {
        @Override
        public int compare(final UiMedia lhs, final UiMedia rhs) {
            return lhs.getTitle().compareToIgnoreCase(rhs.getTitle());
        }
    }
}
