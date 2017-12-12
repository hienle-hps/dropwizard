package com.example.gcp;

import com.fasterxml.jackson.annotation.JsonTypeName;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.Context;
import io.dropwizard.logging.ConsoleAppenderFactory;

@JsonTypeName("gaeconsole")
public class GaeConsoleAppenderFactory extends ConsoleAppenderFactory {

	/**
	 * No Async.  GAE does not likey.
	 */
	@Override
	protected Appender<ILoggingEvent> wrapAsync(Appender<ILoggingEvent> appender, Context context) {
		return appender;
	}

}
