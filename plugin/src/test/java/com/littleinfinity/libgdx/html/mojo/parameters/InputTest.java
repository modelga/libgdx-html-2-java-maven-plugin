package com.littleinfinity.libgdx.html.mojo.parameters;

import com.littleinfinity.libgdx.html.Bootstraper;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.fest.assertions.Assertions.assertThat;

public class InputTest {

    @Test
    public void shouldGetDefaultBootstrapper() throws Exception {
        // given
        Input input = new Input();

        // when
        Class<? extends Bootstraper> bootstraper = input.getBootstraper();

        // then
        assertThat(bootstraper).isNotNull();
    }

    @Test
    public void shouldGetDefinedBootstrapper() throws Exception {
        // given
        Input input = prepareInput(SampleBootstraper.class.getName());

        // when
        Class<? extends Bootstraper> bootstraper = input.getBootstraper();

        // then
        assertThat(bootstraper).isNotNull();
        assertThat(bootstraper).isEqualTo(SampleBootstraper.class);
    }

    private Input prepareInput(String bootstrapper) throws NoSuchFieldException, IllegalAccessException {
        Input input = new Input();
        Field declaredField = input.getClass().getDeclaredField("bootstraper");
        declaredField.setAccessible(true);
        declaredField.set(input, bootstrapper);
        return input;
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnInvalidBootstrapper() throws Exception {
        // given
        Input input = prepareInput("java.lang.Integer");

        // when
        Class<? extends Bootstraper> bootstraper = input.getBootstraper();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnUnexistingBootstrapper() throws Exception {
        // given
        Input input = prepareInput("Unexisting");

        // when
        Class<? extends Bootstraper> bootstraper = input.getBootstraper();
    }
}
