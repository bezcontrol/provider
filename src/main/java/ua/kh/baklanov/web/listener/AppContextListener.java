package ua.kh.baklanov.web.listener;

import org.apache.log4j.Logger;
import ua.kh.baklanov.context.MyClassLoader;
import ua.kh.baklanov.exception.AppException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    private static final Logger LOG = Logger.getLogger(AppContextListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("Context listener start working...");
        try {
            MyClassLoader.load();
        } catch (AppException e) {
           LOG.error("Error loading context", e);
        }
    }
}
