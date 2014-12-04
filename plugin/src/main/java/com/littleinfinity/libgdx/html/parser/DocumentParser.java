package com.littleinfinity.libgdx.html.parser;

import com.google.inject.Inject;
import com.littleinfinity.libgdx.html.generator.java.ComplexComponent;
import com.littleinfinity.libgdx.html.generator.java.JavaSourceComponent;
import org.jsoup.nodes.Document;

import java.util.Objects;

public class DocumentParser implements GenericParser<ComplexComponent, Document> {

    private ParserFactory factory;

    @Inject
    public DocumentParser(ParserFactory factory) {
        this.factory = factory;
    }

    @Override
    public ComplexComponent parse(Document document) {
        ComplexComponent complexComponent = new ComplexComponent();
        HTMLTagParser<JavaSourceComponent> head = factory.getProperParser("head");
        complexComponent.addComponent(head.parse(document.head()));
        return complexComponent;
    }

    @Override
    public boolean isAbleToParse(Document document) {
        return Objects.nonNull(document.head()); // TODO add checking nonNull for body too.
    }
}
