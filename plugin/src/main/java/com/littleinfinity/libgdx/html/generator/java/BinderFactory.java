package com.littleinfinity.libgdx.html.generator.java;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.util.AbstractPopulatingFactory;
import com.littleinfinity.libgdx.html.util.Reflection;

import java.util.Set;

@Singleton
public class BinderFactory extends AbstractPopulatingFactory {

    private Set<Binder> binders;

    @Inject
    public BinderFactory(Set<Binder> binders) {
        this.binders = binders;
        populateFactoryDependantWithFactoryReference(binders);
    }

    public <T extends JavaSourceComponent> Binder<T> getBinderForComponent(Class<? extends JavaSourceComponent> component) {
        for (Binder binder : binders) {
            if (Reflection.isObjectImplementingSpecificGenericInterface(binder, Binder.class, component)) {
                return binder;
            }
        }
        return null;
    }
}
