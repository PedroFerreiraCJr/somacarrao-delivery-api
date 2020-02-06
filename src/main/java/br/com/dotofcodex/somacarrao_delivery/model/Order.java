package br.com.dotofcodex.somacarrao_delivery.model;

public class Order {

	private Long id;

	public Order() {
		super();
	}

	public Order(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
