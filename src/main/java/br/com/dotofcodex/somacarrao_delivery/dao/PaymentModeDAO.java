package br.com.dotofcodex.somacarrao_delivery.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.dotofcodex.somacarrao_delivery.model.PaymentMode;

@Repository
public class PaymentModeDAO {

	private static final Logger logger = LoggerFactory.getLogger(PaymentModeDAO.class);

	@Autowired
	private JdbcTemplate template;

	public PaymentModeDAO() {
		super();
	}

	public Boolean exists(PaymentMode paymentMode) {
		logger.info("begin exists");
		Boolean result = template.queryForObject("SELECT id != 0 FROM payment_modes WHERE id = ?",
				new Long[] { paymentMode.getId() }, Boolean.class);
		logger.info("end exists");
		return result;
	}

	public List<PaymentMode> getAll() {
		logger.info("begin getAll");
		List<PaymentMode> result = template.query("SELECT * FROM payment_modes",
				new BeanPropertyRowMapper<PaymentMode>(PaymentMode.class));
		logger.info("end getAll");
		return result;
	}

}
