package com.littleinfinity.libgdx.html.processing.complex;

import com.google.inject.Inject;
import com.littleinfinity.libgdx.html.processing.common.parsing.ParserFactory;
import com.littleinfinity.libgdx.html.processing.common.parsing.GenericParser;
import com.littleinfinity.libgdx.html.processing.common.parsing.HTMLTagParser;
import com.littleinfinity.libgdx.html.processing.common.joint.JavaSourceComponent;
import org.jsoup.nodes.Document;

import static java.util.Objects.nonNull;

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
        return nonNull(document.head()) && nonNull(document.body()); // TODO add checking nonNull for body too.
    }
}
