/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fbird.controller;

import fbird.customer.CustomerDAO;
import fbird.user.UserDAO;
import fbird.user.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


/**
 *
 * @author Khanh
 */
public class updateUserProfileController extends HttpServlet {

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
            String username = request.getParameter("username");
            String fullName = request.getParameter("fullname");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");
            boolean genderSQL;
            if(gender == "Nam"){
                genderSQL = true;
            }else{
                genderSQL = false;
            }
            Date date = new Date();
            java.sql.Date datesql = new java.sql.Date(date.getTime());
            String dob = request.getParameter("dob");
            
            UserDAO dao = new UserDAO();
            UserDTO user = dao.checkUserExist(username);
            if (user == null) {
                request.setAttribute("msg", "Bạn cần đăng kí tài khoản để sử dụng dịch vụ này");
                request.getRequestDispatcher("userProfile.jsp").forward(request, response);
            } else {
                CustomerDAO cusDao = new CustomerDAO();
                cusDao.createCustomer(username, fullName, phone, email, genderSQL, dob, date);
                request.setAttribute("msg", "Cập nhật hồ sơ thành công thành công");
                request.getRequestDispatcher("createShop.jsp").forward(request, response);
            }
            
            
            
                    
        } catch (Exception e) {
            log("ERROR at updateUserProfileConttroller: " + toString());
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
