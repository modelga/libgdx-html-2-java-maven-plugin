package com.littleinfinity.libgdx.html.generator.java;

import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Sets.newHashSet;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ComplexBinderTest {

    private static ComplexBinder binder;
    private FictionalBinder fictionalBinder;
    private JavaClassSource classSource;
    private FictionalComponent fictionalComponent;

    static class FictionalComponent extends JavaSourceComponent {

    }

    static class FictionalBinder implements Binder<FictionalComponent> {

        @Override
        public void bind(JavaClassSource source, FictionalComponent component) {

        }
    }

    @Before
    public void prepareFactory() throws Exception {
        binder = new ComplexBinder();
        fictionalBinder = mock(FictionalBinder.class);
        classSource = mock(JavaClassSource.class);
        fictionalComponent = mock(FictionalComponent.class);
        binder.setFactory(new BinderFactory(newHashSet(fictionalBinder)));
    }

    @Test
    public void shouldBindFactoredBinder() throws Exception {
        // given
        ComplexComponent component = new ComplexComponent();
        component.addComponent(fictionalComponent);

        // when
        binder.bind(classSource, component);

        //then
        verify(fictionalBinder, times(1)).bind(classSource, fictionalComponent);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerOnBindingUnFactoredBinder() throws Exception {
        // given
        ComplexComponent component = new ComplexComponent();
        component.addComponent(new ComplexComponent());

        // when
        binder.bind(classSource, component);
    }
}
