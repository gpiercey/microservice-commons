package com.piercey.commons.exceptions;

public class Http504Exception extends HttpException {
    private final static int code = 504;
    private final static String message = "Gateway Timeout";

    public Http504Exception() {
        super(code, message);
    }

    public Http504Exception(final Throwable e) {
        super(code, message, e);
    }

    public Http504Exception(final int customCode, final String customMessage) {
        super(code, message, customCode, customMessage);
    }

    public Http504Exception(final int customCode, final String customMessage, final Throwable e) {
        super(code, message, customCode, customMessage, e);
    }
}