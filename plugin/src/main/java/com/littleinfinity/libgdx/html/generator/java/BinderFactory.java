package com.littleinfinity.libgdx.html.generator.java;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;

@Singleton
public class BinderFactory {

    private Set<Binder> binders;

    @Inject
    public BinderFactory(Set<Binder> binders) {
        this.binders = binders;
    }

    public <T extends JavaSourceComponent> Binder<T> getBinderForComponent(Class<T> component) {
        for (Binder binder : binders) {
            ParameterizedType type = (ParameterizedType) binder.getClass().getGenericInterfaces()[0];
            Type actualTypeArgument = type.getActualTypeArguments()[0];
            if (component.equals(actualTypeArgument)) {
                return binder;
            }
        }
        return null;
    }
}
