package br.com.dotofcodex.somacarrao_delivery.service;

import br.com.dotofcodex.somacarrao_delivery.dao.DrinkDAO;
import br.com.dotofcodex.somacarrao_delivery.exception.BusinessException;
import br.com.dotofcodex.somacarrao_delivery.model.Drink;
import br.com.dotofcodex.somacarrao_delivery.model.Plate;
import br.com.dotofcodex.somacarrao_delivery.util.ValidObject;

public class DrinkService implements ValidObject<Plate> {

	private DrinkDAO dao;

	public DrinkService() {
		super();
	}

	@Override
	public boolean exists(Plate plate) throws BusinessException {
		for (Drink drink : plate.getDrinks()) {
			if (!dao.exists(drink)) {
				throw new BusinessException("Identificador de Drink inválido");
			}
		}

		return true;
	}

}
