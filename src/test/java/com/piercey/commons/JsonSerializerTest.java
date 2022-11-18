package com.piercey.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsonSerializerTest {
    private final JsonSerializer serializer = new JsonSerializer();

    @Test
    public void testToJson1() {
        final ObjectNode o = JsonNodeFactory.instance.objectNode()
                .put("aaa", "yyy")
                .put("bbb", "zzz");

        String json = serializer.toJson(o);
        assertTrue(json.contains("\"aaa\":\"yyy\""));
        assertTrue(json.contains("\"bbb\":\"zzz\""));

        json = serializer.toJson(null);
        assertTrue(json.contains("{}"));
    }

    @Test
    public void testToJson2() {
        final ObjectNode o = JsonNodeFactory.instance.objectNode()
                .put("aaa", "yyy")
                .put("bbb", "zzz");

        String json = serializer.toJson(o, true);
        assertTrue(json.contains("\"aaa\" : \"yyy\",\n"));
        assertTrue(json.contains("\"bbb\" : \"zzz\"\n"));

        json = serializer.toJson(o, false);
        assertTrue(json.contains("\"aaa\":\"yyy\""));
        assertTrue(json.contains("\"bbb\":\"zzz\""));
    }

    @Test
    public void testSecondConstructor() {
        final ObjectMapper mapper = new ObjectMapper();
        final JsonSerializer zzz = new JsonSerializer(mapper);

        final ObjectNode o = JsonNodeFactory.instance.objectNode()
                .put("aaa", "yyy")
                .put("bbb", "zzz");

        String json = zzz.toJson(o, true);
        assertTrue(json.contains("\"aaa\" : \"yyy\",\n"));
        assertTrue(json.contains("\"bbb\" : \"zzz\"\n"));

        json = zzz.toJson(o, false);
        assertTrue(json.contains("\"aaa\":\"yyy\""));
        assertTrue(json.contains("\"bbb\":\"zzz\""));
    }

    @Test
    public void testToObject() throws Exception {
        final TestObject o = new TestObject();
        o.setAaa("yyy");
        o.setBbb("zzz");

        final String json = serializer.toJson(o, true);
        assertTrue(json.contains("\"aaa\" : \"yyy\",\n"));
        assertTrue(json.contains("\"bbb\" : \"zzz\"\n"));

        final TestObject newO = (TestObject) serializer.toObject(json, TestObject.class);
        assertEquals(newO.getAaa(), "yyy");
        assertEquals(newO.getBbb(), "zzz");
    }
}