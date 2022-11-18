package com.piercey.commons.exceptions;

public class Http501Exception extends HttpException {
    private final static int code = 501;
    private final static String message = "Not Implemented";

    public Http501Exception() {
        super(code, message);
    }

    public Http501Exception(final Throwable e) {
        super(code, message, e);
    }

    public Http501Exception(final int customCode, final String customMessage) {
        super(code, message, customCode, customMessage);
    }

    public Http501Exception(final int customCode, final String customMessage, final Throwable e) {
        super(code, message, customCode, customMessage, e);
    }
}