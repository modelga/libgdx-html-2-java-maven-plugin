package com.littleinfinity.libgdx.html.bootstrap;

import com.littleinfinity.libgdx.html.processing.common.binding.BinderFactory;
import com.littleinfinity.libgdx.html.processing.complex.DocumentParser;
import com.littleinfinity.libgdx.html.processing.complex.ComplexComponent;
import org.apache.commons.io.IOUtils;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

public class JavaClassGenerator implements Generator {

    private BinderFactory binderFactory;
    private DocumentParser documentParser;

    @Inject
    public JavaClassGenerator(BinderFactory binderFactory, DocumentParser documentParser) {
        this.binderFactory = binderFactory;
        this.documentParser = documentParser;
    }

    @Override
    public JavaClassSource generate(File inputFile) {
        JavaClassSource source = Roaster.create(JavaClassSource.class);
        Document document = tryParseFileToDocument(inputFile);
        ComplexComponent complexComponent = tryParse(document);
        binderFactory.getBinderForComponent(complexComponent).bind(source, complexComponent);
        return source;
    }

    private ComplexComponent tryParse(Document document) {
        if (!documentParser.isAbleToParse(document)) {
            throw new IllegalStateException("Passed document is in improper state!");
        }
        return documentParser.parse(document);
    }

    private Document tryParseFileToDocument(File f) {
        Parser parser = Parser.xmlParser();
        try {
            return parser.parseInput(IOUtils.toString(f.toURI()), "");
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
