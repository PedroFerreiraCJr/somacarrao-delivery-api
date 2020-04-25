package br.com.dotofcodex.somacarrao_delivery.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.dotofcodex.somacarrao_delivery.model.Drink;

@Repository
public class DrinkDAO {

	private static final Logger logger = LoggerFactory.getLogger(DrinkDAO.class);

	@Autowired
	private JdbcTemplate template;

	public DrinkDAO() {
		super();
	}

	public Boolean exists(Drink drink) {
		logger.info("begin exists");
		Boolean result = template.queryForObject("SELECT id != 0 FROM drinks WHERE id = ?",
				new Long[] { drink.getId() }, Boolean.class);
		logger.info("end exists");
		return result;
	}

	public List<Drink> getAll() {
		logger.info("begin getAll");
		List<Drink> result = template.query("SELECT * FROM drinks", new BeanPropertyRowMapper<Drink>(Drink.class));
		logger.info("end getAll");
		return result;
	}

}
