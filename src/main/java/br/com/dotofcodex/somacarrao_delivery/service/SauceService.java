package br.com.dotofcodex.somacarrao_delivery.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.dotofcodex.somacarrao_delivery.dao.SauceDAO;
import br.com.dotofcodex.somacarrao_delivery.exception.BusinessException;
import br.com.dotofcodex.somacarrao_delivery.model.Plate;
import br.com.dotofcodex.somacarrao_delivery.model.Sauce;
import br.com.dotofcodex.somacarrao_delivery.util.ValidObject;

public class SauceService implements ValidObject<Plate> {

	private static final Logger logger = LoggerFactory.getLogger(SauceService.class);
	
	private SauceDAO dao;

	public SauceService() {
		super();
	}

	@Override
	public boolean exists(Plate plate) throws BusinessException {
		for (Sauce sauce: plate.getSauces()) {
			if (!dao.exists(sauce)) {
				throw new BusinessException("Identificador de Sauce inválido");				
			}
		}

		return true;
	}

}
