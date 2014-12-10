package com.littleinfinity.libgdx.html;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.cdi.GeneratorModule;
import com.littleinfinity.libgdx.html.generator.java.JavaClassGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.util.InputMismatchException;

public class JavaClassBootstraper extends Bootstraper {

    private final Injector childInjector;

    @Inject
    public JavaClassBootstraper(Injector injector, Config config) {
        super(injector, config);
        this.childInjector = injector.createChildInjector(new GeneratorModule(JavaClassGenerator.class));
    }

    @Override
    public Injector getChildInjector() {
        return childInjector;
    }

    @Override
    public void bootstrap() {
        try {
            HtmlFileVisitor fileVisitor = getChildInjector().getInstance(HtmlFileVisitor.class);
            Files.walkFileTree(getConfig().getSourceDir().toPath(), fileVisitor);
        } catch (IOException e) {
            throw new InputMismatchException(e.getMessage());
        }
    }
}
