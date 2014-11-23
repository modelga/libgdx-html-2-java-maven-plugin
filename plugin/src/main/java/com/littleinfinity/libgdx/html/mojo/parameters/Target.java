package com.littleinfinity.libgdx.html.mojo.parameters;

import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

public class Target {
    @Parameter(required = true)
    private File dir;
    @Parameter(defaultValue = "")
    private String packageName;
    private boolean overwrite;

    public File getDir() {
        return dir;
    }

    public String getPackageName() {
        return packageName;
    }

    public boolean isOverwrite() {
        return overwrite;
    }
}
