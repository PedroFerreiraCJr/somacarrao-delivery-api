package br.com.dotofcodex.somacarrao_delivery.api.resources;

import java.util.UUID;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.dotofcodex.somacarrao_delivery.model.User;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class UserResource {

	private final static Logger logger = Logger.getLogger(UserResource.class);

	public UserResource() {
		super();
		logger.info("UserResource instantiated");
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		return Response.ok().build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response create(User user) {
		logger.info("create");

		if (user != null) {
			user.setUuid(UUID.randomUUID().toString().toUpperCase());
			user.setId(null);
			user.setName(null);
			user.setSurname(null);
			user.setEmail(null);
			user.setPassword(null);
			user.setCellphone(null);
		}

		return Response.status(Response.Status.CREATED).entity(user).build();
	}
}
