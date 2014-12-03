package com.littleinfinity.libgdx.html.parser.head;

import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.InjectorUtil;
import com.littleinfinity.libgdx.html.generator.java.JavaSourceComponent;
import com.littleinfinity.libgdx.html.parser.HTMLTagParser;
import org.fest.assertions.Assertions;
import org.junit.Test;

public class HeadParseFactoryTest {
    Injector injector = InjectorUtil.getJavaInjector();

    @Test
    public void shouldGetHeadParseFactory() {
        HeadParseFactory factory = injector.getInstance(HeadParseFactory.class);

        Assertions.assertThat(factory).isNotNull();
    }

    @Test
    public void should() {
        // given
        HeadParseFactory factory = injector.getInstance(HeadParseFactory.class);

        // when
        HTMLTagParser<JavaSourceComponent> headParser = factory.getProperParser("head");

        // then
        Assertions.assertThat(headParser).isNotNull();
    }
}
