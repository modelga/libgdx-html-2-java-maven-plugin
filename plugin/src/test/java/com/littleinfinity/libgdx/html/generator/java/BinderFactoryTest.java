package com.littleinfinity.libgdx.html.generator.java;

import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.InjectorUtil;
import org.fest.assertions.Assertions;
import org.junit.Test;

public class BinderFactoryTest {

    Injector injector = InjectorUtil.getJavaInjector();

    class UnBindedComponent extends JavaSourceComponent {

    }

    @Test
    public void shouldCreateBinder() {
        BinderFactory binderFactory = injector.getInstance(BinderFactory.class);

        Assertions.assertThat(binderFactory).isNotNull();
    }

    @Test
    public void shouldGetMethodBinder() {
        // given
        BinderFactory binderFactory = injector.getInstance(BinderFactory.class);

        // when
        Binder<MethodComponent> binder = binderFactory.getBinderForComponentType(MethodComponent.class);

        // then
        Assertions.assertThat(binder).isNotNull();
    }

    @Test
    public void shouldNotGetUnBoundComponentBinder() {
        // given
        BinderFactory binderFactory = injector.getInstance(BinderFactory.class);

        // when
        Binder<UnBindedComponent> binder = binderFactory.getBinderForComponentType(UnBindedComponent.class);

        // then
        Assertions.assertThat(binder).isNull();
    }
}
