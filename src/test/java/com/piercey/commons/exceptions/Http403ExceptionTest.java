package com.piercey.commons.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Http403ExceptionTest {
    private final Throwable ex = new Exception();

    @Test
    public void TestHttp403Exception1() {
        try {
            throw new Http403Exception();
        } catch (HttpException e) {
            assertTrue(e instanceof Http403Exception);
            assertTrue(e instanceof Exception);
            assertEquals(403, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Forbidden");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
        }
    }

    @Test
    public void TestHttp403Exception2() {
        try {
            throw new Http403Exception(ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http403Exception);
            assertTrue(e instanceof Exception);
            assertEquals(403, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Forbidden");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
            assertEquals(e.getCause(), ex);
        }
    }

    @Test
    public void TestHttp403Exception3() {
        try {
            throw new Http403Exception(1234, "zzz");
        } catch (HttpException e) {
            assertTrue(e instanceof Http403Exception);
            assertTrue(e instanceof Exception);
            assertEquals(403, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Forbidden");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
        }
    }

    @Test
    public void TestHttp403Exception4() {
        try {
            throw new Http403Exception(1234, "zzz", ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http403Exception);
            assertTrue(e instanceof Exception);
            assertEquals(403, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Forbidden");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
            assertEquals(e.getCause(), ex);
        }
    }
}