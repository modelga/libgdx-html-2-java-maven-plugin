package com.littleinfinity.libgdx.html.mojo;

import com.google.inject.Injector;
import com.littleinfinity.libgdx.html.Bootstraper;
import com.littleinfinity.libgdx.html.cdi.ModuleConfigurer;
import com.littleinfinity.libgdx.html.mojo.parameters.Input;
import com.littleinfinity.libgdx.html.mojo.parameters.Target;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.IOException;

@Mojo(name = "generate")
public class GenerateMojo extends AbstractMojo {

    @Parameter
    private Input input;

    @Parameter
    private Target target;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            bootstrap();
        } catch (IOException e) {
            throw (new MojoFailureException("Cannot bootstrap plugin", e));
        }
    }

    private void bootstrap() throws IOException {
        Injector injector = ModuleConfigurer.getInjector(input, target);
        Bootstraper bootstraper = injector.getInstance(input.getBootstraper());
        bootstraper.bootstrap();
    }
}
