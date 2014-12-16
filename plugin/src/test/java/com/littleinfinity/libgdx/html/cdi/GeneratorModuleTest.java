package com.littleinfinity.libgdx.html.cdi;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.bootstrap.Generator;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.junit.Test;

import java.io.File;

import static org.fest.assertions.Assertions.assertThat;

public class GeneratorModuleTest {

    private static class SampleGenerator implements Generator {

        @Override
        public JavaClassSource generate(File f) {
            return null;
        }
    }

    @Test
    public void shouldExposeGenerator() {
        // given
        Injector injector = Guice.createInjector(new GeneratorModule(SampleGenerator.class));

        //when
        Generator generator = injector.getInstance(Generator.class);

        //then
        assertThat(generator.getClass()).isEqualTo(SampleGenerator.class);
    }
}
