package br.com.dotofcodex.somacarrao_delivery.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * More information in the following link:
 * https://www.baeldung.com/jackson-ignore-null-fields
 */

@JsonInclude(Include.NON_NULL)
public class Auth {

	private Long id;
	private String uuid;
	private String email;
	private String password;

	@JsonProperty("access_token")
	private String accessToken;

	public Auth() {
		super();
	}

	public Auth(Long id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Auth [id=").append(id).append(", uuid=").append(uuid).append(", email=").append(email)
				.append(", password=").append(password).append(", accessToken=").append(accessToken).append("]");
		return builder.toString();
	}

}
