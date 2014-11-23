package com.littleinfinity.libgdx.html.mojo.parameters;

import com.google.common.base.Objects;
import com.littleinfinity.libgdx.html.Bootstraper;
import com.littleinfinity.libgdx.html.JavaClassBootstraper;

import java.io.File;

public class Input {

    private String bootstraper;
    private File sourceDir;
    private boolean scanSubdirectories;

    public Class<? extends Bootstraper> getBootstraper() {
        try {
            Class<?> clazz = Class.forName(Objects.firstNonNull(bootstraper, JavaClassBootstraper.class.getName()));
            assert clazz.getSuperclass() != null && clazz.isAssignableFrom(Bootstraper.class) : "class " + bootstraper + " does not implements Generator interface";
            return (Class<? extends Bootstraper>) clazz;
        } catch (ClassNotFoundException | AssertionError e) {
            throw new IllegalArgumentException(e);
        }
    }

    public boolean isScanSubdirectories() {
        return scanSubdirectories;
    }

    public File getSourceDir() {
        return sourceDir;
    }
}
