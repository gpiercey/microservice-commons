package com.piercey.commons.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Http500ExceptionTest {
    private final Throwable ex = new Exception();

    @Test
    public void TestHttp500Exception1() {
        try {
            throw new Http500Exception();
        } catch (HttpException e) {
            assertTrue(e instanceof Http500Exception);
            assertTrue(e instanceof Exception);
            assertEquals(500, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Internal Server Error");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
        }
    }

    @Test
    public void TestHttp500Exception2() {
        try {
            throw new Http500Exception(ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http500Exception);
            assertTrue(e instanceof Exception);
            assertEquals(500, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Internal Server Error");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
            assertEquals(e.getCause(), ex);
        }
    }

    @Test
    public void TestHttp500Exception3() {
        try {
            throw new Http500Exception(1234, "zzz");
        } catch (HttpException e) {
            assertTrue(e instanceof Http500Exception);
            assertTrue(e instanceof Exception);
            assertEquals(500, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Internal Server Error");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
        }
    }

    @Test
    public void TestHttp500Exception4() {
        try {
            throw new Http500Exception(1234, "zzz", ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http500Exception);
            assertTrue(e instanceof Exception);
            assertEquals(500, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Internal Server Error");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
            assertEquals(e.getCause(), ex);
        }
    }
}