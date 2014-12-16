package com.littleinfinity.libgdx.html.processing.constant;

import com.google.inject.Singleton;
import com.littleinfinity.libgdx.html.processing.common.joint.JavaSourceComponent;
import com.littleinfinity.libgdx.html.processing.common.parsing.AnnotatedHTMLTagParser;
import com.littleinfinity.libgdx.html.processing.common.parsing.ParsableTags;
import org.jsoup.nodes.Element;

@Singleton
@ParsableTags(tags = {"const"})
public class ConstParser extends AnnotatedHTMLTagParser<JavaSourceComponent> {

    @Override
    public JavaSourceComponent parse(Element element) {
        return null;
    }
}
