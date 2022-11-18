package com.piercey.commons.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Http400ExceptionTest {
    private final Throwable ex = new Exception();

    @Test
    public void TestHttp400Exception1() {
        try {
            throw new Http400Exception();
        } catch (HttpException e) {
            assertTrue(e instanceof Http400Exception);
            assertTrue(e instanceof Exception);
            assertEquals(400, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Bad Request");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
        }
    }

    @Test
    public void TestHttp400Exception2() {
        try {
            throw new Http400Exception(ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http400Exception);
            assertTrue(e instanceof Exception);
            assertEquals(400, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Bad Request");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
            assertEquals(e.getCause(), ex);
        }
    }

    @Test
    public void TestHttp400Exception3() {
        try {
            throw new Http400Exception(1234, "zzz");
        } catch (HttpException e) {
            assertTrue(e instanceof Http400Exception);
            assertTrue(e instanceof Exception);
            assertEquals(400, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Bad Request");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
        }
    }

    @Test
    public void TestHttp400Exception4() {
        try {
            throw new Http400Exception(1234, "zzz", ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http400Exception);
            assertTrue(e instanceof Exception);
            assertEquals(400, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Bad Request");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
            assertEquals(e.getCause(), ex);
        }
    }
}