package br.com.dotofcodex.somacarrao_delivery.api.mapper;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * More information in the following link:
 * https://dennis-xlc.gitbooks.io/restful-java-with-jax-rs-2-0-en/cn/part1/chapter7/exception_handling.html
 */

@Provider
public class UnauthorizedMapper implements ExceptionMapper<NotAuthorizedException> {

	private static final Logger logger = LoggerFactory.getLogger(UnauthorizedMapper.class);

	@Override
	public Response toResponse(NotAuthorizedException exception) {
		logger.info("begin unauthorized mapper exception begin");
		Response build = Response.status(Response.Status.UNAUTHORIZED)
				.entity("Acesso ao recurso não autorizado").build();
		logger.info("begin unauthorized mapper exception begin");
		return build;
	}
}
