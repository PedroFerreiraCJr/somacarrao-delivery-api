package br.com.dotofcodex.somacarrao_delivery.api.resources;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import br.com.dotofcodex.somacarrao_delivery.model.Drink;

@Path("/drink")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class DrinkResource {

	private final static Logger logger = Logger.getLogger(DrinkResource.class);

	private static final List<Drink> DRINKS;
	static {
		DRINKS = new ArrayList<>();
		DRINKS.add(new Drink(1l, "Espaguete"));
		DRINKS.add(new Drink(2l, "Penne"));
		DRINKS.add(new Drink(3l, "Parafuso"));
		DRINKS.add(new Drink(4l, "Massa Integral"));
	}

	public DrinkResource() {
		super();
		logger.info("DrinkResource instantiated");
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(DRINKS).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		Drink result = null;
		if (id != null) {
			for (Drink drink : DRINKS) {
				if (drink.getId().equals(id)) {
					logger.info("pasta found");
					result = drink;
					break;
				}
			}
		}

		if (result == null) {
			logger.info("pasta not found");
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok().entity(result).build();
	}

}
