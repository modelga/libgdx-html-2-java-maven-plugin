package com.littleinfinity.libgdx.html.generator.java;

import com.littleinfinity.libgdx.html.util.FactoryDependant;
import org.jboss.forge.roaster.model.source.JavaClassSource;

public class ComplexBinder implements Binder<ComplexComponent>, FactoryDependant<BinderFactory> {

    private BinderFactory factory;

    @Override
    public void bind(JavaClassSource source, ComplexComponent component) {
        for (JavaSourceComponent innerComponent : component.getAll()) {
            delegateBinding(source, innerComponent);
        }
    }

    private void delegateBinding(JavaClassSource source, JavaSourceComponent innerComponent) {
        Binder<JavaSourceComponent> delegatedBinder = factory.getBinderForComponent(innerComponent);
        delegatedBinder.bind(source, innerComponent);
    }

    @Override
    public void setFactory(BinderFactory factory) {
        this.factory = factory;
    }
}
