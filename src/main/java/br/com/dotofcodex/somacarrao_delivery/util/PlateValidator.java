package br.com.dotofcodex.somacarrao_delivery.util;

import br.com.dotofcodex.somacarrao_delivery.exception.BusinessException;
import br.com.dotofcodex.somacarrao_delivery.model.Plate;

public class PlateValidator {

	public void validate(Plate plate) throws BusinessException {

		if (plate.getPasta() == null) {
			throw new BusinessException("Pasta vazia");
		}

		if (plate.getFlavor() == null) {
			throw new BusinessException("Flavor vazia");
		}

		if (plate.getSauces() == null || plate.getSauces().isEmpty()) {
			throw new BusinessException("Sauce vazia");
		}

		if (plate.getQuantity() == null) {
			throw new BusinessException("SauceQuantity vazia");
		}

		if (plate.getIngredients() == null || plate.getIngredients().isEmpty()) {
			throw new BusinessException("Ingredient vazia");
		}
	}

}
