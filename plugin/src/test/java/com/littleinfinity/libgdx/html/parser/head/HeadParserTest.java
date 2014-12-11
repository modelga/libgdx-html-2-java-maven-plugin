package com.littleinfinity.libgdx.html.parser.head;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.junit.Ignore;
import org.junit.Test;

public class HeadParserTest {
    @Test
    public void shouldCreateInstance() {
        HeadParser parser = new HeadParser();
        assert parser != null;
    }

    @Test
    public void shouldParseEmptyElement() {
        // given
        HeadParser parser = new HeadParser();
        Element head = new Element(Tag.valueOf("head"), "");

        // when
        ComplexComponent parsed = parser.parse(head);

        // then
        assertThat(parsed).isNotNull();
    }
}
