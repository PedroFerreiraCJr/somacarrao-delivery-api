package br.com.dotofcodex.somacarrao_delivery.service;

import br.com.dotofcodex.somacarrao_delivery.dao.FlavorDAO;
import br.com.dotofcodex.somacarrao_delivery.exception.BusinessException;
import br.com.dotofcodex.somacarrao_delivery.model.Plate;
import br.com.dotofcodex.somacarrao_delivery.util.ValidObject;

public class FlavorService implements ValidObject<Plate> {

	private FlavorDAO dao;

	public FlavorService() {
		super();
	}

	@Override
	public boolean exists(Plate plate) throws BusinessException {
		boolean result = dao.exists(plate.getFlavor());

		if (!result) {
			throw new BusinessException("Identificador de Flavor inválido");
		}

		return true;
	}

}
