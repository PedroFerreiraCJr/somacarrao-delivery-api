package br.com.dotofcodex.somacarrao_delivery.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.dotofcodex.somacarrao_delivery.dao.OrderDAO;
import br.com.dotofcodex.somacarrao_delivery.exception.BusinessException;
import br.com.dotofcodex.somacarrao_delivery.model.Order;
import br.com.dotofcodex.somacarrao_delivery.model.Plate;
import br.com.dotofcodex.somacarrao_delivery.util.PlateValidator;
import br.com.dotofcodex.somacarrao_delivery.util.ValidObject;

public class OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	private static final PlateValidator validator = new PlateValidator();
	private static final List<ValidObject<Plate>> validators = new ArrayList<>();

	private OrderDAO dao;

	private PastaService pastaService;

	public OrderService() {
		super();
		this.pastaService = new PastaService();
		validators.add(pastaService);
	}

	public boolean create(Order order) {

		for (Plate plate : order.getPlates()) {
			try {
				validator.validate(plate);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}

		try {
			for (Plate plate : order.getPlates()) {
				for (ValidObject<Plate> validator : validators) {
					validator.exists(plate);
				}
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		return true;
	}

	public boolean cancel(Order order) {
		return true;
	}
}
