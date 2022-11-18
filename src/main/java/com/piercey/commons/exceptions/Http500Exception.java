package com.piercey.commons.exceptions;

public class Http500Exception extends HttpException {
    private final static int code = 500;
    private final static String message = "Internal Server Error";

    public Http500Exception() {
        super(code, message);
    }

    public Http500Exception(final Throwable e) {
        super(code, message, e);
    }

    public Http500Exception(final int customCode, final String customMessage) {
        super(code, message, customCode, customMessage);
    }

    public Http500Exception(final int customCode, final String customMessage, final Throwable e) {
        super(code, message, customCode, customMessage, e);
    }
}