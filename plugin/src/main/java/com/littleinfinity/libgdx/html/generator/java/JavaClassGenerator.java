package com.littleinfinity.libgdx.html.generator.java;

import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.Config;
import com.littleinfinity.libgdx.html.generator.Generator;
import com.littleinfinity.libgdx.html.parser.HTMLTagParser;
import org.apache.commons.lang3.NotImplementedException;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;

import javax.inject.Inject;
import java.io.File;
import java.util.Set;

@Singleton
public class JavaClassGenerator implements Generator {

    private Set<HTMLTagParser<Object>> parsers;
    private Config config;
    private Injector injector;

    @Inject
    public JavaClassGenerator(Set<HTMLTagParser<Object>> parsers, Config config) {
        this.parsers = parsers;
        this.config = config;
    }

    @Override
    public void generate(File f) {
        JavaClassSource source = Roaster.create(JavaClassSource.class);
        throw new NotImplementedException("");
    }
}
