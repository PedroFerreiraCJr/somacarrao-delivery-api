package br.com.dotofcodex.somacarrao_delivery.api.resources;

import java.util.UUID;

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
import br.com.dotofcodex.somacarrao_delivery.model.Order;

@Path("/order")
@Produces({ MediaType.APPLICATION_JSON })
@Singleton
@JWTTokenSecured
public class OrderResource {

	private static final Logger logger = LoggerFactory.getLogger(OrderResource.class);

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
		if (order == null) {
			return Response.status(Status.BAD_REQUEST).entity("Pedido inválido").build();
		}

		if (order.getPlates() == null || order.getPlates().isEmpty()) {
			return Response.status(Status.BAD_REQUEST).entity("Não há pratos no pedido").build();
		}

		if (order.getUser() == null) {
			return Response.status(Status.BAD_REQUEST).entity("Usuário inválido").build();
		}
		
		if (order.getDeliveryTo() == null) {
			return Response.status(Status.BAD_REQUEST).entity("Endereço inválido").build();
		}

		if (order.getTotal() != calcOrderPrice(order)) {
			return Response.status(Status.BAD_REQUEST).entity("Usuário inválido").build();
		}

		return Response.ok().entity(UUID.randomUUID()).build();
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

	private double calcOrderPrice(Order order) {
		return .0;
	}
}
