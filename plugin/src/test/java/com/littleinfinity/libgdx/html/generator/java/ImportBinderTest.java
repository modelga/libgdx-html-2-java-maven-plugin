package com.littleinfinity.libgdx.html.generator.java;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ImportBinderTest {
    protected JavaClassSource source;
    private static ImportBinder binder;

    @Before
    public void beforeEachTest() {
        source = Roaster.create(JavaClassSource.class);
    }

    @BeforeClass
    public static void beforeTests() {
        binder = new ImportBinder();
    }

    @Test
    public void shouldBindImport() {
        //given
        ImportComponent component = new ImportComponent("some.pack.ClassName");

        //when
        binder.bind(source, component);

        //then
        assertThat(source.toString()).contains("import " + component.getName() + ";");
    }
}
