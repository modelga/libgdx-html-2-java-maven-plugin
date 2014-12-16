package com.littleinfinity.libgdx.html.processing.importing;

import com.littleinfinity.libgdx.html.processing.common.binding.Binder;
import org.jboss.forge.roaster.model.source.JavaClassSource;

public class ImportBinder implements Binder<ImportComponent> {

    public void bind(final JavaClassSource source, ImportComponent component) {
        source.addImport(component.getName());
    }
}
