package br.com.dotofcodex.somacarrao_delivery.service;

import br.com.dotofcodex.somacarrao_delivery.dao.PastaDAO;
import br.com.dotofcodex.somacarrao_delivery.exception.BusinessException;
import br.com.dotofcodex.somacarrao_delivery.model.Plate;
import br.com.dotofcodex.somacarrao_delivery.util.ValidObject;

public class PastaService implements ValidObject<Plate> {

	private PastaDAO dao;

	public PastaService() {
		super();
	}

	@Override
	public boolean exists(Plate plate) throws BusinessException {
		boolean result = dao.exists(plate.getPasta());

		if (!result) {
			throw new BusinessException("Identificador de Pasta inválido");
		}

		return true;
	}

}
