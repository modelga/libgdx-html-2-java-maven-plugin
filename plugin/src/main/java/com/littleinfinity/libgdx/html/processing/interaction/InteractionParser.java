package com.littleinfinity.libgdx.html.processing.interaction;

import com.littleinfinity.libgdx.html.processing.common.joint.AttributeWithParent;
import com.littleinfinity.libgdx.html.processing.common.parsing.AttributeWithParentParser;

public class InteractionParser extends AttributeWithParentParser<InteractionComponent> {
    @Override
    public InteractionComponent parse(AttributeWithParent attribute) {
        String name = attribute.getParent().attr("name");
        InteractionComponent component = new InteractionComponent();
        component.setComponentName(name);
        component.setInteractions(InteractionType.parseStringNames(attribute.getValue().split(",")));

        return null;
    }
}
