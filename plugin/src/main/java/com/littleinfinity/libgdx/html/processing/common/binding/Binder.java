package com.littleinfinity.libgdx.html.processing.common.binding;

import com.littleinfinity.libgdx.html.processing.common.joint.JavaSourceComponent;
import org.jboss.forge.roaster.model.source.JavaClassSource;

public interface Binder<T extends JavaSourceComponent> {
    void bind(final JavaClassSource source, T component);
}
