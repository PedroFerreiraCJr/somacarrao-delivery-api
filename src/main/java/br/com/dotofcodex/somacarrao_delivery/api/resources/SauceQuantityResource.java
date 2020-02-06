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

import br.com.dotofcodex.somacarrao_delivery.model.SauceQuantity;

@Path("/sauceQuantity")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class SauceQuantityResource {

	private final static Logger logger = Logger.getLogger(SauceQuantityResource.class);

	private static final List<SauceQuantity> SAUCE_QUANTITIES;
	static {
		SAUCE_QUANTITIES = new ArrayList<SauceQuantity>();
		SAUCE_QUANTITIES.add(SauceQuantity.NONE);
		SAUCE_QUANTITIES.add(SauceQuantity.LITTLE);
		SAUCE_QUANTITIES.add(SauceQuantity.NORMAL);
		SAUCE_QUANTITIES.add(SauceQuantity.MUCH);
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

}
