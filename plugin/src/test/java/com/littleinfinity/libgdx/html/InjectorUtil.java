package com.littleinfinity.libgdx.html;

import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.cdi.ModuleConfigurer;
import com.littleinfinity.libgdx.html.mojo.parameters.Input;
import com.littleinfinity.libgdx.html.mojo.parameters.Target;

public class InjectorUtil {
    public static Injector getJavaInjector() {
        return ModuleConfigurer.getInjector(new Input(), new Target());
    }
}
