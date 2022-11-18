package com.piercey.commons.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Http503ExceptionTest {
    private final Throwable ex = new Exception();

    @Test
    public void TestHttp503Exception1() {
        try {
            throw new Http503Exception();
        } catch (HttpException e) {
            assertTrue(e instanceof Http503Exception);
            assertTrue(e instanceof Exception);
            assertEquals(503, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Service Unavailable");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
        }
    }

    @Test
    public void TestHttp503Exception2() {
        try {
            throw new Http503Exception(ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http503Exception);
            assertTrue(e instanceof Exception);
            assertEquals(503, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Service Unavailable");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
            assertEquals(e.getCause(), ex);
        }
    }

    @Test
    public void TestHttp503Exception3() {
        try {
            throw new Http503Exception(1234, "zzz");
        } catch (HttpException e) {
            assertTrue(e instanceof Http503Exception);
            assertTrue(e instanceof Exception);
            assertEquals(503, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Service Unavailable");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
        }
    }

    @Test
    public void TestHttp503Exception4() {
        try {
            throw new Http503Exception(1234, "zzz", ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http503Exception);
            assertTrue(e instanceof Exception);
            assertEquals(503, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Service Unavailable");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
            assertEquals(e.getCause(), ex);
        }
    }
}