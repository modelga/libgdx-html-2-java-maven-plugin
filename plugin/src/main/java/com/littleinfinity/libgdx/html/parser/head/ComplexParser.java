package com.littleinfinity.libgdx.html.parser.head;

import com.littleinfinity.libgdx.html.generator.java.ComplexComponent;
import com.littleinfinity.libgdx.html.generator.java.JavaSourceComponent;
import com.littleinfinity.libgdx.html.parser.AnnotatedHTMLTagParser;
import com.littleinfinity.libgdx.html.parser.HTMLTagParser;
import com.littleinfinity.libgdx.html.parser.ParsableTags;
import com.littleinfinity.libgdx.html.parser.ParserFactory;
import com.littleinfinity.libgdx.html.util.FactoryDependant;
import org.jsoup.nodes.Element;

import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

@ParsableTags(tags = {"head", "body"})
public class ComplexParser extends AnnotatedHTMLTagParser<ComplexComponent> implements FactoryDependant<ParserFactory> {
    private ParserFactory factory;

    @Override
    public ComplexComponent parse(Element element) {
        requireNonNull(element, "Passed element cannot be null!");
        ComplexComponent complexComponent = new ComplexComponent();
        for (Element child : element.children()) {
            Optional<HTMLTagParser<JavaSourceComponent>> parser = ofNullable(factory.getProperParser(child.tagName()));
            if (parser.isPresent()) {
                complexComponent.addComponent(parser.get().parse(child));
            }
        }
        return complexComponent;
    }

    public void setFactory(ParserFactory factory) {
        this.factory = factory;
    }
}
