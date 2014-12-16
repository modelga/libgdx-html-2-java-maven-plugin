package com.littleinfinity.libgdx.html.processing.util;

import java.util.Collection;

import static com.littleinfinity.libgdx.html.processing.util.Reflection.isObjectImplementingSpecificGenericInterface;

public abstract class AbstractPopulatingFactory {

    protected final void populateFactoryDependantWithFactoryReference(Collection<?> objects) {
        for (Object parser : objects) {
            if (isObjectImplementingSpecificGenericInterface(parser, FactoryDependant.class, this.getClass())) {
                FactoryDependant<Object> factoryDependend = (FactoryDependant<Object>) parser;
                factoryDependend.setFactory(this);
            }
        }
    }
}
