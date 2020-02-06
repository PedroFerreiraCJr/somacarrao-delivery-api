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

import br.com.dotofcodex.somacarrao_delivery.model.Seasoning;

@Path("/seasoning")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class SeasoningResource {

	private final static Logger logger = Logger.getLogger(SeasoningResource.class);

	private static final List<Seasoning> SEASONINGS;
	static {
		SEASONINGS = new ArrayList<>();
		SEASONINGS.add(new Seasoning(1l, "Espaguete"));
		SEASONINGS.add(new Seasoning(2l, "Penne"));
		SEASONINGS.add(new Seasoning(3l, "Parafuso"));
		SEASONINGS.add(new Seasoning(4l, "Massa Integral"));
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

}
