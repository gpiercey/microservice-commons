package com.piercey.commons.exceptions;

public class Http401Exception extends HttpException {
    private final static int code = 401;
    private final static String message = "Unauthorized";

    public Http401Exception() {
        super(code, message);
    }

    public Http401Exception(final Throwable e) {
        super(code, message, e);
    }

    public Http401Exception(final int customCode, final String customMessage) {
        super(code, message, customCode, customMessage);
    }

    public Http401Exception(final int customCode, final String customMessage, final Throwable e) {
        super(code, message, customCode, customMessage, e);
    }
}