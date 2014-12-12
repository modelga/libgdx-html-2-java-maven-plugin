package com.littleinfinity.libgdx.html.cdi;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;
import com.littleinfinity.libgdx.html.generator.java.JavaSourceComponent;
import com.littleinfinity.libgdx.html.parser.HTMLTagParser;
import com.littleinfinity.libgdx.html.parser.head.ConstParser;
import com.littleinfinity.libgdx.html.parser.head.HeadParser;
import com.littleinfinity.libgdx.html.parser.head.ImportParser;

public class HeadParserModule extends AbstractModule {

    public HeadParserModule() {
    }

    @Override
    protected void configure() {
        TypeLiteral<HTMLTagParser<? extends JavaSourceComponent>> type = new TypeLiteral<HTMLTagParser<? extends JavaSourceComponent>>() {
        };
        Multibinder<HTMLTagParser<? extends JavaSourceComponent>> binder = Multibinder.newSetBinder(binder(), type);
        binder.addBinding().to(HeadParser.class);
        binder.addBinding().to(ConstParser.class);
        binder.addBinding().to(ImportParser.class);
    }
}
