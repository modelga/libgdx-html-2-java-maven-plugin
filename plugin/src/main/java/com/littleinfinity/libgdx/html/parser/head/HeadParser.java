package com.littleinfinity.libgdx.html.parser.head;

import com.littleinfinity.libgdx.html.parser.AnnotatedHTMLTagParser;
import com.littleinfinity.libgdx.html.parser.ParsableTags;
import org.jsoup.nodes.Element;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

// TODO Return type to be discussed
@ParsableTags(tags = {"head"})
public class HeadParser extends AnnotatedHTMLTagParser<Object> {

    @Override
    public Object parse(Element element) {
        throw new NotImplementedException();
    }
}
