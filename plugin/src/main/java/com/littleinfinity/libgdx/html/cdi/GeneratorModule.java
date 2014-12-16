package com.littleinfinity.libgdx.html.cdi;

import com.google.inject.PrivateModule;
import com.littleinfinity.libgdx.html.bootstrap.Generator;

public class GeneratorModule extends PrivateModule {

    private final Class<? extends Generator> generatorClass;

    public GeneratorModule(Class<? extends Generator> generatorClass) {
        this.generatorClass = generatorClass;
    }

    @Override
    protected void configure() {
        bind(Generator.class).to(generatorClass).asEagerSingleton();
        expose(Generator.class);
    }
}
