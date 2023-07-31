/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fbird.controller;

import fbird.product.ProductDAO;
import fbird.product.ProductDTO;
import fbird.feedback.FeedbackDTO;
import fbird.feedback.FeedbackDAO;
import fbird.optionalshopproductitem.OptionalshopproductitemDTO;
import fbird.optionalshopproductitem.OptionalshopproductitemDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ViewProductDetailController extends HttpServlet {

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
        String url = "productDetail.jsp";
        try {

            int shop_product_item_id = Integer.parseInt(request.getParameter("shop_product_item_id"));
            int shop_id = Integer.parseInt(request.getParameter("shop_id"));
            
//            int customer_id = Integer.parseInt(request.getParameter("id"));           
            ProductDAO daoproduct = new ProductDAO();              
            FeedbackDAO daofeedback = new FeedbackDAO();    
            OptionalshopproductitemDAO daooptional = new OptionalshopproductitemDAO();
            List<ProductDTO> ProductDetail = daoproduct.getProductDetail(shop_product_item_id);                       
           List<FeedbackDTO> listFeedback = daofeedback.getFeedback(shop_product_item_id);                              
           List<OptionalshopproductitemDTO> listOptional = daooptional.getListOptional(shop_product_item_id);
            List<ProductDTO> ShopProductItemId = daoproduct.getShopProductItemId(shop_id);
             List<FeedbackDTO> AllFeedback = daofeedback.getAllFeedback(shop_id);
             List<ProductDTO> AllProduct = daoproduct.getProductHomePage();
             
                if (!ProductDetail.isEmpty()) {
                request.setAttribute("LIST_ProductDetail", ProductDetail);
                request.setAttribute("LIST_Feedback", listFeedback);
                request.setAttribute("LIST_Optional", listOptional);
                request.setAttribute("LIST_ShopProductItemId", ShopProductItemId);
                request.setAttribute("LIST_AllFeedback", AllFeedback);
                request.setAttribute("shop_product_item_id", shop_product_item_id);
                request.setAttribute("LIST_PRODUCT", AllProduct);
                
               
          
            }

            
        } catch (Exception ex) {
            log("Error at Search: " + ex.toString());
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
