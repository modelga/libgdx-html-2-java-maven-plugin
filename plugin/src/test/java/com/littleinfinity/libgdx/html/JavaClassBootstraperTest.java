package com.littleinfinity.libgdx.html;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.littleinfinity.libgdx.html.bootstrap.Config;
import com.littleinfinity.libgdx.html.bootstrap.HtmlFileVisitor;
import com.littleinfinity.libgdx.html.bootstrap.JavaClassBootstraper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class JavaClassBootstraperTest {
    private Injector injector;
    private Config config;
    private JavaClassBootstraper bootstraper;
    private Injector child;

    @Before
    public void prepareJavaClassBootstrapper() {
        injector = mock(Injector.class);
        config = mock(Config.class);
        child = mock(Injector.class);
        when(injector.createChildInjector(any(Module.class))).thenReturn(child);
        bootstraper = new JavaClassBootstraper(injector, config);
    }

    private File getResource(String resourceName) {
        URL resource = getClass().getClassLoader().getResource(resourceName);
        return new File(resource.getFile());
    }

    @Test
    public void shouldBootstrap() throws Exception {
        // given
        when(config.getSourceDir()).thenReturn(getResource("fileVisitor/"));
        HtmlFileVisitor visitor = setUpVisitor();
        when(child.getInstance(HtmlFileVisitor.class)).thenReturn(visitor);

        //when
        bootstraper.bootstrap();
        // then

        verify(config, times(1)).getSourceDir();
    }

    private HtmlFileVisitor setUpVisitor() throws IOException {
        HtmlFileVisitor visitor = mock(HtmlFileVisitor.class);
        when(visitor.visitFile(any(Path.class), any(BasicFileAttributes.class))).thenReturn(FileVisitResult.TERMINATE);
        when(visitor.preVisitDirectory(any(Path.class), any(BasicFileAttributes.class))).thenReturn(FileVisitResult.TERMINATE);
        when(visitor.postVisitDirectory(any(Path.class), any(IOException.class))).thenReturn(FileVisitResult.TERMINATE);
        when(visitor.visitFileFailed(any(Path.class), any(IOException.class))).thenReturn(FileVisitResult.TERMINATE);
        return visitor;
    }
}
