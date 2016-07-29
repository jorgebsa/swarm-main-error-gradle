package com.example;

import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.config.undertow.FilterConfiguration;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.undertow.UndertowFraction;

public class Main {

	private static final String GZIP_FILTER_KEY = "my-gzip";

	public static void main(String[] args) throws Exception {
		Container container = new Swarm();

		FilterConfiguration gzipFilter = new FilterConfiguration().gzip( GZIP_FILTER_KEY );
		UndertowFraction undertowFraction = UndertowFraction.createDefaultFraction();
		undertowFraction.filterConfiguration( gzipFilter )
				.subresources()
				.server("default-server")
				.subresources()
				.host("default-host")
				.filterRef( GZIP_FILTER_KEY, f -> f.predicate(
								"exists['%{o,Content-Type}'] and regex[pattern='(?:text/plain|text/html|application/xhtml+xml" +
										"|text/xml|application/xml|application/xml+rss|text/css|text/javascript|" +
										"application/x-javascript|application/javascript|text/javascript|application/json" +
										"|text/css)(;.*)?', value=%{o,Content-Type}, full-match=true]"
						)
				);

		container.fraction(undertowFraction);
		container.start();
		container.deploy();

	}

}
