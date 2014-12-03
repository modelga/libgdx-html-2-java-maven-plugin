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
    @Ignore
    public void shouldParseElementInstance() {
        HeadParser parser = new HeadParser();
        Object parse = parser.parse(new Element(Tag.valueOf("head"), ""));
        assert parse != null;
    }
}
