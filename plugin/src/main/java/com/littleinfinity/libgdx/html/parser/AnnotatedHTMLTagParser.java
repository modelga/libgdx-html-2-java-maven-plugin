package com.littleinfinity.libgdx.html.parser;

import org.jsoup.nodes.Element;

import static com.google.common.collect.Iterables.contains;
import static com.littleinfinity.libgdx.html.util.StringFunctions.stringsToLower;

public abstract class AnnotatedHTMLTagParser<T> implements HTMLTagParser<T> {

    public AnnotatedHTMLTagParser() {
        assert this.getClass().isAnnotationPresent(ParsableTags.class);
    }

    @Override
    public final boolean isAbleToParse(Element tagName) {
        ParsableTags annotation = this.getClass().getAnnotation(ParsableTags.class);
        Iterable<String> lowerCasedTags = stringsToLower(annotation.tags());
        return contains(lowerCasedTags, tagName.tagName().toLowerCase());
    }
}
