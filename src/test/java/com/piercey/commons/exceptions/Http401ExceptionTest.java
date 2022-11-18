package com.piercey.commons.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Http401ExceptionTest {
    private final Throwable ex = new Exception();

    @Test
    public void TestHttp401Exception1() {
        try {
            throw new Http401Exception();
        } catch (HttpException e) {
            assertTrue(e instanceof Http401Exception);
            assertTrue(e instanceof Exception);
            assertEquals(401, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Unauthorized");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
        }
    }

    @Test
    public void TestHttp401Exception2() {
        try {
            throw new Http401Exception(ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http401Exception);
            assertTrue(e instanceof Exception);
            assertEquals(401, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Unauthorized");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
            assertEquals(e.getCause(), ex);
        }
    }

    @Test
    public void TestHttp401Exception3() {
        try {
            throw new Http401Exception(1234, "zzz");
        } catch (HttpException e) {
            assertTrue(e instanceof Http401Exception);
            assertTrue(e instanceof Exception);
            assertEquals(401, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Unauthorized");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
        }
    }

    @Test
    public void TestHttp401Exception4() {
        try {
            throw new Http401Exception(1234, "zzz", ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http401Exception);
            assertTrue(e instanceof Exception);
            assertEquals(401, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Unauthorized");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
            assertEquals(e.getCause(), ex);
        }
    }
}