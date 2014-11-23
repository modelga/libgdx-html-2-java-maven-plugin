package com.littleinfinity.libgdx.html.cdi;

import com.google.inject.AbstractModule;
import com.littleinfinity.libgdx.html.generator.Config;
import com.littleinfinity.libgdx.html.mojo.parameters.Input;
import com.littleinfinity.libgdx.html.mojo.parameters.Target;

public class ConfigModule extends AbstractModule {
    private Input input;
    private Target target;

    public ConfigModule(Input input, Target target) {
        this.input = input;
        this.target = target;
    }

    @Override
    protected void configure() {
        bind(Config.class).toInstance(new Config(input, target));
    }
}
