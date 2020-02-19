package br.com.dotofcodex.somacarrao_delivery.service;

import br.com.dotofcodex.somacarrao_delivery.dao.IngredientDAO;
import br.com.dotofcodex.somacarrao_delivery.exception.BusinessException;
import br.com.dotofcodex.somacarrao_delivery.model.Ingredient;
import br.com.dotofcodex.somacarrao_delivery.model.Plate;
import br.com.dotofcodex.somacarrao_delivery.util.ValidObject;

public class IngredientService implements ValidObject<Plate> {

	private IngredientDAO dao;

	public IngredientService() {
		super();
	}

	@Override
	public boolean exists(Plate plate) throws BusinessException {
		for (Ingredient ingredient : plate.getIngredients()) {
			if (!dao.exists(ingredient)) {
				throw new BusinessException("Identificador de Ingredient inválido");
			}
		}

		return true;
	}

}
