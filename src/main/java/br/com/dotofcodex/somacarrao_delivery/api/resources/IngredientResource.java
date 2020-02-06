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

import br.com.dotofcodex.somacarrao_delivery.model.Ingredient;

@Path("/ingredient")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class IngredientResource {

	private final static Logger logger = Logger.getLogger(IngredientResource.class);

	private static final List<Ingredient> INGREDIENTS;
	static {
		INGREDIENTS = new ArrayList<>();
		INGREDIENTS.add(new Ingredient(1l, "Espaguete"));
		INGREDIENTS.add(new Ingredient(2l, "Penne"));
		INGREDIENTS.add(new Ingredient(3l, "Parafuso"));
		INGREDIENTS.add(new Ingredient(4l, "Massa Integral"));
	}

	public IngredientResource() {
		super();
		logger.info("SimpleResource instantiated");
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

}
