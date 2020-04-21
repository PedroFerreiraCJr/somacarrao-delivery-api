package br.com.dotofcodex.somacarrao_delivery.api.mapper;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * More information in the following link:
 * 	https://dennis-xlc.gitbooks.io/restful-java-with-jax-rs-2-0-en/cn/part1/chapter7/exception_handling.html
 */

@Provider
public class UnauthorizedMapper implements ExceptionMapper<NotAuthorizedException> {

	@Override
	public Response toResponse(NotAuthorizedException exception) {
		return Response.status(Response.Status.UNAUTHORIZED).entity("O Pedro disse que você não está autorizado para acessar o recurso").build();
	}
}
