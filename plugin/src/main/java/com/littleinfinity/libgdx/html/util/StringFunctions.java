package com.littleinfinity.libgdx.html.util;

import static com.google.common.collect.Iterables.transform;
import static java.util.Arrays.asList;

public final class StringFunctions {

    public static Iterable<String> stringsToLower(String[] strings) {
        return transform(asList(strings), (value) -> value.toLowerCase());
    }
}
