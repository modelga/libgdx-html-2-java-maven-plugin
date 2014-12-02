package com.littleinfinity.libgdx.html.parser.head;

import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.generator.java.ImportComponent;
import com.littleinfinity.libgdx.html.generator.java.JavaSourceComponent;
import com.littleinfinity.libgdx.html.parser.AnnotatedHTMLTagParser;
import com.littleinfinity.libgdx.html.parser.HTMLTagParser;
import com.littleinfinity.libgdx.html.parser.ParsableTags;
import com.littleinfinity.libgdx.html.util.FactoryDependend;
import org.jsoup.nodes.Element;

@Singleton
@ParsableTags(tags = {"head"})
public class HeadParser extends AnnotatedHTMLTagParser<JavaSourceComponent> implements FactoryDependend<HeadParseFactory> {

    private HeadParseFactory factory;

    @Override
    public JavaSourceComponent parse(Element element) {
        HTMLTagParser<ImportComponent> parser = factory.getProperParser("");
        return null;
    }

    @Override
    public void setFactory(HeadParseFactory factory) {
        this.factory = factory;
    }
}
