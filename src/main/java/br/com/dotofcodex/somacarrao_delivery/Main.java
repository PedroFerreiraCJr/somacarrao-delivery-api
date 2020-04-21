package br.com.dotofcodex.somacarrao_delivery;

import java.io.File;
import java.net.MalformedURLException;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) throws Exception {
		new Main().start();
	}

	public void start() throws ServletException, LifecycleException, MalformedURLException {
		logger.info("starting container...");
		String webappDirLocation = "src/main/webapp/";
		Tomcat tomcat = new Tomcat();

		String webPort = System.getenv("PORT");
		if (webPort == null || webPort.isEmpty()) {
			webPort = "8080";
		}

		tomcat.setPort(Integer.valueOf(webPort));

		Context context = tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());

		File configFile = new File(webappDirLocation + "WEB-INF/web.xml");
		context.setConfigFile(configFile.toURI().toURL());

		tomcat.start();
		tomcat.getConnector();
		logger.info("starting listening...");
		tomcat.getServer().await();
	}

}
