package com.littleinfinity.libgdx.html.processing.interaction;

import com.littleinfinity.libgdx.html.processing.common.binding.Binder;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.MethodSource;

public class InteractionBinder implements Binder<InteractionComponent> {
    @Override
    public void bind(JavaClassSource source, InteractionComponent component) {

        MethodSource<JavaClassSource> method = source.addMethod();
    }
}
