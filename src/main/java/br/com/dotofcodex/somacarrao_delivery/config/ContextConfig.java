package br.com.dotofcodex.somacarrao_delivery.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextConfig {

	private static final Logger logger = LoggerFactory.getLogger(ContextConfig.class);

	private static ContextConfig instance;

	private ClassPathXmlApplicationContext context;

	private ContextConfig() {
		super();
		logger.info("dataSourceConfig initialized");
	}

	public void init() {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("application-context.xml");
		}
	}

	public ApplicationContext getContext() {
		if (context == null) {
			init();
		}
		return context;
	}

	public void shutdown() {
		if (context != null) {
			context.close();
		}
	}

	public static ContextConfig getInstance() {
		if (instance == null) {
			synchronized (ContextConfig.class) {
				if (instance == null) {
					instance = new ContextConfig();
				}
			}
		}

		return instance;
	}
}
