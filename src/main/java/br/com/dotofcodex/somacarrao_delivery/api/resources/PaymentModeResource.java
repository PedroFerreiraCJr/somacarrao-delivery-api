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

import br.com.dotofcodex.somacarrao_delivery.model.PaymentMode;

@Path("/paymentMode")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class PaymentModeResource {

	private final static Logger logger = Logger.getLogger(PaymentModeResource.class);

	private static final List<PaymentMode> PAYMENT_MODE;
	static {
		PAYMENT_MODE = new ArrayList<>();
		PAYMENT_MODE.add(new PaymentMode(1l, "Espaguete"));
		PAYMENT_MODE.add(new PaymentMode(2l, "Penne"));
		PAYMENT_MODE.add(new PaymentMode(3l, "Parafuso"));
		PAYMENT_MODE.add(new PaymentMode(4l, "Massa Integral"));
	}

	public PaymentModeResource() {
		super();
		logger.info("PaymentModeResource instantiated");
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(PAYMENT_MODE).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		PaymentMode result = null;
		if (id != null) {
			for (PaymentMode paymentMode : PAYMENT_MODE) {
				if (paymentMode.getId().equals(id)) {
					logger.info("pasta found");
					result = paymentMode;
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
