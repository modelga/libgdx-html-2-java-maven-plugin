package com.littleinfinity.libgdx.html.cdi;

import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.mojo.Input;
import com.littleinfinity.libgdx.html.mojo.Target;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ModuleConfigurerTest {

    @Test
    public void testGetInjector() throws Exception {
        Injector injector = ModuleConfigurer.getInjector(new Input(), new Target());
        assertThat(injector).isNotNull();
    }
}
