package com.littleinfinity.libgdx.html.processing.common.binding;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.processing.common.joint.JavaSourceComponent;
import com.littleinfinity.libgdx.html.processing.util.AbstractPopulatingFactory;
import com.littleinfinity.libgdx.html.processing.util.Reflection;

import java.util.Set;

@Singleton
public class BinderFactory extends AbstractPopulatingFactory {

    private Set<Binder> binders;

    @Inject
    public BinderFactory(Set<Binder> binders) {
        this.binders = binders;
        populateFactoryDependantWithFactoryReference(binders);
    }

    public <T extends JavaSourceComponent> Binder<T> getBinderForComponent(JavaSourceComponent component) {
        return getBinderForComponentType(component.getClass());
    }

    public <T extends JavaSourceComponent> Binder<T> getBinderForComponentType(Class<? extends JavaSourceComponent> component) {
        for (Binder binder : binders) {
            if (Reflection.isObjectImplementingSpecificGenericInterface(binder, Binder.class, component)) {
                return binder;
            }
        }
        return null;
    }
}
