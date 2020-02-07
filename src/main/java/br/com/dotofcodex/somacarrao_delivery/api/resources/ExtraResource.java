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
import br.com.dotofcodex.somacarrao_delivery.model.Extra;

@Path("/extra")
@Produces({ MediaType.APPLICATION_JSON })
@Singleton
@JWTTokenSecured
public class ExtraResource {

	private final static Logger logger = Logger.getLogger(ExtraResource.class);

	private static final List<Extra> EXTRAS;
	static {
		EXTRAS = new ArrayList<>();
		EXTRAS.add(new Extra(1l, "Bacon"));
		EXTRAS.add(new Extra(2l, "Calabresa"));
		EXTRAS.add(new Extra(3l, "Presunto"));
		EXTRAS.add(new Extra(4l, "Salsicha"));
		EXTRAS.add(new Extra(5l, "Mussarela"));
		EXTRAS.add(new Extra(6l, "Frango"));
		EXTRAS.add(new Extra(7l, "Carne do Sol"));
		EXTRAS.add(new Extra(8l, "Carne Moída"));
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

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response create(Extra extra) {
		return null;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(Extra extra) {
		return null;
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		return null;
	}
}
