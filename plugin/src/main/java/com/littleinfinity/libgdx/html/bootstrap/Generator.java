package com.littleinfinity.libgdx.html.bootstrap;

import org.jboss.forge.roaster.model.source.JavaClassSource;

import java.io.File;

public interface Generator {
    JavaClassSource generate(File f);
}
