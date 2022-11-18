package com.piercey.commons.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Http504ExceptionTest {
    private final Throwable ex = new Exception();

    @Test
    public void TestHttp504Exception1() {
        try {
            throw new Http504Exception();
        } catch (HttpException e) {
            assertTrue(e instanceof Http504Exception);
            assertTrue(e instanceof Exception);
            assertEquals(504, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Gateway Timeout");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
        }
    }

    @Test
    public void TestHttp504Exception2() {
        try {
            throw new Http504Exception(ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http504Exception);
            assertTrue(e instanceof Exception);
            assertEquals(504, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Gateway Timeout");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
            assertEquals(e.getCause(), ex);
        }
    }

    @Test
    public void TestHttp504Exception3() {
        try {
            throw new Http504Exception(1234, "zzz");
        } catch (HttpException e) {
            assertTrue(e instanceof Http504Exception);
            assertTrue(e instanceof Exception);
            assertEquals(504, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Gateway Timeout");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
        }
    }

    @Test
    public void TestHttp504Exception4() {
        try {
            throw new Http504Exception(1234, "zzz", ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http504Exception);
            assertTrue(e instanceof Exception);
            assertEquals(504, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Gateway Timeout");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
            assertEquals(e.getCause(), ex);
        }
    }
}