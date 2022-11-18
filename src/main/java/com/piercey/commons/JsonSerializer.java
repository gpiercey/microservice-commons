package com.piercey.commons;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.google.common.base.Strings;

public class JsonSerializer {
    private final ObjectMapper objectMapper;

    public JsonSerializer() {
        objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    }

    public JsonSerializer(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String toJson(final Object o) {
        return toJson(o, false);
    }

    public String toJson(final Object o, boolean formatted) {
        return formatted
                ? toJsonNode(o).toPrettyString()
                : toJsonNode(o).toString();
    }

    public JsonNode toJsonNode(final Object o) {
        return o != null
                ? objectMapper.valueToTree(o)
                : JsonNodeFactory.instance.objectNode();
    }

    public Object toObject(final String s, Class<?> cls) throws Exception {
        return !Strings.isNullOrEmpty(s)
                ? objectMapper.readValue(s, cls)
                : JsonNodeFactory.instance.objectNode();
    }
}