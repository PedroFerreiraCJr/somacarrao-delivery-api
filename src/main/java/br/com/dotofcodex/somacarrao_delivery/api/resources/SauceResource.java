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

import br.com.dotofcodex.somacarrao_delivery.model.Sauce;

@Path("/sauce")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class SauceResource {

	private final static Logger logger = Logger.getLogger(SauceResource.class);

	private static final List<Sauce> SAUCES;
	static {
		SAUCES = new ArrayList<>();
		SAUCES.add(new Sauce(1l, "Espaguete"));
		SAUCES.add(new Sauce(2l, "Penne"));
		SAUCES.add(new Sauce(3l, "Parafuso"));
		SAUCES.add(new Sauce(4l, "Massa Integral"));
	}

	public SauceResource() {
		super();
		logger.info("SimpleResource instantiated");
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

}
