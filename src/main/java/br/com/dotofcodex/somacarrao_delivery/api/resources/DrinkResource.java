package br.com.dotofcodex.somacarrao_delivery.api.resources;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.dotofcodex.somacarrao_delivery.api.annotation.JWTTokenSecured;
import br.com.dotofcodex.somacarrao_delivery.model.Drink;

@Path("/drink")
@Produces({ MediaType.APPLICATION_JSON })
@Singleton
@JWTTokenSecured
public class DrinkResource {

	private static final Logger logger = LoggerFactory.getLogger(DrinkResource.class);

	private static final List<Drink> DRINKS;
	static {
		DRINKS = new ArrayList<>();
		DRINKS.add(new Drink(1l, "Maracujá"));
		DRINKS.add(new Drink(2l, "Cajá"));
		DRINKS.add(new Drink(3l, "Abacaxí"));
		DRINKS.add(new Drink(4l, "Acerola"));
		DRINKS.add(new Drink(5l, "Laranja"));
		DRINKS.add(new Drink(6l, "Limonada"));
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

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response create(Drink drink) {
		return null;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(Drink drink) {
		return null;
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		return null;
	}
}
