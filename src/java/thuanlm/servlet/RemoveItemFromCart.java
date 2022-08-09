/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuanlm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import thuanlm.cart.CartObject;

/**
 *
 * @author lthua
 */
@WebServlet(name = "RemoveItemFromCart", urlPatterns = {"/RemoveItemFromCart"})
public class RemoveItemFromCart extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            //1.Cust goes to Cart Place
            HttpSession session = request.getSession(false);
            if(session != null) {
                //2.Cust take cart
                CartObject cart = (CartObject)session.getAttribute("CART");
                if(cart != null) {
                    //3.crat get all items
                    Map<String, Integer> items = cart.getItems();
                    if(items != null) {
                        //4.get all selected items
                        String[] selectedItems = request.getParameterValues("chkItem");
                        if(selectedItems != null) {
                            for (String item : selectedItems) {
                                cart.removeItemFromCart(item);
                            } 
                            if(cart.getItems() !=  null) {
                                session.setAttribute("CART", cart);
                            } else {
                                session.setAttribute("CART", null);
                            }
                        }
                    }
                }//end cart exist!!
            }
            //5.Call View Cart again.
            
        } finally {
            String urlRewrting = "DispatchController?"
                    + "btAction=View Your Cart";
            response.sendRedirect(urlRewrting);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

