/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuanlm.listener;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import thuanlm.utils.DBHelper;

/**
 * Web application lifecycle listener.
 *
 * @author lthua
 */
public class MyAppServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //get context Scope
        ServletContext context = sce.getServletContext();
        //Store site máps
        try {
            DBHelper.getSiteMaps(context);
        } catch (IOException ex) {
            context.log("MyAppServletListener _ IO " + ex.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //get context Scope
        ServletContext context = sce.getServletContext();
        context.removeAttribute("SITEMAP");
    }
}
