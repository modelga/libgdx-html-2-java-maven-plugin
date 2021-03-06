package com.littleinfinity.libgdx.html.parser;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.generator.java.JavaSourceComponent;
import com.littleinfinity.libgdx.html.util.AbstractPopulatingFactory;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import java.util.Set;

@Singleton
public class ParserFactory extends AbstractPopulatingFactory {
    private Set<HTMLTagParser<? extends JavaSourceComponent>> parsers;

    @Inject
    public ParserFactory(Set<HTMLTagParser<? extends JavaSourceComponent>> parsers) {
        this.parsers = parsers;
        populateFactoryDependantWithFactoryReference(parsers);
    }

    public <T extends JavaSourceComponent> HTMLTagParser<T> getProperParser(String tag) {
        for (HTMLTagParser<? extends JavaSourceComponent> parser : parsers) {
            if (parser.isAbleToParse(new Element(Tag.valueOf(tag), ""))) {
                return (HTMLTagParser<T>) parser;
            }
        }
        return null;
    }
}
