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
import br.com.dotofcodex.somacarrao_delivery.model.Sauce;

@Path("/sauce")
@Produces({ MediaType.APPLICATION_JSON })
@Singleton
@JWTTokenSecured
public class SauceResource {

	private static final Logger logger = LoggerFactory.getLogger(SauceResource.class);

	private static final List<Sauce> SAUCES;
	static {
		SAUCES = new ArrayList<>();
		SAUCES.add(new Sauce(1l, "Molho do Tomate"));
		SAUCES.add(new Sauce(2l, "Molho Branco"));
	}

	public SauceResource() {
		super();
		logger.info("SauceResource instantiated");
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(SAUCES).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		Sauce result = null;
		if (id != null) {
			for (Sauce sauce : SAUCES) {
				if (sauce.getId().equals(id)) {
					logger.info("pasta found");
					result = sauce;
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
	public Response create(Sauce sauce) {
		return null;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(Sauce sauce) {
		return null;
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		return null;
	}

}
