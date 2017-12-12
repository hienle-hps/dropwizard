package com.example.helloworld.resources;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.api.Saying;
import com.google.common.base.Optional;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import io.dropwizard.jersey.caching.CacheControl;
import io.dropwizard.logging.LoggingUtil;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldResource.class);

    private final AtomicLong counter;

    public HelloWorldResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed(name = "get-requests")
    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
    	System.out.println("goes to stdout");
    	System.err.println("goes to stderr");
    	LOGGER.error("goes to log");
    	
    	String debug = "";
        ch.qos.logback.classic.Logger logger2 = LoggingUtil.getLoggerContext().getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        debug += logger2.getLevel().toString() + ": ";
        
        Iterator<Appender<ILoggingEvent>> it = logger2.iteratorForAppenders();
        while (it.hasNext()) {
			Appender<ch.qos.logback.classic.spi.ILoggingEvent> appender = (Appender<ch.qos.logback.classic.spi.ILoggingEvent>) it
					.next();
			debug += " " + appender.toString();
		}
        
        debug += System.out + " ";
        debug += System.err + " ";
        
        return new Saying(counter.incrementAndGet(), String.format("Hello %s", debug));
    }
}
