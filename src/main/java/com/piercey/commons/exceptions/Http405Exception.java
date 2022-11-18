package com.piercey.commons.exceptions;

public class Http405Exception extends HttpException {
    private final static int code = 405;
    private final static String message = "Method Not Allowed";

    public Http405Exception() {
        super(code, message);
    }

    public Http405Exception(final Throwable e) {
        super(code, message, e);
    }

    public Http405Exception(final int customCode, final String customMessage) {
        super(code, message, customCode, customMessage);
    }

    public Http405Exception(final int customCode, final String customMessage, final Throwable e) {
        super(code, message, customCode, customMessage, e);
    }
}