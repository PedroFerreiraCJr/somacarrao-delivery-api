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

import br.com.dotofcodex.somacarrao_delivery.api.annotation.JWTTokenSecured;
import br.com.dotofcodex.somacarrao_delivery.model.Pasta;

@Path("/pasta")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
@JWTTokenSecured
public class PastaResource {

	private final static Logger logger = Logger.getLogger(PastaResource.class);

	private static final List<Pasta> PASTAS;
	static {
		PASTAS = new ArrayList<Pasta>();
		PASTAS.add(new Pasta(1l, "Espaguete"));
		PASTAS.add(new Pasta(2l, "Penne"));
		PASTAS.add(new Pasta(3l, "Parafuso"));
		PASTAS.add(new Pasta(4l, "Massa Integral"));
	}

	public PastaResource() {
		super();
		logger.info("SimpleResource instantiated");
	}

	@GET
	public Response getAll() {
		logger.info("getAll");
		return Response.ok().entity(PASTAS).build();
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		logger.info("getById");
		Pasta result = null;
		if (id != null) {
			for (Pasta pasta : PASTAS) {
				if (pasta.getId().equals(id)) {
					logger.info("pasta found");
					result = pasta;
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
