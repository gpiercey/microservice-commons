package com.piercey.commons.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Http405ExceptionTest {
    private final Throwable ex = new Exception();

    @Test
    public void TestHttp405Exception1() {
        try {
            throw new Http405Exception();
        } catch (HttpException e) {
            assertTrue(e instanceof Http405Exception);
            assertTrue(e instanceof Exception);
            assertEquals(405, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Method Not Allowed");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
        }
    }

    @Test
    public void TestHttp405Exception2() {
        try {
            throw new Http405Exception(ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http405Exception);
            assertTrue(e instanceof Exception);
            assertEquals(405, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Method Not Allowed");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
            assertEquals(e.getCause(), ex);
        }
    }

    @Test
    public void TestHttp405Exception3() {
        try {
            throw new Http405Exception(1234, "zzz");
        } catch (HttpException e) {
            assertTrue(e instanceof Http405Exception);
            assertTrue(e instanceof Exception);
            assertEquals(405, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Method Not Allowed");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
        }
    }

    @Test
    public void TestHttp405Exception4() {
        try {
            throw new Http405Exception(1234, "zzz", ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http405Exception);
            assertTrue(e instanceof Exception);
            assertEquals(405, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Method Not Allowed");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
            assertEquals(e.getCause(), ex);
        }
    }
}