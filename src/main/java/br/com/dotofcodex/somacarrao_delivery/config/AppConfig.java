package br.com.dotofcodex.somacarrao_delivery.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import br.com.dotofcodex.somacarrao_delivery.dao.PastaDAO;

@Configuration
@ComponentScan(basePackageClasses = { PastaDAO.class })
public class AppConfig {

	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

	public AppConfig() {
		super();
		logger.info("appconfig initialized");
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource datasource) {
		return new JdbcTemplate(datasource);
	}

	@Bean
	public DataSource datasource() throws Exception {
		ComboPooledDataSource datasource = new ComboPooledDataSource();
		datasource.setDriverClass("com.mysql.cj.jdbc.Driver");
		datasource.setJdbcUrl("jdbc:mysql://localhost:3306/delivery");
		datasource.setUser("root");
		datasource.setPassword("pedro");
		datasource.setMinPoolSize(10);
		datasource.setMaxPoolSize(50);
		datasource.setMaxStatements(100);
		datasource.setTestConnectionOnCheckout(true);
		return datasource;
	}

}
