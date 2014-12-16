package com.littleinfinity.libgdx.html.processing.importing;

import com.littleinfinity.libgdx.html.processing.common.joint.JavaSourceComponent;

public final class ImportComponent extends JavaSourceComponent {
    private final String name;

    public ImportComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
