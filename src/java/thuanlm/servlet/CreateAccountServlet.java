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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thuanlm.booking.BookingCreateError;
import thuanlm.booking.BookingDAO;
import thuanlm.booking.BookingDTO;
import thuanlm.utils.MyApplicationConstants;

/**
 *
 * @author lthua
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

    private final String CREATE_ERROR_PAGE = "createAccountError.jsp";
    private final String LOGIN_PAGE = "login.html";

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullName = request.getParameter("txtFullname");
        String button = request.getParameter("btAction");
        
        ServletContext context = request.getServletContext();
        Properties siteMap = (Properties) context.getAttribute("SITEMAP"); 
        
        BookingCreateError errors = new BookingCreateError();
        boolean foundErrs = false;
        String url = CREATE_ERROR_PAGE;
        //String url = ERROR_PAGE;
        try {
            //1. Check all user's errors
            if (username.trim().length() < 6
                    || username.trim().length() > 20) {
                foundErrs = true;
                errors.setUsernameLengthErr("Username is required with 6 to 20 characters");
            }
            if (password.trim().length() < 6
                    || password.trim().length() > 20) {
                foundErrs = true;
                errors.setPasswordLengthErr("Password is required with 6 to 20 characters");
            } else if (confirm.trim().equals(password.trim()) == false) {
                foundErrs = true;
                errors.setConfirmNot("confirm must match password");
            }
            if (fullName.trim().length() < 2
                    || fullName.trim().length() > 50) {
                foundErrs = true;
                errors.setFullNameLengthErr("Fullname is required with 2 to 50 characters");
            }

            //2. process
            if (foundErrs) {
                //2. 1 forward errors to user
                request.setAttribute("CREATEERRORS", errors);
            } else {
                //2.2 insert to DB
                BookingDAO dao = new BookingDAO();
                BookingDTO dto = new BookingDTO(username, password, fullName, false);
                boolean result = dao.createAccount(dto);
                if (result) {
                    
                    url = LOGIN_PAGE;
                }
            } //crate successfull
        } catch (SQLException ex) {
            log("CreateAccountServlet _ SQL" + ex.getMessage());
            if(ex.getMessage().contains("duplicate")) {
                errors.setUsernameIssExisted(username + " is Existed");
                request.setAttribute("CREATEERRORS", errors);
            }//pk is duplicated
        } catch (NamingException ex) {
            log("CreateAccountServlet _ Naming" + ex.getMessage());
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
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
