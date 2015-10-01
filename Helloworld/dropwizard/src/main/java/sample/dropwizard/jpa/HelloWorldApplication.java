package sample.dropwizard.jpa;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import sample.dropwizard.jpa.resources.HelloworldResource;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
    }

    @Override
    public void run(final HelloWorldConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new HelloworldResource());
    }


}
