package sample.dropwizard.jpa;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import sample.dropwizard.jpa.db.UserDAO;
import sample.dropwizard.jpa.model.User;
import sample.dropwizard.jpa.resources.UserResource;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    private final HibernateBundle<HelloWorldConfiguration> hibernateBundle =
            new HibernateBundle<HelloWorldConfiguration>(User.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };


    public static void main(final String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(final Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<HelloWorldConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final HelloWorldConfiguration configuration,
                    final Environment environment) {
        final UserDAO dao = new UserDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new UserResource(dao));
    }


}
