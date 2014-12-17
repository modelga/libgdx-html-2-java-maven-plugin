package com.littleinfinity.libgdx.html.processing.common.parsing;

import com.littleinfinity.libgdx.html.processing.common.joint.AttributeWithParent;
import org.jsoup.nodes.Attribute;

import static org.apache.commons.lang3.Validate.isInstanceOf;

public abstract class AttributeWithParentParser<T> extends AnnotatedAttributeParser<T> {

    @Override
    public final T parse(Attribute attribute) {
        isInstanceOf(AttributeWithParent.class, attribute, "Passed attribute must be instance of AttributeWithParent");
        return parse((AttributeWithParent) attribute);
    }

    public abstract T parse(AttributeWithParent attribute);
}
