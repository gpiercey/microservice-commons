package com.piercey.commons.exceptions;

public class Http503Exception extends HttpException {
    private final static int code = 503;
    private final static String message = "Service Unavailable";

    public Http503Exception() {
        super(code, message);
    }

    public Http503Exception(final Throwable e) {
        super(code, message, e);
    }

    public Http503Exception(final int customCode, final String customMessage) {
        super(code, message, customCode, customMessage);
    }

    public Http503Exception(final int customCode, final String customMessage, final Throwable e) {
        super(code, message, customCode, customMessage, e);
    }
}