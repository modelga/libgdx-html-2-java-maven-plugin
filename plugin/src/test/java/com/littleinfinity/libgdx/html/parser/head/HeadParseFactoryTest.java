package com.littleinfinity.libgdx.html.parser.head;

import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.InjectorUtil;
import org.fest.assertions.Assertions;
import org.junit.Test;

public class HeadParseFactoryTest {
    Injector injector = InjectorUtil.getJavaInjector();

    @Test
    public void shouldGetHeadParseFactory() {
        HeadParseFactory factory = injector.getInstance(HeadParseFactory.class);

        Assertions.assertThat(factory).isNotNull();
    }
}
