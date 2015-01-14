package com.littleinfinity.libgdx.html.cdi;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;
import com.littleinfinity.libgdx.html.processing.common.joint.JavaSourceComponent;
import com.littleinfinity.libgdx.html.processing.common.parsing.HTMLTagParser;
import com.littleinfinity.libgdx.html.processing.complex.ComplexParser;
import com.littleinfinity.libgdx.html.processing.constant.ConstParser;
import com.littleinfinity.libgdx.html.processing.importing.ImportParser;

public class ParserModule extends AbstractModule {

    public ParserModule() {
    }

    @Override
    protected void configure() {
        tagParsers();
    }

    private void tagParsers() {
        TypeLiteral<HTMLTagParser<? extends JavaSourceComponent>> type = new TypeLiteral<HTMLTagParser<? extends JavaSourceComponent>>() {
        };
        Multibinder<HTMLTagParser<? extends JavaSourceComponent>> binder = Multibinder.newSetBinder(binder(), type);
        binder.addBinding().to(ComplexParser.class);
        binder.addBinding().to(ConstParser.class);
        binder.addBinding().to(ImportParser.class);
    }
}
