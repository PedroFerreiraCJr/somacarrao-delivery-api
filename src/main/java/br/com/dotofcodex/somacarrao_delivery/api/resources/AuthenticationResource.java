package br.com.dotofcodex.somacarrao_delivery.api.resources;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

import br.com.dotofcodex.somacarrao_delivery.model.Auth;
import br.com.dotofcodex.somacarrao_delivery.service.AuthenticationService;

/**
 * More information in the following link:
 * 	https://www.baeldung.com/java-uuid
 */

@Path("/auth")
@Produces({ MediaType.APPLICATION_JSON })
@Singleton
public class AuthenticationResource {

	private final static Logger logger = Logger.getLogger(AuthenticationResource.class);

	@Context
	private UriInfo uriInfo;
	
	private AuthenticationService service;
	
	public AuthenticationResource() {
		super();
		this.service = new AuthenticationService();
		logger.info("AuthenticationResource instantiated");
	}

	@GET
	@Path("/translate/{token}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getById(@PathParam("token") String token) {
		if (token == null || token.isEmpty()) {
			Response.ok().entity(Response.Status.BAD_REQUEST).build();
		}
		
		return Response.ok().entity(service.parseJwtToken(token)).build();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response issue(Auth authentication) {
		logger.info(authentication.toString());
		
		if (authentication != null) {
			String uuid = authentication.getUuid();
			if ("B9828066-B1E1-4AFD-B55B-E3E2994CE558".equals(uuid)) {
				return Response.ok().entity(new AuthenticationService().issueJwtToken(authentication, uriInfo.getAbsolutePath().toString())).build();				
			}
		}
		
		return Response.status(Response.Status.BAD_REQUEST).build();
	}
}
