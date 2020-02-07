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
import br.com.dotofcodex.somacarrao_delivery.model.Seasoning;

@Path("/seasoning")
@Produces({ MediaType.APPLICATION_JSON })
@Singleton
@JWTTokenSecured
public class SeasoningResource {

	private final static Logger logger = Logger.getLogger(SeasoningResource.class);

	private static final List<Seasoning> SEASONINGS;
	static {
		SEASONINGS = new ArrayList<>();
		SEASONINGS.add(new Seasoning(1l, "Batata Palha"));
		SEASONINGS.add(new Seasoning(2l, "Orégano"));
		SEASONINGS.add(new Seasoning(3l, "Ovo de Codorna"));
		SEASONINGS.add(new Seasoning(4l, "Mussarela"));
		SEASONINGS.add(new Seasoning(5l, "Queijo Ralado"));
		SEASONINGS.add(new Seasoning(6l, "Cheiro Verde"));
		SEASONINGS.add(new Seasoning(7l, "Pimentão de Bico"));
	}

	public SeasoningResource() {
		super();
		logger.info("SeasoningResource instantiated");
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(SEASONINGS).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		Seasoning result = null;
		if (id != null) {
			for (Seasoning seasoning : SEASONINGS) {
				if (seasoning.getId().equals(id)) {
					logger.info("pasta found");
					result = seasoning;
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
	public Response create(Seasoning seasoning) {
		return null;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(Seasoning seasoning) {
		return null;
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		return null;
	}
}
