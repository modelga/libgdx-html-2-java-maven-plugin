package com.littleinfinity.libgdx.html.cdi;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.littleinfinity.libgdx.html.processing.common.binding.Binder;
import com.littleinfinity.libgdx.html.processing.complex.ComplexBinder;
import com.littleinfinity.libgdx.html.processing.importing.ImportBinder;
import com.littleinfinity.libgdx.html.processing.method.MethodBinder;

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
