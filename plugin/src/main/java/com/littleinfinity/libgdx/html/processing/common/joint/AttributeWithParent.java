package com.littleinfinity.libgdx.html.processing.common.joint;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;

public class AttributeWithParent extends Attribute implements Parent<Element> {

    private final Element parent;

    public AttributeWithParent(Element parent, Attribute attribute) {
        super(attribute.getKey(), attribute.getValue());
        this.parent = parent;
    }

    @Override
    public Element getParent() {
        return parent;
    }
}
