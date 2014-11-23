package com.littleinfinity.libgdx.html.parser.head;

import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.parser.AnnotatedHTMLTagParser;
import com.littleinfinity.libgdx.html.parser.ParsableTags;
import org.jsoup.nodes.Element;

// TODO Return type to be discussed
@Singleton
@ParsableTags(tags = {"const"})
public class ConstParser extends AnnotatedHTMLTagParser<Object> {

    @Override
    public Object parse(Element element) {
        return null;
    }
}
