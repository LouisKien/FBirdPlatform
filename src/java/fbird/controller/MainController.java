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

/**
 *
 * @author louis
 */
public class MainController extends HttpServlet {

    public static final String WELCOME_PAGE = "index.jsp";

    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    
    private static final String VIEW_ACCOUNT = "ViewAccount";
    private static final String VIEW_ACCOUNT_CONTROLLER = "ViewAccountController";
    private static final String VIEW_CUSTOMER_ACCOUNT = "ViewCustomerAccount";
    private static final String VIEW_CUSTOMER_ACCOUNT_CONTROLLER = "ViewCustomerAccountController";
    private static final String VIEW_SHOP_ACCOUNT = "ViewShopAccount";
    private static final String VIEW_SHOP_ACCOUNT_CONTROLLER = "ViewShopAccountController";
    private static final String SEARCH_ACCOUNT = "SearchAccount";
    private static final String SEARCH_ACCOUNT_CONTROLLER = "SearchAccountController";
    private static final String VIEW_REPORTED_SHOP = "ViewReportedShop";
    private static final String VIEW_REPORTED_SHOP_CONTROLLER = "ViewReportedShopController";
    private static final String DISABLE_REPORTED_SHOP = "DisableShop";
    private static final String DISABLE_REPORTED_SHOP_CONTROLLER = "DisableReportedShopController";
    private static final String DELETE_REPORTED_SHOP = "DeleteReportedShop";
    private static final String DELETE_REPORTED_SHOP_CONTROLLER = "DeleteReportedShopController";
    
    
    private static final String CREATE_PRODUCT = "CreateProduct";
    private static final String CREATE_PRODUCT_CONTROLLER = "AddProductController";
    private static final String UPDATE_PRODUCT = "Update Product";
    private static final String UPDATE_PRODUCT_CONTROLLER = "UpdateProductController";
    private static final String VIEW_PRODUCT = "ViewProduct";
    private static final String VIEW_PRODUCT_CONTROLLER = "ViewProductController";
    private static final String LOGIN_SHOP = "LoginShop";
    private static final String LOGIN_SHOP_CONTROLLER = "LoginShopController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = WELCOME_PAGE;
        try {
            String action = request.getParameter("action");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;

            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (VIEW_ACCOUNT.equals(action)) {
                url = VIEW_ACCOUNT_CONTROLLER;
            } else if (VIEW_CUSTOMER_ACCOUNT.equals(action)) {
                url = VIEW_CUSTOMER_ACCOUNT_CONTROLLER;
            } else if (VIEW_SHOP_ACCOUNT.equals(action)) {
                url = VIEW_SHOP_ACCOUNT_CONTROLLER;
            } else if (CREATE_PRODUCT.equals(action)) {
                url = CREATE_PRODUCT_CONTROLLER;
            } else if (CREATE_PRODUCT.equals(action)) {
                url = CREATE_PRODUCT_CONTROLLER;
            } else if (VIEW_PRODUCT.equals(action)) {
                url = VIEW_PRODUCT_CONTROLLER;
            } else if (SEARCH_ACCOUNT.equals(action)) {
                url = SEARCH_ACCOUNT_CONTROLLER;
            } else if (VIEW_REPORTED_SHOP.equals(action)) {
                url = VIEW_REPORTED_SHOP_CONTROLLER;
            } else if (DISABLE_REPORTED_SHOP.equals(action)) {
                url = DISABLE_REPORTED_SHOP_CONTROLLER;
            } else if (DELETE_REPORTED_SHOP.equals(action)) {
                url = DELETE_REPORTED_SHOP_CONTROLLER;
            } else if (LOGIN_SHOP.equals(action)) {
                url = LOGIN_SHOP_CONTROLLER;
            }
            else {
                request.setAttribute("ERROR", "Your ACTION is not support");
            }
        } catch (Exception e) {
            log("ERROR at MainController" + e.toString());
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
