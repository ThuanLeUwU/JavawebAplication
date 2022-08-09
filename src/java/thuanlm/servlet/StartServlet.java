///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package thuanlm.servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.naming.NamingException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import thuanlm.booking.BookingDAO;
//
///**
// *
// * @author lthua
// */
//@WebServlet(name = "StartServlet", urlPatterns = {"/StartServlet"})
//public class StartServlet extends HttpServlet {
//    private final String LOGIN_PAGE = "login.html";
//    private final String SEARCH_PAGE = "search.jsp";
//    
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException, NamingException, ClassNotFoundException {
//        response.setContentType("text/html;charset=UTF-8");
//        
//        String url = LOGIN_PAGE;
//        try  {
//            Cookie[] cookies = request.getCookies();
//            if(cookies != null) {
//                //get last cookie
//                Cookie lastCookie = cookies[cookies.length - 1];
//                String username = lastCookie.getName();
//                String password = lastCookie.getValue();
//                //2.check login
//                BookingDAO dao = new BookingDAO();
//                boolean result = dao.checkLogin(username, password);
//                
//                if(result){
//                    url = SEARCH_PAGE;
//                } //username and password are matched!!!
//            } //cookies has value
//        } catch(NamingException ex) {
//            ex.printStackTrace();
//        } catch(SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            //response.sendRedirect(url);
//            RequestDispatcher rd = request.getRequestDispatcher(url);
//            rd.forward(request, response);
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            processRequest(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(StartServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NamingException ex) {
//            Logger.getLogger(StartServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(StartServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            processRequest(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(StartServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NamingException ex) {
//            Logger.getLogger(StartServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(StartServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
