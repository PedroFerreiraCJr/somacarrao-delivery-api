package br.com.dotofcodex.somacarrao_delivery.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.dotofcodex.somacarrao_delivery.config.ContextConfig;

public class AppContextListener implements ServletContextListener {

	private static final Logger logger = LoggerFactory.getLogger(AppContextListener.class);

	public AppContextListener() {
		super();
		logger.info("appcontext initialized");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ContextConfig.getInstance().init();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		ContextConfig.getInstance().shutdown();
	}

}
