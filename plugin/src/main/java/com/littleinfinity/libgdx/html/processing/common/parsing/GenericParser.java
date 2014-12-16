package com.littleinfinity.libgdx.html.processing.common.parsing;

public interface GenericParser<ReturnType, ParsedElement> {
    ReturnType parse(ParsedElement element);

    boolean isAbleToParse(ParsedElement element);
}
