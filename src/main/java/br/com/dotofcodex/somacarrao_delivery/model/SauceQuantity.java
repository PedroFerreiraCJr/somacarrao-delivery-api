package br.com.dotofcodex.somacarrao_delivery.model;

public enum SauceQuantity {

	NONE(0, "Nenhum"), LITTLE(1, "Pouco"), NORMAL(2, "Normal"), MUCH(3, "Muito");

	private int id;
	private String value;

	private SauceQuantity(int id, String value) {
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return this.id;
	}

	public String getValue() {
		return this.value;
	}

	public static SauceQuantity byId(int id) throws Exception {
		switch (id) {
			case 0: {
				return NONE;
			}
			case 1: {
				return LITTLE;
			}
			case 2: {
				return NORMAL;
			}
			case 3: {
				return MUCH;
			}
			default: {
				throw new IllegalArgumentException("SauceQuantity invalid");
			}
		}
	}
}
