package br.com.dotofcodex.somacarrao_delivery.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * More information in the following link:
 * https://www.baeldung.com/jackson-ignore-null-fields
 */

@JsonInclude(Include.NON_NULL)
public class User {

	private Long id;
	private String uuid;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String cellphone;

	public User() {
		super();
	}

	public User(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", uuid=").append(uuid).append(", name=").append(name)
				.append(", surname=").append(surname).append(", email=").append(email).append(", password=")
				.append(password).append(", cellphone=").append(cellphone).append("]");
		return builder.toString();
	}
}
