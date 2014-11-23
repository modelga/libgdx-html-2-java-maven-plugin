package com.littleinfinity.libgdx.html;

import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.generator.Config;

public abstract class Bootstraper {

    private final Injector injector;
    private final Config config;

    public Bootstraper(Injector injector, Config config) {
        this.injector = injector;
        this.config = config;
    }

    public abstract void bootstrap();
}
