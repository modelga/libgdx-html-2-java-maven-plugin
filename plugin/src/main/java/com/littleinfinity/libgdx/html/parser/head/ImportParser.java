package com.littleinfinity.libgdx.html.parser.head;

import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.generator.java.ImportComponent;
import com.littleinfinity.libgdx.html.parser.AnnotatedHTMLTagParser;
import com.littleinfinity.libgdx.html.parser.ParsableTags;
import org.jsoup.nodes.Element;

// TODO Return type to be discussed
@Singleton
@ParsableTags(tags = {"import"})
public class ImportParser extends AnnotatedHTMLTagParser<Object> {

    @Override
    public ImportComponent parse(Element element) {
        ImportComponent component = new ImportComponent();
        component.setName(element.attr("name"));
        return component;
    }
}
