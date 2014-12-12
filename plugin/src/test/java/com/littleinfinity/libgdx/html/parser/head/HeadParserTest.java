package com.littleinfinity.libgdx.html.parser.head;

import com.littleinfinity.libgdx.html.generator.java.ComplexComponent;
import com.littleinfinity.libgdx.html.generator.java.JavaSourceComponent;
import com.littleinfinity.libgdx.html.parser.AnnotatedHTMLTagParser;
import com.littleinfinity.libgdx.html.parser.HTMLTagParser;
import com.littleinfinity.libgdx.html.parser.ParsableTags;
import com.littleinfinity.libgdx.html.parser.ParserFactory;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.junit.Test;

import static com.google.common.collect.Sets.newHashSet;
import static org.fest.assertions.Assertions.assertThat;

public class HeadParserTest {

    @ParsableTags(tags = {"inside"})
    static class InsideParser extends AnnotatedHTMLTagParser<InsideComponent> {

        @Override
        public InsideComponent parse(Element element) {
            return new InsideComponent();
        }
    }

    static class InsideComponent extends JavaSourceComponent {

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
    public void shouldParseInsideElement() {
        // given
        HeadParser parser = new HeadParser();
        parser.setFactory(setUpfactory(new InsideParser()));
        Element head = prepareHeadWithInsideElement();

        // when
        ComplexComponent parsed = parser.parse(head);

        // then
        assertThat(parsed.getAll()).hasSize(1);
        assertThat(parsed.getAll().get(0)).isInstanceOf(InsideComponent.class);
    }

    private ParserFactory setUpfactory(HTMLTagParser<? extends JavaSourceComponent>... parsers) {
        return new ParserFactory(newHashSet(parsers));
    }

    private Element prepareHeadWithInsideElement() {
        Element head = new Element(Tag.valueOf("head"), "");
        head.appendChild(new Element(Tag.valueOf("inside"), ""));
        return head;
    }
}
