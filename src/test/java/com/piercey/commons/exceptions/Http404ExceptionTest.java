package com.piercey.commons.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Http404ExceptionTest {
    private final Throwable ex = new Exception();

    @Test
    public void TestHttp404Exception1() {
        try {
            throw new Http404Exception();
        } catch (HttpException e) {
            assertTrue(e instanceof Http404Exception);
            assertTrue(e instanceof Exception);
            assertEquals(404, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Not Found");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
        }
    }

    @Test
    public void TestHttp404Exception2() {
        try {
            throw new Http404Exception(ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http404Exception);
            assertTrue(e instanceof Exception);
            assertEquals(404, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Not Found");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
            assertEquals(e.getCause(), ex);
        }
    }

    @Test
    public void TestHttp404Exception3() {
        try {
            throw new Http404Exception(1234, "zzz");
        } catch (HttpException e) {
            assertTrue(e instanceof Http404Exception);
            assertTrue(e instanceof Exception);
            assertEquals(404, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Not Found");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
        }
    }

    @Test
    public void TestHttp404Exception4() {
        try {
            throw new Http404Exception(1234, "zzz", ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http404Exception);
            assertTrue(e instanceof Exception);
            assertEquals(404, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Not Found");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
            assertEquals(e.getCause(), ex);
        }
    }
}