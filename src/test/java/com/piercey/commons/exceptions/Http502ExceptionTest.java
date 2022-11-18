package com.piercey.commons.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Http502ExceptionTest {
    private final Throwable ex = new Exception();

    @Test
    public void TestHttp502Exception1() {
        try {
            throw new Http502Exception();
        } catch (HttpException e) {
            assertTrue(e instanceof Http502Exception);
            assertTrue(e instanceof Exception);
            assertEquals(502, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Bad Gateway");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
        }
    }

    @Test
    public void TestHttp502Exception2() {
        try {
            throw new Http502Exception(ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http502Exception);
            assertTrue(e instanceof Exception);
            assertEquals(502, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Bad Gateway");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
            assertEquals(e.getCause(), ex);
        }
    }

    @Test
    public void TestHttp502Exception3() {
        try {
            throw new Http502Exception(1234, "zzz");
        } catch (HttpException e) {
            assertTrue(e instanceof Http502Exception);
            assertTrue(e instanceof Exception);
            assertEquals(502, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Bad Gateway");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
        }
    }

    @Test
    public void TestHttp502Exception4() {
        try {
            throw new Http502Exception(1234, "zzz", ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http502Exception);
            assertTrue(e instanceof Exception);
            assertEquals(502, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Bad Gateway");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
            assertEquals(e.getCause(), ex);
        }
    }
}