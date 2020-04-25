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

import br.com.dotofcodex.somacarrao_delivery.config.ContextConfig;
import br.com.dotofcodex.somacarrao_delivery.dao.DrinkDAO;
import br.com.dotofcodex.somacarrao_delivery.model.Drink;

@Path("/drink")
@Produces({ MediaType.APPLICATION_JSON })
@Singleton
//@JWTTokenSecured
public class DrinkResource {

	private static final Logger logger = LoggerFactory.getLogger(DrinkResource.class);

	private DrinkDAO dao;

	public DrinkResource() {
		super();
		logger.info("DrinkResource instantiated");
		dao = ContextConfig.getInstance().getContext().getBean(DrinkDAO.class);
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
		Drink result = null;
		if (id != null) {
			for (Drink drink : dao.getAll()) {
				if (drink.getId().equals(id)) {
					logger.info("pasta found");
					result = drink;
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
	public Response create(Drink drink) {
		return null;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(Drink drink) {
		return null;
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		return null;
	}
}
