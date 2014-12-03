package com.littleinfinity.libgdx.html.parser.head;

import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.generator.java.ImportComponent;
import com.littleinfinity.libgdx.html.parser.AnnotatedHTMLTagParser;
import com.littleinfinity.libgdx.html.parser.ParsableTags;
import org.jsoup.nodes.Element;

@Singleton
@ParsableTags(tags = {"import"})
public class ImportParser extends AnnotatedHTMLTagParser<ImportComponent> {

    @Override
    public ImportComponent parse(Element element) {
        ImportComponent component = new ImportComponent(element.attr("name"));
        return component;
    }
}
