package com.littleinfinity.libgdx.html.cdi;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.littleinfinity.libgdx.html.mojo.parameters.Input;
import com.littleinfinity.libgdx.html.mojo.parameters.Target;

import java.io.IOException;
import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

public final class ModuleConfigurer {

    public static Injector getInjector(Input input, Target target) throws IOException {
        ArrayList<Module> modules = newArrayList();
        modules.add(new ConfigModule(input, target));
        modules.add(new HeadParserModule());
        modules.add(new BinderModule());
        return Guice.createInjector(modules);
    }
}
