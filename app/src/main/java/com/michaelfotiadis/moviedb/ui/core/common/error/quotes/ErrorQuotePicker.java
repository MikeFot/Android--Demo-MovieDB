package com.michaelfotiadis.moviedb.ui.core.common.error.quotes;

import android.content.Context;

import com.michaelfotiadis.moviedb.R;

import java.util.Random;

/**
 *
 */
public final class ErrorQuotePicker implements QuotePicker {

    private final CharSequence[] authors;
    private final CharSequence[] quotes;

    public ErrorQuotePicker(final Context context) {
        quotes = context.getResources().getStringArray(R.array.error_quote_array);
        authors = context.getResources().getStringArray(R.array.error_quote_author_array);
    }


    @Override
    public Quote getQuote() {
        final int idx = new Random().nextInt(quotes.length);
        return new Quote(quotes[idx], authors[idx]);
    }

}
