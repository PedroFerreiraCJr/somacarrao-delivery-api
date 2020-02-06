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

import br.com.dotofcodex.somacarrao_delivery.model.Extra;

@Path("/extra")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class ExtraResource {

	private final static Logger logger = Logger.getLogger(ExtraResource.class);

	private static final List<Extra> EXTRAS;
	static {
		EXTRAS = new ArrayList<>();
		EXTRAS.add(new Extra(1l, "Espaguete"));
		EXTRAS.add(new Extra(2l, "Penne"));
		EXTRAS.add(new Extra(3l, "Parafuso"));
		EXTRAS.add(new Extra(4l, "Massa Integral"));
	}

	public ExtraResource() {
		super();
		logger.info("ExtraResource instantiated");
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(EXTRAS).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		Extra result = null;
		if (id != null) {
			for (Extra extra : EXTRAS) {
				if (extra.getId().equals(id)) {
					logger.info("pasta found");
					result = extra;
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
