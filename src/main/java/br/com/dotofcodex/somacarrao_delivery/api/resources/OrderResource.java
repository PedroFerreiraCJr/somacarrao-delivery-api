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

import br.com.dotofcodex.somacarrao_delivery.model.Order;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class OrderResource {

	private final static Logger logger = Logger.getLogger(OrderResource.class);

	private static final List<Order> ORDERS;
	static {
		ORDERS = new ArrayList<>();
		ORDERS.add(new Order(1l));
		ORDERS.add(new Order(2l));
		ORDERS.add(new Order(3l));
		ORDERS.add(new Order(4l));
	}

	public OrderResource() {
		super();
		logger.info("OrderResource instantiated");
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(ORDERS).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		Order result = null;
		if (id != null) {
			for (Order order : ORDERS) {
				if (order.getId().equals(id)) {
					logger.info("pasta found");
					result = order;
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
