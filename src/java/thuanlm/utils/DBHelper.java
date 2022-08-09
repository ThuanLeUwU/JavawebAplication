/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuanlm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

/**
 *
 * @author lthua
 */
public class DBHelper implements Serializable {
    public static Connection makeConnection()
        throws ClassNotFoundException, SQLException, NamingException{
        
        //1. get current context of OS
        Context context = new InitialContext();
        //2. get context of server
        Context tomcatContext = (Context) context.lookup("java:comp/env");
        //3. use dataSource
        DataSource ds = (DataSource) tomcatContext.lookup("DSSE1613");
        //4. open connection
        Connection con = ds.getConnection();
        return con;
    }
//    public static Connection makeConnection() 
//                throws /*classNotFoundException*/SQLException, NamingException, ClassNotFoundException{
////        Context context = new InitialContext();
////        Context tomcatContext = (Context)context.lookup("java:comp/env");
////        DataSource ds = (DataSource)tomcatContext.lookup("DSSE1613");
////        Connection con = ds.getConnection();
//                //1. get current context of OS
////        Context context = new InitialContext();
////        //2. get context of server
////        Context tomcatContext = (Context) context.lookup("java:comp/env");
////        //3. use dataSource
////        DataSource ds = (DataSource) tomcatContext.lookup("DSSE1613");
////        //4. open connection
////        Connection con = ds.getConnection();
////        return con;
//        //1.Load driver
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        //2. Create conection String
//        String url = "jdbc:sqlserver://localhost:1433;"
//                + "databaseName=HKCBooking;"
//                + "instanceName=THUANLE";
//        //3.open Connection
//        
//        Connection con = DriverManager.getConnection(url,"sa","12345");
//        
//        return con;
////        return con;
////                
//    }
//    
    public static void getSiteMaps(ServletContext context) throws IOException{
        //get site Maps File
        String siteMapFilePath = context.getInitParameter("SITE_MAPS_FILE_PATH");
        Properties props = new Properties();
        InputStream is = null;
        is = context.getResourceAsStream(siteMapFilePath);
        
        props.load(is);
        
        context.setAttribute("SITEMAP", props);
    }
}
