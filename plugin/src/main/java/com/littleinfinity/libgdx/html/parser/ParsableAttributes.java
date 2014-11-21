package com.littleinfinity.libgdx.html.parser;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface ParsableAttributes {
    String[] attributes();
}
