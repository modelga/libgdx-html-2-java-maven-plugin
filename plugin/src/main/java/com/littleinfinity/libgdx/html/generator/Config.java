package com.littleinfinity.libgdx.html.generator;

import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.mojo.parameters.Input;
import com.littleinfinity.libgdx.html.mojo.parameters.Target;

import java.io.File;

@Singleton
public class Config {
    private Input input;
    private Target target;

    public Config(Input input, Target target) {
        this.input = input;
        this.target = target;
    }

    public Target getTarget() {
        return target;
    }

    public Input getInput() {
        return input;
    }

    public boolean isScanSubdirectories() {
        return input.isScanSubdirectories();
    }

    public File getSourceDir() {
        return input.getSourceDir();
    }

    public File getDir() {
        return target.getDir();
    }

    public boolean isOverwrite() {
        return target.isOverwrite();
    }

    public String getPackageName() {
        return target.getPackageName();
    }
}
