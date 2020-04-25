package br.com.dotofcodex.somacarrao_delivery.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.dotofcodex.somacarrao_delivery.model.OrderStatus;

@Repository
public class OrderStatusDAO {

	private static final Logger logger = LoggerFactory.getLogger(OrderStatusDAO.class);

	@Autowired
	private JdbcTemplate template;

	public OrderStatusDAO() {
		super();
	}

	public Boolean exists(OrderStatus orderStatus) {
		logger.info("begin exists");
		Boolean result = template.queryForObject("SELECT id != 0 FROM orders_status WHERE id = ?",
				new Long[] { orderStatus.getId() }, Boolean.class);
		logger.info("end exists");
		return result;
	}

	public List<OrderStatus> getAll() {
		logger.info("begin getAll");
		List<OrderStatus> result = template.query("SELECT * FROM orders_status",
				new BeanPropertyRowMapper<OrderStatus>(OrderStatus.class));
		logger.info("end getAll");
		return result;
	}

}
