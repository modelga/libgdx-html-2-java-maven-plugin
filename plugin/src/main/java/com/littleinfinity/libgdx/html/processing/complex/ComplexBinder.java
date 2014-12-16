package com.littleinfinity.libgdx.html.processing.complex;

import com.littleinfinity.libgdx.html.processing.common.binding.Binder;
import com.littleinfinity.libgdx.html.processing.common.binding.BinderFactory;
import com.littleinfinity.libgdx.html.processing.common.joint.JavaSourceComponent;
import com.littleinfinity.libgdx.html.processing.util.FactoryDependant;
import org.jboss.forge.roaster.model.source.JavaClassSource;

public class ComplexBinder implements Binder<ComplexComponent>, FactoryDependant<BinderFactory> {

    private BinderFactory factory;

    @Override
    public void bind(JavaClassSource source, ComplexComponent component) {
        component.getAll().forEach((innerComponent) -> delegateBinding(source, innerComponent));
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
