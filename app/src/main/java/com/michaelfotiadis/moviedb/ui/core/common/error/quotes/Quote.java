package com.michaelfotiadis.moviedb.ui.core.common.error.quotes;

/**
 *
 */
public class Quote {

    private final CharSequence author;
    private final CharSequence quote;

    public Quote(final CharSequence quote, final CharSequence author) {
        this.quote = quote;
        this.author = author;
    }

    public CharSequence getAuthor() {
        return author;
    }

    public CharSequence getQuote() {
        return quote;
    }
}
