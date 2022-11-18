package com.piercey.commons.exceptions;

import org.junit.Test;

import static org.junit.Assert.*;

public class Http501ExceptionTest {
    private final Throwable ex = new Exception();

    @Test
    public void TestHttp501Exception1() {
        try {
            throw new Http501Exception();
        } catch (HttpException e) {
            assertTrue(e instanceof Http501Exception);
            assertTrue(e instanceof Exception);
            assertEquals(501, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Not Implemented");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
        }
    }

    @Test
    public void TestHttp501Exception2() {
        try {
            throw new Http501Exception(ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http501Exception);
            assertTrue(e instanceof Exception);
            assertEquals(501, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Not Implemented");
            assertFalse(e.hasCustomData());
            assertEquals(e.getCustomStatus(), Integer.MIN_VALUE);
            assertNull(e.getCustomMessage());
            assertEquals(e.getCause(), ex);
        }
    }

    @Test
    public void TestHttp501Exception3() {
        try {
            throw new Http501Exception(1234, "zzz");
        } catch (HttpException e) {
            assertTrue(e instanceof Http501Exception);
            assertTrue(e instanceof Exception);
            assertEquals(501, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Not Implemented");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
        }
    }

    @Test
    public void TestHttp501Exception4() {
        try {
            throw new Http501Exception(1234, "zzz", ex);
        } catch (HttpException e) {
            assertTrue(e instanceof Http501Exception);
            assertTrue(e instanceof Exception);
            assertEquals(501, e.getHttpStatus());
            assertSame(e.getHttpMessage(), "Not Implemented");
            assertTrue(e.hasCustomData());
            assertEquals(e.getCustomStatus(), 1234);
            assertEquals(e.getCustomMessage(), "zzz");
            assertEquals(e.getCause(), ex);
        }
    }
}