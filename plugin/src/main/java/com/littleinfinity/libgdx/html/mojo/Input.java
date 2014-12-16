package com.littleinfinity.libgdx.html.mojo;

import com.littleinfinity.libgdx.html.bootstrap.Bootstraper;
import com.littleinfinity.libgdx.html.bootstrap.JavaClassBootstraper;

import java.io.File;

import static com.google.common.base.Strings.isNullOrEmpty;

public class Input {

    private static final Class<JavaClassBootstraper> DEFAULT_BOOTSTRAPPER = JavaClassBootstraper.class;
    private String bootstraper;
    private File sourceDir;
    private boolean scanSubdirectories;

    public Class<? extends Bootstraper> getBootstraper() {
        if (isNullOrEmpty(bootstraper)) {
            return DEFAULT_BOOTSTRAPPER;
        } else {
            return getBootstrappingClass();
        }
    }

    private Class<? extends Bootstraper> getBootstrappingClass() {
        try {
            Class<?> clazz = Class.forName(bootstraper);
            if (!doesImplementingBootstraper(clazz)) {
                throw new IllegalArgumentException("class " + clazz.getName() + " does not implements Bootrapper interface");
            }
            return (Class<? extends Bootstraper>) clazz;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private boolean doesImplementingBootstraper(Class<?> clazz) {
        Class<?> superclass = clazz.getSuperclass();
        do {
            if (superclass.equals(Bootstraper.class)) {
                return true;
            }
            superclass = superclass.getSuperclass();
        } while (superclass != null);
        return false;
    }

    public boolean isScanSubdirectories() {
        return scanSubdirectories;
    }

    public File getSourceDir() {
        return sourceDir;
    }
}
