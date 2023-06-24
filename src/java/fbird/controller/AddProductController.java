/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fbird.controller;

import fbird.product.ProductDAO;
import fbird.product.ProductDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tuan3
 */
@WebServlet(name = "AddProductController", urlPatterns = {"/AddProductController"})
public class AddProductController extends HttpServlet {

    private static final String ERROR = "themSanPham.jsp";
    private static final String SUCCESS = "themSanPham.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try{
            ProductDAO dao = new ProductDAO();
            String productName = request.getParameter("productName");
            String inventory = request.getParameter("inventory");
            String typeOfBird = request.getParameter("typeOfBird");
            int typeOfBirdID = dao.checkTypeOfBird(typeOfBird);
            if(typeOfBird!=null){
                request.setAttribute("ERROR_BIRD", "Don't have any type of Bird");
            }else{
            int typeProduct = Integer.parseInt(request.getParameter("typeProduct"));
            String priceProduct = request.getParameter("priceOfProduct");
            String description = request.getParameter("description");
            LocalDateTime myDateObj = LocalDateTime.now();  
            System.out.println("Before Formatting: " + myDateObj);  
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");  
    
            String formattedDate = myDateObj.format(myFormatObj);
            ProductDTO product = new ProductDTO(ShopID, typeProduct, typeOfBirdID, productName, description, inventory, formattedDate, 1);
            boolean check = dao.addProduct(product);
            if(check){
                request.setAttribute("MESSAGE", "Create successfully!");
                url = SUCCESS;
            }else{
                    request.setAttribute("ERROR", "Unknow error!!");
                }
            }
        }catch(Exception e){
            log("Error at AddProductController :" + e.toString());
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
