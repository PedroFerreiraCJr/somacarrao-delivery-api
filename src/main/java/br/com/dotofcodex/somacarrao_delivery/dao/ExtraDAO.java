package br.com.dotofcodex.somacarrao_delivery.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.dotofcodex.somacarrao_delivery.model.Extra;

@Repository
public class ExtraDAO {

	private static final Logger logger = LoggerFactory.getLogger(ExtraDAO.class);

	@Autowired
	private JdbcTemplate template;

	public ExtraDAO() {
		super();
	}

	public Boolean exists(Extra extra) {
		logger.info("begin exists");
		Boolean result = template.queryForObject("SELECT id != 0 FROM extras WHERE id = ?",
				new Long[] { extra.getId() }, Boolean.class);
		logger.info("end exists");
		return result;
	}

	public List<Extra> getAll() {
		logger.info("begin getAll");
		List<Extra> result = template.query("SELECT * FROM extras", new BeanPropertyRowMapper<Extra>(Extra.class));
		logger.info("end getAll");
		return result;
	}

}
