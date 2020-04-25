package br.com.dotofcodex.somacarrao_delivery.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.dotofcodex.somacarrao_delivery.model.Seasoning;

@Repository
public class SeasoningDAO {

	private static final Logger logger = LoggerFactory.getLogger(SeasoningDAO.class);

	@Autowired
	private JdbcTemplate template;

	public SeasoningDAO() {
		super();
	}

	public Boolean exists(Seasoning seasoning) {
		logger.info("begin exists");
		Boolean result = template.queryForObject("SELECT id != 0 FROM seasonings WHERE id = ?",
				new Long[] { seasoning.getId() }, Boolean.class);
		logger.info("end exists");
		return result;
	}

	public List<Seasoning> getAll() {
		logger.info("begin getAll");
		List<Seasoning> result = template.query("SELECT * FROM seasonings",
				new BeanPropertyRowMapper<Seasoning>(Seasoning.class));
		logger.info("end getAll");
		return result;
	}

}
