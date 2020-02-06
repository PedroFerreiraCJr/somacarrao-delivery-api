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

import br.com.dotofcodex.somacarrao_delivery.model.Plate;

@Path("/plate")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class PlateResource {

	private final static Logger logger = Logger.getLogger(PlateResource.class);

	private static final List<Plate> PLATES;
	static {
		PLATES = new ArrayList<>();
		PLATES.add(new Plate(1l, "Espaguete"));
		PLATES.add(new Plate(2l, "Penne"));
		PLATES.add(new Plate(3l, "Parafuso"));
		PLATES.add(new Plate(4l, "Massa Integral"));
	}

	public PlateResource() {
		super();
		logger.info("PlateResource instantiated");
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(PLATES).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		Plate result = null;
		if (id != null) {
			for (Plate plate : PLATES) {
				if (plate.getId().equals(id)) {
					logger.info("pasta found");
					result = plate;
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
