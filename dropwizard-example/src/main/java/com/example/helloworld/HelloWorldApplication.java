package com.example.helloworld;
import com.example.helloworld.resources.HelloWorldResource;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
		super.initialize(bootstrap);
//		bootstrap.addBundle(new AssetsBundle("/assets", "/chockview/assets", null, "assets"));
	}

	@Override
    public void run(HelloWorldConfiguration configuration, Environment environment) {

        environment.jersey().register(new HelloWorldResource());
    }
}
