package com.example.gcp;

import javax.servlet.annotation.WebListener;

import com.example.helloworld.HelloWorldApplication;
import com.example.helloworld.HelloWorldConfiguration;

import be.fluid_it.tools.dropwizard.box.WebApplication;

@WebListener
public class AppEngine extends WebApplication<HelloWorldConfiguration> {

	public AppEngine() {
		super(new HelloWorldApplication(), "gae.yml");
	}

}
