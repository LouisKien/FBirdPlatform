/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fbird.controller;

import fbird.optionalshopproductitem.OptionalshopproductitemDAO;
import fbird.optionalshopproductitem.OptionalshopproductitemDTO;
import fbird.product.ProductDAO;
import fbird.product.ProductDTO;
import fbird.user.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.crypto.AEADBadTagException;

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
        try {
            ProductDAO dao = new ProductDAO();
            // lay anh
            Part filePart = request.getPart("productImage");
            String fileName = filePart.getSubmittedFileName();
            InputStream fileContent = filePart.getInputStream();
            // Lưu file vào thư mục tùy chọn (vd: "uploads")
            Files.copy(fileContent, Paths.get("img/" + fileName));
            HttpSession session = request.getSession();
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            int shopID = loginUser.getShop_id();
            String productName = request.getParameter("productName");
            int inventory = Integer.parseInt(request.getParameter("inventory"));
            int typeOfBirdID = Integer.parseInt(request.getParameter("typeOfBird"));
                int typeProductID = Integer.parseInt(request.getParameter("typeProduct"));
                String description = request.getParameter("description");
                Date date = new Date();
                ProductDTO product = new ProductDTO(shopID, typeProductID, typeOfBirdID, productName, description, inventory, date, (byte) 1);
                
                boolean check = dao.addProduct(product);
                int shopProductItemID = dao.getID(product);
                if (check) {
                    OptionalshopproductitemDAO optionalDao = new OptionalshopproductitemDAO();
                    List<OptionalshopproductitemDTO> listOptional = new ArrayList<>();
                    String option1 = request.getParameter("option1");
                    double priceOption1 = Double.parseDouble(request.getParameter("priceOption1"));
                    if (option1 != null && priceOption1 != 0) {
                        listOptional.add(new OptionalshopproductitemDTO(shopProductItemID, option1, priceOption1));
                    }
                    String option2 = request.getParameter("option2");
                    double priceOption2 = Double.parseDouble(request.getParameter("priceOption2"));
                    if (option2 != null && priceOption2 != 0) {
                        listOptional.add(new OptionalshopproductitemDTO(shopProductItemID, option2, priceOption2));
                    }
                    String option3 = request.getParameter("option3");
                    double priceOption3 = Double.parseDouble(request.getParameter("priceOption3"));
                    if (option3 != null && priceOption3 != 0) {
                        listOptional.add(new OptionalshopproductitemDTO(shopProductItemID, option3, priceOption3));
                    }
                    String option4 = request.getParameter("option4");
                    double priceOption4 = Double.parseDouble(request.getParameter("priceOption4"));
                    if (option4 != null && priceOption4 != 0) {
                        listOptional.add(new OptionalshopproductitemDTO(shopProductItemID, option4, priceOption4));
                    }
                    String option5 = request.getParameter("option5");
                    double priceOption5 = Double.parseDouble(request.getParameter("priceOption5"));
                    if (option5 != null && priceOption5 != 0) {
                        listOptional.add(new OptionalshopproductitemDTO(shopProductItemID, option5, priceOption5));
                    }
                    boolean checkOptional = optionalDao.addOptionalProductItem(listOptional);
                    if (checkOptional) {

                    }
                    request.setAttribute("MESSAGE", "Create successfully!");
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Unknow error!!");
                }
        } catch (Exception e) {
            log("Error at AddProductController :" + e.toString());
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
