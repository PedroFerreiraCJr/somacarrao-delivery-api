package br.com.dotofcodex.somacarrao_delivery.service;

import java.time.LocalDateTime;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.dotofcodex.somacarrao_delivery.model.Auth;
import br.com.dotofcodex.somacarrao_delivery.util.DateTimeUtil;
import br.com.dotofcodex.somacarrao_delivery.util.KeyGeneratorUtil;
import io.jsonwebtoken.Jwts;

public class AuthenticationService {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	
	public AuthenticationService() {
		super();
	}
	
	public String issueJwtToken(Auth authentication, String url) {
		return
		Jwts
			.builder()
	        .setSubject(authentication.getUuid())
	        .setIssuer(url)
	        .setIssuedAt(new Date())
	        .setExpiration(DateTimeUtil.toDate(LocalDateTime.now().plusMinutes(5l)))
	        .signWith(KeyGeneratorUtil.getAES())
	        .compact();
	}
	
	public String parseJwtToken(String jwtToken) {
		return
		Jwts
			.parser()
			.setSigningKey(KeyGeneratorUtil.getAES())
			.parseClaimsJws(jwtToken)
			.getBody()
			.toString();
    }
}
