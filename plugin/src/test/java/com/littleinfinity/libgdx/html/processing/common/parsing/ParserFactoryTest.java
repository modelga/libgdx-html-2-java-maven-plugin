package com.littleinfinity.libgdx.html.processing.common.parsing;

import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.bootstrap.InjectorUtil;
import com.littleinfinity.libgdx.html.processing.common.joint.JavaSourceComponent;
import com.littleinfinity.libgdx.html.processing.common.parsing.HTMLTagParser;
import com.littleinfinity.libgdx.html.processing.common.parsing.ParserFactory;
import org.fest.assertions.Assertions;
import org.junit.Test;

public class ParserFactoryTest {
    Injector injector = InjectorUtil.getJavaInjector();

    @Test
    public void shouldGetHeadParseFactory() {
        ParserFactory factory = injector.getInstance(ParserFactory.class);

        Assertions.assertThat(factory).isNotNull();
    }

    @Test
    public void shouldReturnHeadParser() {
        // given
        ParserFactory factory = injector.getInstance(ParserFactory.class);

        // when
        HTMLTagParser<JavaSourceComponent> headParser = factory.getProperParser("head");

        // then
        Assertions.assertThat(headParser).isNotNull();
    }
}
