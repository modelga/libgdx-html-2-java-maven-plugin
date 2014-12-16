package com.littleinfinity.libgdx.html.cdi;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.littleinfinity.libgdx.html.mojo.Input;
import com.littleinfinity.libgdx.html.mojo.Target;

import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

public final class ModuleConfigurer {
    private ModuleConfigurer() {
    }

    public static Injector getInjector(Input input, Target target) {
        ArrayList<Module> modules = newArrayList();
        modules.add(new ConfigModule(input, target));
        modules.add(new ParserModule());
        modules.add(new BinderModule());
        return Guice.createInjector(modules);
    }
}
