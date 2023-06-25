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
import fbird.feedback.FeedbackDAO;
import fbird.feedback.FeedbackDTO;
import java.util.List;
import fbird.customer.CustomerDAO;
import fbird.customer.CustomerDTO;

/**
 *
 * @author Admin
 */
public class ViewFeedbackController extends HttpServlet {

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
        String url="productDetail.jsp";
        try{
//            int shop_product_item_id = Integer.parseInt(request.getParameter("shop_product_item_id"));
            int customer_id = Integer.parseInt(request.getParameter("customer_id"));           
            FeedbackDAO daoFeedback = new FeedbackDAO();
            CustomerDAO daoCustomer = new CustomerDAO();
//            List<FeedbackDTO> listFeedback = daoFeedback.getFeedback(shop_product_item_id);
            List<CustomerDTO> listCustomer = daoCustomer.getCustomer(customer_id);
            if(listCustomer.size()>0){
//                request.setAttribute("LIST_Feedback", listFeedback);
                request.setAttribute("LIST_Customer", listCustomer);
                
            }
        }catch(Exception ex){
            log("Error at Search: " + ex.toString());
        }finally{
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
