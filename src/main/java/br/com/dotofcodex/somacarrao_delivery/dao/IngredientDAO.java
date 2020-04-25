package br.com.dotofcodex.somacarrao_delivery.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.dotofcodex.somacarrao_delivery.model.Ingredient;

@Repository
public class IngredientDAO {

	private static final Logger logger = LoggerFactory.getLogger(IngredientDAO.class);

	@Autowired
	private JdbcTemplate template;

	public IngredientDAO() {
		super();
	}

	public Boolean exists(Ingredient ingredient) {
		logger.info("begin exists");
		Boolean result = template.queryForObject("SELECT id != 0 FROM ingredients WHERE id = ?",
				new Long[] { ingredient.getId() }, Boolean.class);
		logger.info("end exists");
		return result;
	}

	public List<Ingredient> getAll() {
		logger.info("begin getAll");
		List<Ingredient> result = template.query("SELECT * FROM ingredients",
				new BeanPropertyRowMapper<Ingredient>(Ingredient.class));
		logger.info("end getAll");
		return result;
	}

}
