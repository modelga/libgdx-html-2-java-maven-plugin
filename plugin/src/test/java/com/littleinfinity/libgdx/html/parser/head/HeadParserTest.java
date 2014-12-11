package com.littleinfinity.libgdx.html.parser.head;

import com.littleinfinity.libgdx.html.generator.java.ComplexComponent;
import com.littleinfinity.libgdx.html.generator.java.JavaSourceComponent;
import com.littleinfinity.libgdx.html.parser.AnnotatedHTMLTagParser;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.junit.Ignore;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class HeadParserTest {

    class InsideParser extends AnnotatedHTMLTagParser<InsideComponent> {

        @Override
        public InsideComponent parse(Element element) {
            return null;
        }
    }

    class InsideComponent extends JavaSourceComponent {

    }

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

    @Test
    @Ignore
    public void shouldParseInsideElement() {

    }
}
