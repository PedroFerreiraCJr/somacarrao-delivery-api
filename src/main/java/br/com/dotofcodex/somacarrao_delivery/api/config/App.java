package br.com.dotofcodex.somacarrao_delivery.api.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.dotofcodex.somacarrao_delivery.api.filters.CorsFilter;
import br.com.dotofcodex.somacarrao_delivery.api.filters.LoggingFilter;
import br.com.dotofcodex.somacarrao_delivery.api.resources.PastaResource;

@ApplicationPath("/api")
public class App extends Application {

	public App() {
		super();
	}

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(LoggingFilter.class);
		classes.add(CorsFilter.class);

		classes.add(PastaResource.class);

		return classes;
	}

}
