package br.com.dotofcodex.somacarrao_delivery.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.dotofcodex.somacarrao_delivery.model.Pasta;

@Repository
public class PastaDAO {

	private static final Logger logger = LoggerFactory.getLogger(PastaDAO.class);

	@Autowired
	private JdbcTemplate template;

	public PastaDAO() {
		super();
	}

	public Boolean exists(Pasta pasta) {
		logger.info("begin exists");
		Boolean result = template.queryForObject("SELECT id != 0 FROM pastas WHERE id = ?",
				new String[] { pasta.getId().toString() }, Boolean.class);
		logger.info("end exists");
		return result;
	}

	public List<Pasta> getAll() {
		logger.info("begin getAll");
		List<Pasta> result = template.query("SELECT * FROM pastas", new BeanPropertyRowMapper<Pasta>(Pasta.class));
		logger.info("end getAll");
		return result;
	}

}
