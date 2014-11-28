package com.littleinfinity.libgdx.html.generator.java;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
public class BinderFactory {

    @Inject
    public BinderFactory(Injector injector) {

    }

    public <T extends JavaSourceComponent> Binder<T> getBinderForComponent(T component) {
        return null;
    }
}
