package br.com.dotofcodex.somacarrao_delivery.model;

public class PaymentMode {

	private Long id;
	private String name;
	private String description;

	public PaymentMode() {
		super();
	}

	public PaymentMode(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
