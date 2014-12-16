package com.littleinfinity.libgdx.html.parser;

import com.littleinfinity.libgdx.html.processing.common.parsing.ParserFactory;
import com.littleinfinity.libgdx.html.processing.complex.ComplexComponent;
import com.littleinfinity.libgdx.html.processing.common.joint.JavaSourceComponent;
import com.littleinfinity.libgdx.html.processing.common.parsing.HTMLTagParser;
import com.littleinfinity.libgdx.html.processing.complex.DocumentParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DocumentParserTest {

    private ParserFactory factory;
    private DocumentParser parser;

    @Before
    public void setUpParser() {
        factory = mock(ParserFactory.class);
        parser = new DocumentParser(factory);
    }

    @Test
    public void shouldNotBeAbleToParseWithoutHeadSection() {
        // given
        Document document = createDocumentWithElements("body");

        // when
        boolean ableToParse = parser.isAbleToParse(document);

        // then
        assertThat(ableToParse).isFalse();
    }

    @Test
    public void shouldNotBeAbleToParseWithoutBodySection() {
        // given
        Document document = createDocumentWithElements("head");

        // when
        boolean ableToParse = parser.isAbleToParse(document);

        // then
        assertThat(ableToParse).isFalse();
    }

    @Test
    public void shouldParseWithHeadAndBodySections() {
        // given
        Document document = createDocumentWithElements("body", "head");

        // when
        boolean ableToParse = parser.isAbleToParse(document);

        // then
        assertThat(ableToParse).isTrue();
    }

    @Test
    public void shouldParseDocument() {
        // given
        HTMLTagParser<JavaSourceComponent> headParser = mock(HTMLTagParser.class);
        when(factory.getProperParser("head")).thenReturn(headParser);
        Document document = createDocumentWithElements("head");
        ComplexComponent complexComponent = new ComplexComponent();
        when(headParser.parse(document.head())).thenReturn(complexComponent);

        // when
        ComplexComponent parse = parser.parse(document);

        // then
        assertThat(parse.getAll()).hasSize(1);
        assertThat(parse.getAll().get(0)).isEqualTo(complexComponent);
        verify(headParser, times(1)).parse(document.head());
    }

    private Document createDocumentWithElements(String... elements) {
        Document document = new Document("");
        for (String element : elements) {
            document.appendChild(new Element(Tag.valueOf(element), ""));
        }
        return document;
    }
}
