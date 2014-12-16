package com.littleinfinity.libgdx.html.bootstrap;

import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.cdi.ModuleConfigurer;
import com.littleinfinity.libgdx.html.mojo.Input;
import com.littleinfinity.libgdx.html.mojo.Target;

public class InjectorUtil {
    public static Injector getJavaInjector() {
        return ModuleConfigurer.getInjector(new Input(), new Target());
    }
}
