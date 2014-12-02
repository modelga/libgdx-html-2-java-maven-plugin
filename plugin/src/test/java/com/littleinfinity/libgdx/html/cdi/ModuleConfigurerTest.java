package com.littleinfinity.libgdx.html.cdi;

import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.mojo.parameters.Input;
import com.littleinfinity.libgdx.html.mojo.parameters.Target;
import org.fest.assertions.Assert;
import org.fest.assertions.Assertions;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;

public class ModuleConfigurerTest {

    @Test
    public void testGetInjector() throws Exception {
        Injector injector = ModuleConfigurer.getInjector(new Input(), new Target());
        assertThat(injector).isNotNull();
    }
}
