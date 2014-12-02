package com.littleinfinity.libgdx.html.cdi;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;
import com.littleinfinity.libgdx.html.generator.java.Binder;
import com.littleinfinity.libgdx.html.generator.java.ImportBinder;
import com.littleinfinity.libgdx.html.generator.java.MethodBinder;
import com.littleinfinity.libgdx.html.parser.HTMLTagParser;
import com.littleinfinity.libgdx.html.parser.head.ConstParser;
import com.littleinfinity.libgdx.html.parser.head.HeadParser;
import com.littleinfinity.libgdx.html.parser.head.ImportParser;

import java.io.IOException;

public class BinderModule extends AbstractModule {

    public BinderModule() throws IOException {
        init();
    }

    private void init() throws IOException {
    }

    @Override
    protected void configure() {
        Multibinder<Binder> binder = Multibinder.newSetBinder(binder(), Binder.class);
        binder.addBinding().to(MethodBinder.class);
        binder.addBinding().to(ImportBinder.class);
    }
}
