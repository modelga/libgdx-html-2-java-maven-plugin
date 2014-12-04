package com.littleinfinity.libgdx.html.generator.java;

import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.generator.Generator;
import com.littleinfinity.libgdx.html.parser.ParserFactory;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import javax.inject.Inject;
import java.io.File;

@Singleton
public class JavaClassGenerator implements Generator {

    private BinderFactory binderFactory;
    private ParserFactory parseFactory;

    @Inject
    public JavaClassGenerator(BinderFactory binderFactory, ParserFactory parseFactory) {
        this.binderFactory = binderFactory;
        this.parseFactory = parseFactory;
    }

    @Override
    public JavaClassSource generate(File f) {
        JavaClassSource source = Roaster.create(JavaClassSource.class);
        return source;
    }
}
