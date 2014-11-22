package com.littleinfinity.libgdx.html.mojo.parameters;

import java.io.File;

public class Input {
    private File sourceDir;
    private boolean scanSubdirectories;

    public boolean isScanSubdirectories() {
        return scanSubdirectories;
    }

    public File getSourceDir() {
        return sourceDir;
    }
}
