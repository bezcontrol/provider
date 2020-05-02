package ua.kh.baklanov.web.listener;

import org.apache.log4j.Logger;
import ua.kh.baklanov.context.MyClassLoader;
import ua.kh.baklanov.exception.AppException;
import ua.kh.baklanov.web.controller.TextFields;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Class that sets up application context and configuration servlet context
 * @author Aleksei Baklanov
 */

@WebListener
public class AppContextListener implements ServletContextListener {
    private static final Logger LOG = Logger.getLogger(AppContextListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("Context listener start working...");
        try {
            MyClassLoader.load();
            sce.getServletContext().setAttribute("textFields",new TextFields());
        } catch (AppException e) {
           LOG.error("Error loading context", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
