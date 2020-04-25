package br.com.dotofcodex.somacarrao_delivery.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.dotofcodex.somacarrao_delivery.model.Flavor;

@Repository
public class FlavorDAO {

	private static final Logger logger = LoggerFactory.getLogger(FlavorDAO.class);

	@Autowired
	private JdbcTemplate template;

	public FlavorDAO() {
		super();
	}

	public Boolean exists(Flavor flavor) {
		logger.info("begin exists");
		Boolean result = template.queryForObject("SELECT id != 0 FROM flavors WHERE id = ?",
				new Long[] { flavor.getId() }, Boolean.class);
		logger.info("end exists");
		return result;
	}

	public List<Flavor> getAll() {
		logger.info("begin getAll");
		List<Flavor> result = template.query("SELECT * FROM flavors", new BeanPropertyRowMapper<Flavor>(Flavor.class));
		logger.info("end getAll");
		return result;
	}

}
