package com.littleinfinity.libgdx.html.util;

import com.littleinfinity.libgdx.html.parser.AttributeWithParent;
import org.apache.commons.lang3.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;

import static java.util.Objects.requireNonNull;

public final class AttributeHelper {
    private AttributeHelper() {
    }

    public static AttributeWithParent getAttrbiteWithParent(Element element, String attributeKey) {
        requireNonNull(element, attributeKey);
        Validate.isTrue(element.hasAttr(attributeKey), "Element %s does not have %s attribute set.", element, attributeKey);
        return new AttributeWithParent(element, new Attribute(attributeKey, element.attr(attributeKey)));
    }
}
