package com.piercey.commons.exceptions;

public class Http502Exception extends HttpException {
    private final static int code = 502;
    private final static String message = "Bad Gateway";

    public Http502Exception() {
        super(code, message);
    }

    public Http502Exception(final Throwable e) {
        super(code, message, e);
    }

    public Http502Exception(final int customCode, final String customMessage) {
        super(code, message, customCode, customMessage);
    }

    public Http502Exception(final int customCode, final String customMessage, final Throwable e) {
        super(code, message, customCode, customMessage, e);
    }
}