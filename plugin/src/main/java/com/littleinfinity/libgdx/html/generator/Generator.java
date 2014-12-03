package com.littleinfinity.libgdx.html.generator;

import org.jboss.forge.roaster.model.source.JavaClassSource;

import java.io.File;

public interface Generator {
    JavaClassSource generate(File f);
}
