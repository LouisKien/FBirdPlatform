/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fbird.controller;

import fbird.product.ProductDAO;
import fbird.product.ProductDTO;
import fbird.user.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;




/**
 *
 * @author tuan3
 */
@WebServlet(name = "UpdateProductController", urlPatterns = {"/UpdateProductController"})
public class UpdateProductController extends HttpServlet {

    private static final String ERROR = "tatCaSanPham.jsp";
    private static final String SUCCESS = "tatCaSanPham.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try{
            HttpSession session = request.getSession();
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            int shopID = loginUser.getShop_id();
            int productShopItemID = Integer.parseInt(request.getParameter("productShopItemID"));
            String productName = request.getParameter("productName");
            int inventory = Integer.parseInt(request.getParameter("inventory"));
            int typeOfBirdID = Integer.parseInt(request.getParameter("typeOfBirdID"));
            int typeProduct = Integer.parseInt(request.getParameter("typeProduct"));
//            priceProduct = request.getParameter("priceOfProduct");
            String description = request.getParameter("description");  
            ProductDAO dao = new ProductDAO();
            ProductDTO product = new ProductDTO(productShopItemID, shopID, typeProduct, typeOfBirdID, productName, description, inventory, "", 0);
            boolean checkUpdate = dao.checkUpdate(product);
            if(checkUpdate){
                url = SUCCESS;
            }
        }catch(Exception e){
            log("Error at UpdateProductController :" + e.toString());
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
