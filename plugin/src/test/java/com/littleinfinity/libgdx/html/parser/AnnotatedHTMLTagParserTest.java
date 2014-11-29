package com.littleinfinity.libgdx.html.parser;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.junit.Test;

public class AnnotatedHTMLTagParserTest {
    @ParsableTags(tags = "tag")
    class SampleTagParser extends AnnotatedHTMLTagParser<Object> {

        @Override
        public Object parse(Element o) {
            return null;
        }
    }

    AnnotatedHTMLTagParser<Object> parser = new SampleTagParser();

    @Test
    public void shouldBeAbleToParse() throws Exception {
        // given
        Element element = new Element(Tag.valueOf("tag"), "");

        // when
        boolean ableToParse = parser.isAbleToParse(element);

        // then
        assert ableToParse : "This element should be parseable";
    }

    @Test
    public void shouldNotBeAbleToParse() throws Exception {
        // given
        Element element = new Element(Tag.valueOf("anotherTag"), "");

        // when
        boolean ableToParse = parser.isAbleToParse(element);

        // then
        assert !ableToParse : "This element shouldn't be parseable";
    }
}
