package com.littleinfinity.libgdx.html.parser.head;

import com.littleinfinity.libgdx.html.processing.complex.ComplexComponent;
import com.littleinfinity.libgdx.html.processing.common.joint.JavaSourceComponent;
import com.littleinfinity.libgdx.html.processing.common.parsing.AnnotatedHTMLTagParser;
import com.littleinfinity.libgdx.html.processing.common.parsing.HTMLTagParser;
import com.littleinfinity.libgdx.html.processing.common.parsing.ParsableTags;
import com.littleinfinity.libgdx.html.processing.common.parsing.ParserFactory;
import com.littleinfinity.libgdx.html.processing.complex.ComplexParser;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.junit.Test;

import static com.google.common.collect.Sets.newHashSet;
import static org.fest.assertions.Assertions.assertThat;

public class ComplexParserTest {

    @ParsableTags(tags = {"complex"})
    public class ComplexParserImpl extends ComplexParser {

    }

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
        ComplexParserImpl parser = new ComplexParserImpl();
        assert parser != null;
    }

    @Test
    public void shouldParseEmptyElement() {
        // given
        ComplexParserImpl parser = new ComplexParserImpl();
        Element head = new Element(Tag.valueOf("complex"), "");

        // when
        ComplexComponent parsed = parser.parse(head);

        // then
        assertThat(parsed).isNotNull();
    }

    @Test
    public void shouldParseInsideElement() {
        // given
        ComplexParserImpl parser = new ComplexParserImpl();
        parser.setFactory(setUpfactory(new InsideParser()));
        Element head = prepareComplexWithInsideElement();

        // when
        ComplexComponent parsed = parser.parse(head);

        // then
        assertThat(parsed.getAll()).hasSize(1);
        assertThat(parsed.getAll().get(0)).isInstanceOf(InsideComponent.class);
    }

    private ParserFactory setUpfactory(HTMLTagParser<? extends JavaSourceComponent>... parsers) {
        return new ParserFactory(newHashSet(parsers));
    }

    private Element prepareComplexWithInsideElement() {
        Element head = new Element(Tag.valueOf("complex"), "");
        head.appendChild(new Element(Tag.valueOf("inside"), ""));
        return head;
    }
}
