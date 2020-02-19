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
import br.com.dotofcodex.somacarrao_delivery.model.Order;

@Path("/order")
@Produces({ MediaType.APPLICATION_JSON })
@Singleton
@JWTTokenSecured
public class OrderResource {

	private final static Logger logger = Logger.getLogger(OrderResource.class);

	private static final List<Order> ORDERS;
	static {
		ORDERS = new ArrayList<>();
	}

	public OrderResource() {
		super();
		logger.info("OrderResource instantiated");
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		return Response.ok().build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response create(Order order) {
		return null;
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(Order order) {
		return null;
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		return null;
	}
}
