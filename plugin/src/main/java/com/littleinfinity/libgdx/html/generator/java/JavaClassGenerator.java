package com.littleinfinity.libgdx.html.generator.java;

import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.generator.Generator;
import com.littleinfinity.libgdx.html.parser.DocumentParser;
import org.apache.commons.io.IOUtils;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

@Singleton
public class JavaClassGenerator implements Generator {

    private BinderFactory binderFactory;
    private DocumentParser documentParser;

    @Inject
    public JavaClassGenerator(BinderFactory binderFactory, DocumentParser documentParser) {
        this.binderFactory = binderFactory;
        this.documentParser = documentParser;
    }

    @Override
    public JavaClassSource generate(File f) {
        JavaClassSource source = Roaster.create(JavaClassSource.class);
        Document document = tryParseDocument(f);
        ComplexComponent component = documentParser.parse(document);
        return source;
    }

    private Document tryParseDocument(File f) {
        Parser parser = Parser.xmlParser();
        try {
            return parser.parseInput(IOUtils.toString(f.toURI()), "");
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
