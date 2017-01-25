package com.michaelfotiadis.moviedb.ui.components.people;

import android.text.TextUtils;

import com.michaelfotiadis.moviedb.common.models.people.KnownFor;
import com.michaelfotiadis.moviedb.common.models.people.Person;
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
public class PeopleSearcher implements DataFilter<Person> {
    private final List<Person> mAllItems;
    private EmptyQueryBehaviour mBehaviour = EmptyQueryBehaviour.SHOW_ALL;

    public PeopleSearcher(final List<Person> allItems) {
        mAllItems = Collections.unmodifiableList(allItems);
    }

    @Override
    public void filter(final String query, final FilterFinishedCallback<Person> callback) {
        final List<Person> result = new ArrayList<>();
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
            for (final Person movie : mAllItems) {
                if (matches(query, movie)) {
                    result.add(movie);
                }
            }
        }

        Collections.sort(result, new PersonComparator());
        AppLog.d("Filtering data for '" + query + "', result count: " + result.size());
        callback.onSearchFinished(Collections.unmodifiableList(result));
    }

    @Override
    public void setEmptyQueryBehaviour(final EmptyQueryBehaviour behaviour) {
        mBehaviour = behaviour;
    }

    private static boolean matches(final String query, final Person person) {
        if (person.getName() == null) {
            return false;
        }

        final boolean hasName = AppTextUtils.containsIgnoreCase(person.getName(), query);

        if (hasName) {
            return true;
        }

        if (person.getKnownFor() != null && !person.getKnownFor().isEmpty()) {
            for (final KnownFor knownFor : person.getKnownFor()) {
                final String title = knownFor.getTitle();
                if (!TextUtils.isEmpty(title)) {
                    if (AppTextUtils.containsIgnoreCase(title, query)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(final Person lhs, final Person rhs) {
            return lhs.getName().compareToIgnoreCase(rhs.getName());
        }
    }
}
