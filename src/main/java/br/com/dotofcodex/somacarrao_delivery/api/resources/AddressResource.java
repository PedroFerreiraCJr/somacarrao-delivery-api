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

import br.com.dotofcodex.somacarrao_delivery.model.Address;

@Path("/address")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class AddressResource {

	private final static Logger logger = Logger.getLogger(AddressResource.class);

	private static final List<Address> ADDRESSES;
	static {
		ADDRESSES = new ArrayList<>();
		ADDRESSES.add(new Address(1l, "Espaguete"));
		ADDRESSES.add(new Address(2l, "Penne"));
		ADDRESSES.add(new Address(3l, "Parafuso"));
		ADDRESSES.add(new Address(4l, "Massa Integral"));
	}

	public AddressResource() {
		super();
		logger.info("AddressResource instantiated");
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(ADDRESSES).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		Address result = null;
		if (id != null) {
			for (Address address : ADDRESSES) {
				if (address.getId().equals(id)) {
					logger.info("pasta found");
					result = address;
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
