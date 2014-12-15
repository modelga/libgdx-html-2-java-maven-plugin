package com.littleinfinity.libgdx.html.mojo;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.Bootstraper;
import com.littleinfinity.libgdx.html.Config;
import com.littleinfinity.libgdx.html.mojo.parameters.Input;
import org.apache.commons.lang3.Validate;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class GenerateMojoTest {

    private GenerateMojo mojo;
    private Input input;
    private Field inputField;

    public static class SampleBootstraper extends Bootstraper {

        public static boolean BOOTSTRAPP_WAS_CALLED;

        @Inject
        public SampleBootstraper(Injector injector, Config config) {
            super(injector, config);
        }

        @Override
        public void bootstrap() {
            Validate.isTrue(!BOOTSTRAPP_WAS_CALLED, "Must be false");
            BOOTSTRAPP_WAS_CALLED = true;
        }
    }

    @Before
    public void setUpMojo() throws NoSuchFieldException, IllegalAccessException {
        input = mock(Input.class);
        mojo = new GenerateMojo();
        inputField = mojo.getClass().getDeclaredField("input");
        inputField.setAccessible(true);
        inputField.set(mojo, input);
    }

    @Test
    public void shouldRunBootstrapper() throws MojoFailureException, MojoExecutionException {
        // given
        doReturn(SampleBootstraper.class).when(input).getBootstraper();

        // when
        mojo.execute();

        // then
        assertThat(SampleBootstraper.BOOTSTRAPP_WAS_CALLED).isTrue();
    }
}
