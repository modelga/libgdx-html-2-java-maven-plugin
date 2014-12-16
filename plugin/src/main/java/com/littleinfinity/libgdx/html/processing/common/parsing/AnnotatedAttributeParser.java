package com.littleinfinity.libgdx.html.processing.common.parsing;

import org.jsoup.nodes.Attribute;

import static com.google.common.collect.Iterables.contains;
import static com.littleinfinity.libgdx.html.processing.util.StringFunctions.stringsToLower;

public abstract class AnnotatedAttributeParser<T> implements AttributeParser<T> {

    public AnnotatedAttributeParser() {
        assert this.getClass().isAnnotationPresent(ParsableAttributes.class);
    }

    @Override
    public final boolean isAbleToParse(Attribute attribute) {
        ParsableAttributes annotation = this.getClass().getAnnotation(ParsableAttributes.class);
        Iterable<String> lowerCasedAttributes = stringsToLower(annotation.attributes());
        return contains(lowerCasedAttributes, attribute.getKey().toLowerCase());
    }
}
