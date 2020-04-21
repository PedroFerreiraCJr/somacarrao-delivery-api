package br.com.dotofcodex.somacarrao_delivery.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.dotofcodex.somacarrao_delivery.dao.FlavorDAO;
import br.com.dotofcodex.somacarrao_delivery.exception.BusinessException;
import br.com.dotofcodex.somacarrao_delivery.model.Plate;
import br.com.dotofcodex.somacarrao_delivery.util.ValidObject;

public class FlavorService implements ValidObject<Plate> {

	private static final Logger logger = LoggerFactory.getLogger(FlavorService.class);
	
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
