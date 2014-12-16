package com.littleinfinity.libgdx.html.processing.constant;

import com.littleinfinity.libgdx.html.processing.common.joint.TypeResolver;

import java.util.Collection;

import static java.util.Arrays.asList;

public enum EmbeddedType implements TypeResolver {
    INT("int", "integer") {
        @Override
        boolean isCorrect(String value) {
            return checkCorrectness(() -> Integer.parseInt(value));
        }
    }, LONG("long", "bigint") {
        @Override
        boolean isCorrect(String value) {
            return checkCorrectness(() -> Long.parseLong(value));
        }
    }, STRING("string", "text") {
        @Override
        boolean isCorrect(String value) {
            return checkCorrectness(() -> value.toString());
        }
    }, DOUBLE("double") {
        @Override
        boolean isCorrect(String value) {
            return checkCorrectness(() -> Double.parseDouble(value));
        }
    }, FLOAT("float") {
        @Override
        boolean isCorrect(String value) {
            return checkCorrectness(() -> Float.parseFloat(value));
        }
    }, BOOLEAN("bool", "boolean") {
        @Override
        boolean isCorrect(String value) {
            return checkCorrectness(() -> Boolean.parseBoolean(value));
        }
    };

    private final Collection<String> allowedNames;

    private EmbeddedType(String... names) {
        allowedNames = asList(names);
    }

    abstract boolean isCorrect(String value);

    public final EmbeddedType getConverter(String value) {
        for (EmbeddedType converter : EmbeddedType.values()) {
            if (converter.allowedNames.contains(value)) {
                return converter;
            }
        }
        throw new IllegalArgumentException("Type " + value + " is not allowed!");
    }

    boolean checkCorrectness(Runnable r) {
        try {
            r.run();
            return true;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }
}
