package br.com.dotofcodex.somacarrao_delivery.service;

import br.com.dotofcodex.somacarrao_delivery.dao.SeasoningDAO;
import br.com.dotofcodex.somacarrao_delivery.exception.BusinessException;
import br.com.dotofcodex.somacarrao_delivery.model.Plate;
import br.com.dotofcodex.somacarrao_delivery.model.Seasoning;
import br.com.dotofcodex.somacarrao_delivery.util.ValidObject;

public class SeasoningService implements ValidObject<Plate> {

	private SeasoningDAO dao;

	public SeasoningService() {
		super();
	}

	@Override
	public boolean exists(Plate plate) throws BusinessException {
		for (Seasoning seasoning : plate.getSeasonings()) {
			if (!dao.exists(seasoning)) {
				throw new BusinessException("Identificador de Seasoning inválido");
			}
		}

		return true;
	}

}
