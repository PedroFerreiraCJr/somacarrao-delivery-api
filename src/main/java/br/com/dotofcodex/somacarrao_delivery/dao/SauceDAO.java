package br.com.dotofcodex.somacarrao_delivery.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.dotofcodex.somacarrao_delivery.model.Sauce;

@Repository
public class SauceDAO {

	private static final Logger logger = LoggerFactory.getLogger(SauceDAO.class);

	@Autowired
	private JdbcTemplate template;

	public SauceDAO() {
		super();
	}

	public Boolean exists(Sauce sauce) {
		logger.info("begin exists");
		Boolean result = template.queryForObject("SELECT id != 0 FROM sauces WHERE id = ?",
				new Long[] { sauce.getId() }, Boolean.class);
		logger.info("end exists");
		return result;
	}

	public List<Sauce> getAll() {
		logger.info("begin getAll");
		List<Sauce> result = template.query("SELECT * FROM sauces", new BeanPropertyRowMapper<Sauce>(Sauce.class));
		logger.info("end getAll");
		return result;
	}

}
