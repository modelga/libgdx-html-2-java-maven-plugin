package com.littleinfinity.libgdx.html.parameters;

import java.io.File;

public class Input {
    File sourceDir;
    boolean scanSubdirectories;

    public boolean isScanSubdirectories() {
        return scanSubdirectories;
    }

    public File getSourceDir() {
        return sourceDir;
    }
}
