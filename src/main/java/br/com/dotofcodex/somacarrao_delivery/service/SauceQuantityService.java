package br.com.dotofcodex.somacarrao_delivery.service;

import br.com.dotofcodex.somacarrao_delivery.dao.SauceQuantityDAO;
import br.com.dotofcodex.somacarrao_delivery.exception.BusinessException;
import br.com.dotofcodex.somacarrao_delivery.model.Plate;
import br.com.dotofcodex.somacarrao_delivery.util.ValidObject;

public class SauceQuantityService implements ValidObject<Plate> {

	private SauceQuantityDAO dao;

	public SauceQuantityService() {
		super();
	}

	@Override
	public boolean exists(Plate plate) throws BusinessException {
		boolean result = dao.exists(plate.getQuantity());

		if (!result) {
			throw new BusinessException("Identificador de SauceQuantity inválido");
		}

		return true;
	}

}
