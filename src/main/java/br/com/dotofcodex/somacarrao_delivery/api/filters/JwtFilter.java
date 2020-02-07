package br.com.dotofcodex.somacarrao_delivery.api.filters;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import br.com.dotofcodex.somacarrao_delivery.api.annotation.JWTTokenSecured;
import br.com.dotofcodex.somacarrao_delivery.util.KeyGeneratorUtil;
import io.jsonwebtoken.Jwts;

@Provider
@Priority(Priorities.AUTHENTICATION)
@JWTTokenSecured
public class JwtFilter implements ContainerRequestFilter {

	private final static Logger logger = Logger.getLogger(JwtFilter.class);
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		logger.info("new request");
		
		try {
			String token = getTokenFromHeader(requestContext);
			
			Jwts
				.parser()
				.setSigningKey(KeyGeneratorUtil.getAES())
				.parseClaimsJws(token);
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
			throw new NotAuthorizedException(Response.status(Response.Status.UNAUTHORIZED).build());
			//requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}

	private String getTokenFromHeader(ContainerRequestContext requestContext) {
		return requestContext.getHeaderString(HttpHeaders.AUTHORIZATION).substring("Bearer".length()).trim();
	}
}
