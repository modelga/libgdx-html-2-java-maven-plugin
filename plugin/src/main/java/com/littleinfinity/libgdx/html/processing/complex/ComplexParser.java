package com.littleinfinity.libgdx.html.processing.complex;

import com.littleinfinity.libgdx.html.processing.common.joint.JavaSourceComponent;
import com.littleinfinity.libgdx.html.processing.common.parsing.AnnotatedHTMLTagParser;
import com.littleinfinity.libgdx.html.processing.common.parsing.HTMLTagParser;
import com.littleinfinity.libgdx.html.processing.common.parsing.ParsableTags;
import com.littleinfinity.libgdx.html.processing.common.parsing.ParserFactory;
import com.littleinfinity.libgdx.html.processing.util.FactoryDependant;
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
