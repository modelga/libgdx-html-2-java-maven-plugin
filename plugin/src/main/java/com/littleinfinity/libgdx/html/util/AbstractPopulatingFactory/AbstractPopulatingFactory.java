package com.littleinfinity.libgdx.html.util.AbstractPopulatingFactory;

import com.littleinfinity.libgdx.html.util.FactoryDependend;

import java.util.Collection;

import static com.littleinfinity.libgdx.html.util.Reflection.isObjectImplementingSpecificGenericInterface;

public abstract class AbstractPopulatingFactory {

    protected final void populateParsersWithFactoryReference(Collection<?> objects) {
        for (Object parser : objects) {
            if (isObjectImplementingSpecificGenericInterface(parser, FactoryDependend.class, this.getClass())) {
                FactoryDependend<Object> factoryDependend = (FactoryDependend<Object>) parser;
                factoryDependend.setFactory(this);
            }
        }
    }
}
