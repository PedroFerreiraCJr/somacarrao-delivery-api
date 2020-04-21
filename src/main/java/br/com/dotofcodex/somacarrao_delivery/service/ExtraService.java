package br.com.dotofcodex.somacarrao_delivery.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.dotofcodex.somacarrao_delivery.dao.ExtraDAO;
import br.com.dotofcodex.somacarrao_delivery.exception.BusinessException;
import br.com.dotofcodex.somacarrao_delivery.model.Extra;
import br.com.dotofcodex.somacarrao_delivery.model.Plate;
import br.com.dotofcodex.somacarrao_delivery.util.ValidObject;

public class ExtraService implements ValidObject<Plate> {

	private static final Logger logger = LoggerFactory.getLogger(ExtraService.class);
	
	private ExtraDAO dao;

	public ExtraService() {
		super();
	}

	@Override
	public boolean exists(Plate plate) throws BusinessException {
		for (Extra extra : plate.getExtras()) {
			if (!dao.exists(extra)) {
				throw new BusinessException("Identificador de Extra inválido");
			}
		}

		return true;
	}

}
