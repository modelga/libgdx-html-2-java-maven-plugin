package com.littleinfinity.libgdx.html.parser.head;

import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.generator.java.JavaSourceComponent;
import com.littleinfinity.libgdx.html.parser.AnnotatedHTMLTagParser;
import com.littleinfinity.libgdx.html.parser.ParsableTags;
import org.jsoup.nodes.Element;

@Singleton
@ParsableTags(tags = {"const"})
public class ConstParser extends AnnotatedHTMLTagParser<JavaSourceComponent> {

    @Override
    public JavaSourceComponent parse(Element element) {
        return null;
    }
}
