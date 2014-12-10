package com.littleinfinity.libgdx.html;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.generator.Generator;
import com.littleinfinity.libgdx.html.generator.java.JavaClassGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.util.InputMismatchException;

public class JavaClassBootstraper extends Bootstraper {
    private final Generator classGenerator;

    @Inject
    public JavaClassBootstraper(Injector injector, Config config) {
        super(injector, config);
        classGenerator = injector.getInstance(JavaClassGenerator.class);
    }

    @Override
    public void bootstrap() {
        try {
            Files.walkFileTree(getConfig().getSourceDir().toPath(), new HtmlFileVisitor(classGenerator));
        } catch (IOException e) {
            throw new InputMismatchException(e.getMessage());
        }
    }
}
