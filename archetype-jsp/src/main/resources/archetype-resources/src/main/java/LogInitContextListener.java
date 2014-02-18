#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package} ;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

public class LogInitContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent e) {
		ServletContext ctx = e.getServletContext();

		String prefix = ctx.getRealPath("/");
		String file = "WEB-INF" + System.getProperty("file.separator")
				+ "classes" + System.getProperty("file.separator")
				+ "log4j.properties";

		if (file != null) {
			PropertyConfigurator.configure(prefix + file);
			System.out.println("Log4J Logging started for application: "
					+ prefix + file);
		} else {
			System.out
					.println("Log4J Is not configured for application Application: "
							+ prefix + file);
		}

	}

	public void contextDestroyed(ServletContextEvent event) {

	}

}