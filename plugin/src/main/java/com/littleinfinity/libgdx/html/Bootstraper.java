package com.littleinfinity.libgdx.html;

import com.google.inject.Injector;

public abstract class Bootstraper {

    protected final Injector injector;
    protected final Config config;

    public Bootstraper(Injector injector, Config config) {
        this.injector = injector;
        this.config = config;
    }

    public abstract void bootstrap();
}
