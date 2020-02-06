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

import br.com.dotofcodex.somacarrao_delivery.model.User;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class UserResource {

	private final static Logger logger = Logger.getLogger(UserResource.class);

	private static final List<User> USERS;
	static {
		USERS = new ArrayList<>();
		USERS.add(new User(1l, "Pedro Ferreira", "pedroferreiracjr@gmil.com"));
		USERS.add(new User(2l, "Maisa Oliveira", "maisaoliveira161@gmail.com"));
	}

	public UserResource() {
		super();
		logger.info("UserResource instantiated");
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(USERS).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		User result = null;
		if (id != null) {
			for (User user : USERS) {
				if (user.getId().equals(id)) {
					logger.info("pasta found");
					result = user;
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
