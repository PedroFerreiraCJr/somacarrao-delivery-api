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
import br.com.dotofcodex.somacarrao_delivery.model.SauceQuantity;

@Path("/sauceQuantity")
@Produces({ MediaType.APPLICATION_JSON })
@Singleton
@JWTTokenSecured
public class SauceQuantityResource {

	private final static Logger logger = Logger.getLogger(SauceQuantityResource.class);

	private static final List<SauceQuantity> SAUCE_QUANTITIES;
	static {
		SAUCE_QUANTITIES = new ArrayList<SauceQuantity>();
		SAUCE_QUANTITIES.add(new SauceQuantity(1l, "Pouco"));
		SAUCE_QUANTITIES.add(new SauceQuantity(2l, "Normal"));
		SAUCE_QUANTITIES.add(new SauceQuantity(3l, "Muito"));
	}

	public SauceQuantityResource() {
		super();
		logger.info("SimpleResource instantiated");
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(SAUCE_QUANTITIES).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		SauceQuantity result = null;
		if (id != null) {
			for (SauceQuantity suauceQuantity : SAUCE_QUANTITIES) {
				if (suauceQuantity.equals(id)) {
					logger.info("pasta found");
					result = suauceQuantity;
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
	public Response create(SauceQuantity sauceQuantity) {
		return null;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(SauceQuantity sauceQuantity) {
		return null;
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		return null;
	}

}
