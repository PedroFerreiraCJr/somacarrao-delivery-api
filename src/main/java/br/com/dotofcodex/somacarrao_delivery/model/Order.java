package br.com.dotofcodex.somacarrao_delivery.model;

import java.util.List;

public class Order {

	private Long id;
	private String uuid;
	private List<Plate> plates;
	private User user;
	private Address deliveryTo;
	private PaymentMode paymentMode;
	private Double total;

	public Order() {
		super();
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

	public List<Plate> getPlates() {
		return plates;
	}

	public void setPlates(List<Plate> plates) {
		this.plates = plates;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getDeliveryTo() {
		return deliveryTo;
	}

	public void setDeliveryTo(Address deliveryTo) {
		this.deliveryTo = deliveryTo;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
