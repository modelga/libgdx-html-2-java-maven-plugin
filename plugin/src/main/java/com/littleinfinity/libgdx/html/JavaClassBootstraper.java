package com.littleinfinity.libgdx.html;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.generator.Config;

public class JavaClassBootstraper extends Bootstraper {
    @Inject
    public JavaClassBootstraper(Injector injector, Config config) {
        super(injector, config);
    }

    @Override
    public void bootstrap() {

    }
}
