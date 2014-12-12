package com.littleinfinity.libgdx.html;

import com.littleinfinity.libgdx.html.generator.Generator;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HtmlFileVisitorTest {

    private Generator generator;
    private HtmlFileVisitor htmlFileVisitor;

    @Before
    public void prepareHtmlFileVisitor() {
        generator = mock(Generator.class);
        htmlFileVisitor = new HtmlFileVisitor(generator);
    }

    @Test
    public void shouldInvokeGenerateOnValidFile() throws Exception {
        //given
        Path path = getResource("fileVisitor/some.html").toPath();
        BasicFileAttributes attrs = mock(BasicFileAttributes.class);
        when(attrs.isRegularFile()).thenReturn(true);

        //when
        htmlFileVisitor.visitFile(path, attrs);

        //then
        verify(generator, times(1)).generate(path.toFile());
    }

    private File getResource(String resourceName) {
        URL resource = getClass().getClassLoader().getResource(resourceName);
        return new File(resource.getFile());
    }

    @Test
    public void shouldNotInvokeGenerateOnInvalidFile() throws Exception {
        //given
        Path path = getResource("fileVisitor/other.txt").toPath();
        BasicFileAttributes attrs = mock(BasicFileAttributes.class);
        when(attrs.isRegularFile()).thenReturn(true);

        //when
        htmlFileVisitor.visitFile(path, attrs);

        //then
        verify(generator, times(0)).generate(path.toFile());
    }
}
