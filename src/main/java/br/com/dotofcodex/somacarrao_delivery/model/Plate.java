package br.com.dotofcodex.somacarrao_delivery.model;

import java.util.List;

public class Plate {

	private Long id;
	private String name;
	private Double subtotal;
	private Pasta pasta;
	private Flavor flavor;
	private List<Sauce> sauces;
	private SauceQuantity quantity;
	private List<Ingredient> ingredients;
	private List<Seasoning> seasonings;
	private List<Extra> extras;
	private List<Drink> drinks;

	public Plate() {
		super();
	}

	public Plate(Long id, String name) {
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

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Pasta getPasta() {
		return pasta;
	}

	public void setPasta(Pasta pasta) {
		this.pasta = pasta;
	}

	public Flavor getFlavor() {
		return flavor;
	}

	public void setFlavor(Flavor flavor) {
		this.flavor = flavor;
	}

	public List<Sauce> getSauces() {
		return sauces;
	}

	public void setSauces(List<Sauce> sauces) {
		this.sauces = sauces;
	}

	public SauceQuantity getQuantity() {
		return quantity;
	}

	public void setQuantity(SauceQuantity quantity) {
		this.quantity = quantity;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Seasoning> getSeasonings() {
		return seasonings;
	}

	public void setSeasonings(List<Seasoning> seasonings) {
		this.seasonings = seasonings;
	}

	public List<Extra> getExtras() {
		return extras;
	}

	public void setExtras(List<Extra> extras) {
		this.extras = extras;
	}

	public List<Drink> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}

}
