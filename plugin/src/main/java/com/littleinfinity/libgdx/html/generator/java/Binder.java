package com.littleinfinity.libgdx.html.generator.java;

import org.jboss.forge.roaster.model.source.JavaClassSource;

public interface Binder<T extends JavaSourceComponent> {
    void bind(final JavaClassSource source, T component);
}
