package br.com.dotofcodex.somacarrao_delivery.api.resources;

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
import br.com.dotofcodex.somacarrao_delivery.config.ContextConfig;
import br.com.dotofcodex.somacarrao_delivery.dao.FlavorDAO;
import br.com.dotofcodex.somacarrao_delivery.model.Flavor;

@Path("/flavor")
@Produces({ MediaType.APPLICATION_JSON })
@Singleton
@JWTTokenSecured
public class FlavorResource {

	private static final Logger logger = LoggerFactory.getLogger(FlavorResource.class);

	private FlavorDAO dao;

	public FlavorResource() {
		super();
		logger.info("FlavorResource instantiated");
		dao = ContextConfig.getInstance().getContext().getBean(FlavorDAO.class);
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(dao.getAll()).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		Flavor result = null;
		if (id != null) {
			for (Flavor flavor : dao.getAll()) {
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

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response create(Flavor flavor) {
		return null;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(Flavor flavor) {
		return null;
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		return null;
	}
}
