package com.piercey.commons;

import org.slf4j.Logger;

public class ExecutionTimer implements AutoCloseable {
    private final Logger logger;
    private final String message;
    private final long start = System.nanoTime();

    public ExecutionTimer(Logger logger, String message) {
        this.logger = logger;
        this.message = message;
    }

    @Override
    public void close() {
        final long us = (System.nanoTime() - start) / 1000;
        final long ms = us / 1000;
        final String timing = ms > 0
                ? String.format(" %dms", ms)
                : String.format(" %dus", us);
        logger.info(message + timing);
    }
}