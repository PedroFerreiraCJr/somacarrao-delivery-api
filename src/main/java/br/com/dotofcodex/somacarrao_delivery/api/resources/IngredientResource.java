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

import org.apache.log4j.Logger;

import br.com.dotofcodex.somacarrao_delivery.api.annotation.JWTTokenSecured;
import br.com.dotofcodex.somacarrao_delivery.model.Ingredient;

@Path("/ingredient")
@Produces({ MediaType.APPLICATION_JSON })
@Singleton
@JWTTokenSecured
public class IngredientResource {

	private final static Logger logger = Logger.getLogger(IngredientResource.class);

	private static final List<Ingredient> INGREDIENTS;
	static {
		INGREDIENTS = new ArrayList<>();
		INGREDIENTS.add(new Ingredient(1l, "Bacon"));
		INGREDIENTS.add(new Ingredient(2l, "Cebola"));
		INGREDIENTS.add(new Ingredient(3l, "Tomate"));
		INGREDIENTS.add(new Ingredient(4l, "Pimentão"));
		INGREDIENTS.add(new Ingredient(5l, "Alho"));
		INGREDIENTS.add(new Ingredient(6l, "Azeitona"));
		INGREDIENTS.add(new Ingredient(7l, "Uva Passa"));
		INGREDIENTS.add(new Ingredient(8l, "Milho Verde"));
		INGREDIENTS.add(new Ingredient(9l, "Mussarela"));
		INGREDIENTS.add(new Ingredient(10l, "Queijo Ralado"));
		INGREDIENTS.add(new Ingredient(11l, "Cheiro Verde"));
	}

	public IngredientResource() {
		super();
		logger.info("IngredientResource instantiated");
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(INGREDIENTS).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		Ingredient result = null;
		if (id != null) {
			for (Ingredient ingredient : INGREDIENTS) {
				if (ingredient.getId().equals(id)) {
					logger.info("pasta found");
					result = ingredient;
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
	public Response create(Ingredient ingredient) {
		return null;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(Ingredient ingredient) {
		return null;
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		return null;
	}
}
