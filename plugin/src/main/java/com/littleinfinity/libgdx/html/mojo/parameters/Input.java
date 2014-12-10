package com.littleinfinity.libgdx.html.mojo.parameters;

import com.google.common.base.Objects;
import com.littleinfinity.libgdx.html.Bootstraper;
import com.littleinfinity.libgdx.html.JavaClassBootstraper;

import java.io.File;

public class Input {

    private static final Class<JavaClassBootstraper> DEFAULT_BOOTSTRAPPER = JavaClassBootstraper.class;
    private String bootstraper;
    private File sourceDir;
    private boolean scanSubdirectories;

    public Class<? extends Bootstraper> getBootstraper() {
        try {
            Class<?> clazz = Class.forName(Objects.firstNonNull(bootstraper, DEFAULT_BOOTSTRAPPER.getName()));
            if (isImplementingBoostrapper(clazz)) {
                throw new IllegalArgumentException("class " + clazz.getName() + " does not implements Bootrapper interface");
            }
            return (Class<? extends Bootstraper>) clazz;
        } catch (ClassNotFoundException | AssertionError e) {
            throw new IllegalArgumentException(e);
        }
    }

    private boolean isImplementingBoostrapper(Class<?> clazz) {
        return clazz.getSuperclass() != null && clazz.isAssignableFrom(Bootstraper.class);
    }

    public boolean isScanSubdirectories() {
        return scanSubdirectories;
    }

    public File getSourceDir() {
        return sourceDir;
    }
}
