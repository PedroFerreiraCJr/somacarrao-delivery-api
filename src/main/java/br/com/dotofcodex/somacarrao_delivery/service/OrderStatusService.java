package br.com.dotofcodex.somacarrao_delivery.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.dotofcodex.somacarrao_delivery.dao.OrderStatusDAO;
import br.com.dotofcodex.somacarrao_delivery.exception.BusinessException;
import br.com.dotofcodex.somacarrao_delivery.model.Plate;
import br.com.dotofcodex.somacarrao_delivery.util.ValidObject;

public class OrderStatusService implements ValidObject<Plate> {

	private static final Logger logger = LoggerFactory.getLogger(OrderStatusService.class);

	private OrderStatusDAO dao;

	public OrderStatusService() {
		super();
	}

	@Override
	public boolean exists(Plate plate) throws BusinessException {

		return true;
	}

}
