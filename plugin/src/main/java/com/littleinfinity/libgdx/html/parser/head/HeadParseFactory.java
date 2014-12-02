package com.littleinfinity.libgdx.html.parser.head;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.generator.java.JavaSourceComponent;
import com.littleinfinity.libgdx.html.parser.HTMLTagParser;
import com.littleinfinity.libgdx.html.util.FactoryDependend;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import java.util.Set;

import static com.littleinfinity.libgdx.html.util.Reflection.isObjectImplementingSpecificGenericInterface;

@Singleton
public class HeadParseFactory {
    private Set<HTMLTagParser<? extends JavaSourceComponent>> parsers;

    @Inject
    public HeadParseFactory(Set<HTMLTagParser<? extends JavaSourceComponent>> parsers) {
        this.parsers = parsers;
        populateParsersWithFactoryReference();
    }

    private void populateParsersWithFactoryReference() {
        for (HTMLTagParser<? extends JavaSourceComponent> parser : parsers) {
            if (isObjectImplementingSpecificGenericInterface(parser, FactoryDependend.class, HeadParseFactory.class)) {
                FactoryDependend<HeadParseFactory> factoryDependend = (FactoryDependend<HeadParseFactory>) parser;
                factoryDependend.setFactory(this);
            }
        }
    }

    public <T> HTMLTagParser<T> getProperParser(String tag) {
        for (HTMLTagParser<? extends JavaSourceComponent> parser : parsers) {
            if (parser.isAbleToParse(new Element(Tag.valueOf(tag), ""))) {
                return (HTMLTagParser<T>) parser;
            }
        }
        return null;
    }
}
