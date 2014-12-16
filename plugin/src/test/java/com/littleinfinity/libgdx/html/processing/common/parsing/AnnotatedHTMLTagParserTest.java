package com.littleinfinity.libgdx.html.processing.common.parsing;

import com.littleinfinity.libgdx.html.processing.common.parsing.AnnotatedHTMLTagParser;
import com.littleinfinity.libgdx.html.processing.common.parsing.ParsableTags;
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

    class SampleInvalidTagParser extends AnnotatedHTMLTagParser<Object> {

        @Override
        public Object parse(Element o) {
            return null;
        }
    }

    AnnotatedHTMLTagParser<Object> parser = new SampleTagParser();

    @Test
    public void shouldBeAbleToParse() throws Exception {
        // given
        Element element = createTag("tag");

        // when
        boolean ableToParse = parser.isAbleToParse(element);

        // then
        assert ableToParse : "This element should be parseable";
    }

    private Element createTag(String tag) {
        return new Element(Tag.valueOf(tag), "");
    }

    @Test
    public void shouldNotBeAbleToParse() throws Exception {
        // given
        Element element = createTag("anotherTag");

        // when
        boolean ableToParse = parser.isAbleToParse(element);

        // then
        assert !ableToParse : "This element shouldn't be parseable";
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnInvalidClass() throws Exception {
        // when
        SampleInvalidTagParser parser = new SampleInvalidTagParser();
    }
}
