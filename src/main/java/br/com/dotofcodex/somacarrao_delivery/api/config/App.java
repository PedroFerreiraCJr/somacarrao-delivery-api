package br.com.dotofcodex.somacarrao_delivery.api.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.dotofcodex.somacarrao_delivery.api.filters.CorsFilter;
import br.com.dotofcodex.somacarrao_delivery.api.filters.LoggingFilter;
import br.com.dotofcodex.somacarrao_delivery.api.resources.AddressResource;
import br.com.dotofcodex.somacarrao_delivery.api.resources.DrinkResource;
import br.com.dotofcodex.somacarrao_delivery.api.resources.ExtraResource;
import br.com.dotofcodex.somacarrao_delivery.api.resources.FlavorResource;
import br.com.dotofcodex.somacarrao_delivery.api.resources.IngredientResource;
import br.com.dotofcodex.somacarrao_delivery.api.resources.OrderResource;
import br.com.dotofcodex.somacarrao_delivery.api.resources.PastaResource;
import br.com.dotofcodex.somacarrao_delivery.api.resources.PaymentModeResource;
import br.com.dotofcodex.somacarrao_delivery.api.resources.PlateResource;
import br.com.dotofcodex.somacarrao_delivery.api.resources.SauceQuantityResource;
import br.com.dotofcodex.somacarrao_delivery.api.resources.SauceResource;
import br.com.dotofcodex.somacarrao_delivery.api.resources.SeasoningResource;
import br.com.dotofcodex.somacarrao_delivery.api.resources.UserResource;

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
		classes.add(FlavorResource.class);
		classes.add(SauceResource.class);
		classes.add(SauceQuantityResource.class);
		classes.add(IngredientResource.class);
		classes.add(SeasoningResource.class);
		classes.add(ExtraResource.class);
		classes.add(DrinkResource.class);
		classes.add(PaymentModeResource.class);
		classes.add(PlateResource.class);
		classes.add(OrderResource.class);
		classes.add(AddressResource.class);
		classes.add(UserResource.class);

		return classes;
	}

}
