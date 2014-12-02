package com.littleinfinity.libgdx.html.parser;

public interface GenericParser<ReturnType, ParsedElement> {
    ReturnType parse(ParsedElement element);

    boolean isAbleToParse(ParsedElement element);
}
