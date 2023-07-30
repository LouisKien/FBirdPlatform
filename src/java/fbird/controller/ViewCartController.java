/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fbird.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import fbird.cart.CartDAO;
import fbird.cart.CartDTO;
import java.util.List;


/**
 *
 * @author Admin
 */
public class ViewCartController extends HttpServlet {

    private static final String ERROR="error.jsp";
    private static final String SUCCESS="addtocartv2.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
         try {

            int customer_id = Integer.parseInt(request.getParameter("customer_id"));
                          if(customer_id != 0){
                             request.getRequestDispatcher(url).forward(request, response);

                          }

            
//            int customer_id = Integer.parseInt(request.getParameter("id"));           
            CartDAO dao = new CartDAO();              

             List<CartDTO> All_Cart_Item = dao.getCart(customer_id);
             
                if (!All_Cart_Item.isEmpty()) {
                request.setAttribute("LIST_All_Cart_Item", All_Cart_Item);
                    url = SUCCESS;
               
          
            }

            
        } catch (Exception ex) {
            log("Error  " + ex.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            
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
