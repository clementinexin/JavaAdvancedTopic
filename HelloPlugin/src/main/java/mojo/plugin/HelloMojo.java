package mojo.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Created by daijiajia on 16/7/29.
 */
@Mojo(name = "greet")
public class HelloMojo extends AbstractMojo {


    @Parameter(property = "sayhi.greeting", defaultValue = "Hello World!")
    private String greeting;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Hello maven");
    }
}
