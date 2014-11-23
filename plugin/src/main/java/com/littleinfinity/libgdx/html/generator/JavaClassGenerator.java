package com.littleinfinity.libgdx.html.generator;

import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.parser.HTMLTagParser;
import org.apache.commons.lang3.NotImplementedException;

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
        throw new NotImplementedException("");
    }
}
