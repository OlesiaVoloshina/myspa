package org.example.mixin;

import com.fasterxml.jackson.databind.util.StdConverter;

public class ComponentNameConverter extends StdConverter<String, String> {

    @Override
    public String convert(final String value) {
        if(value != null) {
            return value.replaceAll("[0-9]", "");
        }
        return null;
    }
}
