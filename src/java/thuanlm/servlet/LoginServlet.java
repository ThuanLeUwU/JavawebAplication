/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuanlm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thuanlm.booking.BookingDAO;
import thuanlm.booking.BookingDTO;
import thuanlm.utils.MyApplicationConstants;

/**
 *
 * @author lthua
 */
public class LoginServlet extends HttpServlet {

//    private final String INVALID_PAGE = "invalid.html";
//    private final String SEARCH_PAGE = "search.html";
//    private final String SEARCH_PAGE = "search.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        
        String button = request.getParameter("btAction");
        
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        ServletContext context = request.getServletContext();
            Properties siteMap = (Properties) context.getAttribute("SITEMAP"); 
            String url = siteMap.getProperty(MyApplicationConstants.DispatchFeatures.INVALID_PAGE);
        try {
            //1. call check Login
            BookingDAO dao = new BookingDAO();
            boolean result = dao.checkLogin(username, password);

            if (result) {
                url = siteMap.getProperty(MyApplicationConstants.LoginFeatures.SEARCH_PAGE);
//                Cookie cookie = new Cookie(username, password);
//                cookie.setMaxAge(60*1);
//                response.addCookie(cookie);
    //check authorrization using sesiong object
                HttpSession session = request.getSession();
                session.setAttribute("USERNAME", username);
                String fullName = dao.getFullName(username);
                session.setAttribute("FULLNAME", fullName);
                //get full name by call DAO method
                BookingDTO dto = new BookingDTO(username, password, fullName, dao.checkAdmin(username));
                session.setAttribute("ACCOUNT", dto);
                if (dto.isRole()) { // if you are admin
                    url = siteMap.getProperty(MyApplicationConstants.DispatchFeatures.ADMIN_PAGE);
                } else { //if you are not admin
                    url = siteMap.getProperty(MyApplicationConstants.DispatchFeatures.USER_PAGE);
                }
            }//end if username and pass are matched!!!
        } catch (SQLException ex) {
            log("LoginServlet _ SQL" + ex.getMessage());
        } catch (NamingException ex) {
             log("LoginServlet _ Naming" + ex.getMessage());
        } finally {
//            response.sendRedirect(url);
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
