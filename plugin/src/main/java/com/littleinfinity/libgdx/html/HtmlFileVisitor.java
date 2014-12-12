package com.littleinfinity.libgdx.html;

import com.google.common.io.Files;
import com.google.inject.Inject;
import com.littleinfinity.libgdx.html.generator.Generator;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class HtmlFileVisitor extends SimpleFileVisitor<Path> {
    private Generator generator;

    @Inject
    public HtmlFileVisitor(Generator generator) {
        this.generator = generator;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String extension = Files.getFileExtension(file.toFile().getName());
        if (isRegularHTMLFile(attrs, extension)) {
            generator.generate(file.toFile());
        }
        return FileVisitResult.CONTINUE;
    }

    private boolean isRegularHTMLFile(BasicFileAttributes attrs, String extension) {
        return extension.equals("html") && attrs.isRegularFile();
    }
}
