package br.com.dotofcodex.somacarrao_delivery.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.dotofcodex.somacarrao_delivery.model.SauceQuantity;

@Repository
public class SauceQuantityDAO {

	private static final Logger logger = LoggerFactory.getLogger(SauceQuantityDAO.class);

	@Autowired
	private JdbcTemplate template;

	public SauceQuantityDAO() {
		super();
	}

	public Boolean exists(SauceQuantity sauceQuantity) {
		logger.info("begin exists");
		Boolean result = template.queryForObject("SELECT id != 0 FROM sauces_quantity WHERE id = ?",
				new Long[] { sauceQuantity.getId() }, Boolean.class);
		logger.info("end exists");
		return result;
	}

	public List<SauceQuantity> getAll() {
		logger.info("begin getAll");
		List<SauceQuantity> result = template.query("SELECT * FROM sauces_quantity",
				new BeanPropertyRowMapper<SauceQuantity>(SauceQuantity.class));
		logger.info("end getAll");
		return result;
	}

}
