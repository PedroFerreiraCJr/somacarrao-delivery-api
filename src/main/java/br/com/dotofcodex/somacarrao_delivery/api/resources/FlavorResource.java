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

import br.com.dotofcodex.somacarrao_delivery.model.Flavor;

@Path("/flavor")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class FlavorResource {

	private final static Logger logger = Logger.getLogger(FlavorResource.class);

	private static final List<Flavor> FLAVORS;
	static {
		FLAVORS = new ArrayList<>();
		FLAVORS.add(new Flavor(1l, "Espaguete"));
		FLAVORS.add(new Flavor(2l, "Penne"));
		FLAVORS.add(new Flavor(3l, "Parafuso"));
		FLAVORS.add(new Flavor(4l, "Massa Integral"));
	}

	public FlavorResource() {
		super();
		logger.info("SimpleResource instantiated");
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(FLAVORS).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		Flavor result = null;
		if (id != null) {
			for (Flavor flavor : FLAVORS) {
				if (flavor.getId().equals(id)) {
					logger.info("pasta found");
					result = flavor;
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
