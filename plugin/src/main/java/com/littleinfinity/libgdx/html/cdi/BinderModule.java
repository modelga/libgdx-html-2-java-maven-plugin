package com.littleinfinity.libgdx.html.cdi;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.littleinfinity.libgdx.html.generator.java.Binder;
import com.littleinfinity.libgdx.html.generator.java.ComplexBinder;
import com.littleinfinity.libgdx.html.generator.java.ImportBinder;
import com.littleinfinity.libgdx.html.generator.java.MethodBinder;

public class BinderModule extends AbstractModule {

    public BinderModule() {
    }

    @Override
    protected void configure() {
        Multibinder<Binder> binder = Multibinder.newSetBinder(binder(), Binder.class);
        binder.addBinding().to(MethodBinder.class);
        binder.addBinding().to(ImportBinder.class);
        binder.addBinding().to(ComplexBinder.class);
    }
}
