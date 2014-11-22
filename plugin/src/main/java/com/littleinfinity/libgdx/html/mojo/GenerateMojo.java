package com.littleinfinity.libgdx.html.mojo;

import com.littleinfinity.libgdx.html.mojo.parameters.Input;
import com.littleinfinity.libgdx.html.mojo.parameters.Target;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "generate")
public class GenerateMojo extends AbstractMojo {

    @Parameter
    private Input input;

    @Parameter
    private Target target;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

    }
}
