package com.littleinfinity.libgdx.html;

import com.google.inject.Injector;

public abstract class Bootstraper {

    private final Injector injector;
    private final Config config;

    public Bootstraper(Injector injector, Config config) {
        this.injector = injector;
        this.config = config;
    }

    public Injector getInjector() {
        return injector;
    }

    public Config getConfig() {
        return config;
    }

    public abstract void bootstrap();
}
