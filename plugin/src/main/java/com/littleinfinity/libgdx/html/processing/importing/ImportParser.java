package com.littleinfinity.libgdx.html.processing.importing;

import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.processing.importing.ImportComponent;
import com.littleinfinity.libgdx.html.processing.common.parsing.AnnotatedHTMLTagParser;
import com.littleinfinity.libgdx.html.processing.common.parsing.ParsableTags;
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
