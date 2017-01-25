package com.michaelfotiadis.moviedb.common.exceptions;

public class CoreException extends RuntimeException {
    /**
     * Constructs a new CoreException.
     */
    public CoreException() {
        super();
    }

    /**
     * Constructs a new CoreException.
     *
     * @param message the detail message of this exception
     */
    public CoreException(final String message) {
        super(message);
    }

    /**
     * Constructs a new CoreException.
     *
     * @param format the format string
     * @param args   the list of arguments passed to the formatter.
     */
    public CoreException(final String format, final Object... args) {
        this(String.format(format, args));
    }

    /**
     * Constructs a new CoreException.
     *
     * @param message   the detail message of this exception
     * @param throwable the cause of this exception
     */
    public CoreException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Constructs a new CoreException.
     *
     * @param throwable the cause of this exception
     */
    public CoreException(final Throwable throwable) {
        super(throwable);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}