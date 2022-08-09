/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuanlm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thuanlm.booking.BookingDAO;
import thuanlm.booking.BookingDTO;
import thuanlm.utils.MyApplicationConstants;

/**
 *
 * @author lthua
 */
@WebServlet(name = "SearchLastnameServlet", urlPatterns = {"/SearchLastnameServlet"})
public class SearchLastnameServlet extends HttpServlet {

    //private final String SEARCH_PAGE = "search";
    //private final String SEARCH_RESULT_PAGE = "search.jsp";
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
            throws ServletException, IOException, NamingException {
        response.setContentType("text/html;charset=UTF-8");

        String searchValue = request.getParameter("txtSearchValue");
        ServletContext context = request.getServletContext();
            Properties siteMap = (Properties) context.getAttribute("SITEMAP"); 
        //String url = SEARCH_PAGE;
        String url = siteMap.getProperty(MyApplicationConstants.LoginFeatures.ERROR_PAGE);
        try {
            if (searchValue.trim().length() > 0) {
                //call DAO
                BookingDAO dao = new BookingDAO();
                dao.searchLastname(searchValue);
                  List<BookingDTO> result = dao.getAccounts();
                  
                  request.setAttribute("SEARCHRESULT", result);
                  url = siteMap.getProperty(MyApplicationConstants.LoginFeatures.SEARCH_PAGE);
            }//end if searchValue has value
            if (searchValue.trim().length() == 0) {
                BookingDAO dao = new BookingDAO();
                dao.searchLastname(searchValue);
                  List<BookingDTO> result = dao.getAccounts();
                  
                  request.setAttribute("SEARCHRESULT", result);
                   url = siteMap.getProperty(MyApplicationConstants.LoginFeatures.SEARCH_PAGE);

            }
        } catch (ClassNotFoundException ex) {
           log("SearchLastNameServlet _ NotFound" + ex.getMessage());
        } catch (SQLException ex) {
            log("SearchLastNameServlet _ SQL" + ex.getMessage());
        } finally {
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
            Logger.getLogger(SearchLastnameServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SearchLastnameServlet.class.getName()).log(Level.SEVERE, null, ex);
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
