package com.littleinfinity.libgdx.html.generator.java;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ComplexComponent extends JavaSourceComponent {
    private List<JavaSourceComponent> innerComponents;

    public ComplexComponent() {
        innerComponents = newArrayList();
    }

    public void addComponent(JavaSourceComponent component) {
        innerComponents.add(component);
    }

    public List<JavaSourceComponent> getAll() {
        return innerComponents;
    }
}
