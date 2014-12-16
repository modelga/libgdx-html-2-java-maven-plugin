package com.littleinfinity.libgdx.html.parser.head;

import com.littleinfinity.libgdx.html.processing.complex.ImportParser;
import com.littleinfinity.libgdx.html.processing.importing.ImportComponent;
import org.fest.assertions.Assertions;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.junit.Test;

public class ImportParserTest {

    @Test
    public void shouldParseImport() throws Exception {
        // given
        ImportParser parser = new ImportParser();
        Element element = createImportElement("org.element.Element");

        // when
        ImportComponent component = parser.parse(element);

        // then
        Assertions.assertThat(component.getName()).isEqualTo("org.element.Element");
    }

    private Element createImportElement(String importValue) {
        Element element = new Element(Tag.valueOf("import"), "");
        element.attr("name", importValue);
        return element;
    }
}
