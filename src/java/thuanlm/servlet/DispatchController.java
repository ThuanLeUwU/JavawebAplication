// /*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package thuanlm.servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Properties;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import thuanlm.db.MyApplicationConstants;
////import thuanlm.db.MyApplicationConstants;
//
///**
// *
// * @author lthua
// */
//@WebServlet(name = "DispatchController", urlPatterns = {"/DispatchController"})
//public class DispatchController extends HttpServlet {
//
//   // private final String LOGIN_PAGE = "";
//    //private final String LOGIN_CONTROLLER = "loginController";
//    //private final String SEARCH_LASTNAME_CONTROLLER = "SearchLastnameServlet";
//    //private final String DELETE_CONTROLLER = "DeleteAccountServlet";
//    //private final String UPDATE_CONTROLLER = "UpdateServlet";
//    //private final String STARTUP_CONTROLLER = "StartServlet";
//    //private final String ADD_TO_CART = "AddToCartServlet";
//    //private final String SHOW_CART = "showCart.jsp";
//    //private final String REMOVE_BOOK ="RemoveItemFromCart";
//    //private final String CREATE_ACCOUNT_CONTROLLER="CreateAccountServlet";
//    private final String LOGOUT_CONTROLLER = "LogoutServlet";
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
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        
//        //String url = STARTUP_CONTROLLER;
//        //Which button did user click??
//        String button = request.getParameter("btAction");
//        //get context
//        ServletContext context = this.getServletContext();
//        Properties siteMap = (Properties) context.getAttribute("SITEMAP");
//        String url = siteMap.getProperty(MyApplicationConstants.DispatchFeatures.LOGIN_PAGE);
//        try {
//            if (button == null) {
//                //url = STARTUP_CONTROLLER;
//            } else if (button.equals("Login")) {
//                url = siteMap.getProperty(MyApplicationConstants.DispatchFeatures.LOGIN_CONTROLLER);              
//            } else if ("Search".equals(button)){
//                url = siteMap.getProperty(MyApplicationConstants.LoginFeatures.SEARCH_LASTNAME_CONTROLLER);
//            } else if (button.equals("Delete")) {
//                url = siteMap.getProperty(MyApplicationConstants.LoginFeatures.DELETE_CONTROLLER);
//            } else if (button.equals("Update")) {
//                url = siteMap.getProperty(MyApplicationConstants.LoginFeatures.UPDATE_CONTROLLER);
//            } else if (button.equals("Add To Your Cart")) {
//                url = siteMap.getProperty(MyApplicationConstants.LoginFeatures.ADD_TO_CART);
//            } else if (button.equals("View Your Cart")) {
//                url = siteMap.getProperty(MyApplicationConstants.LoginFeatures.SHOW_CART);
//            } else if (button.equals("Remove Selected Item")){
//                url = siteMap.getProperty(MyApplicationConstants.LoginFeatures.REMOVE_BOOK);
//            } else if (button.equals("Create New Account")){
//                url = siteMap.getProperty(MyApplicationConstants.LoginFeatures.CREATE_ACCOUNT_CONTROLLER);
//            } else if (button.equals("Logout")) {
//                url = LOGOUT_CONTROLLER;
//            }
//            
//        } finally {
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
//        processRequest(request, response);
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
//        processRequest(request, response);
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
