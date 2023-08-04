/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fbird.controller;

import fbird.recipe.RecipeDAO;
import fbird.recipe.RecipeDTO;
import fbird.user.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author tuan3
 */
public class UpdateRecipeController extends HttpServlet {
    
    private static final String ERROR = "MainController?action=ViewUpdateRecipe&recipe_id=";
    private static final String SUCCESS = "MainController?action=ViewUpdateRecipe&recipe_id=";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try{
            
            boolean checkAddProduct = false;
            HttpSession session = request.getSession();
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            int shopID = loginUser.getShop_id();
            RecipeDTO recipe = null;
            RecipeDAO recipeDao = new RecipeDAO();
            int recipe_ID = Integer.parseInt(request.getParameter("recipe_id"));
            String recipeName = request.getParameter("recipeName");
            String typeOfBird = request.getParameter("typeOfBird");
            if (typeOfBird.equals("") || typeOfBird == null) {
                request.setAttribute("ErrorTypeOfBird", "You need to choose the value of Type Of Bird!!!");
            } else {
                int typeOfBirdID = Integer.parseInt(typeOfBird);
                String description = request.getParameter("description");
//                double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
                   double totalPrice = 1;
                recipe = new RecipeDTO(shopID, recipeName, totalPrice, typeOfBirdID, description);
                

                    String Product1 = request.getParameter("Product1");
                    int recipeProductID1 = Integer.parseInt(request.getParameter("recipe_product_id1"));
                    if (Product1.equals("none")) {
                        request.setAttribute("ErrorProduct1", "Your first product in the recipe must have value!!!");
                    } else {
                        String[] tmp = Product1.split(":");
                        int optionalShopProductItemID1 = Integer.parseInt(tmp[2].trim());
                        int inventory1 = Integer.parseInt(request.getParameter("inventory1"));
                        if(inventory1<=0){
                            request.setAttribute("inventory1","The inventory must more than 0");
                        }else{
                        checkAddProduct = recipeDao.updateOption(recipeProductID1,recipe_ID, optionalShopProductItemID1, inventory1);
                        }
                    }
                    String Product2 = request.getParameter("Product2");
                    if(Product2!=null){
                    int recipeProductID2 = Integer.parseInt(request.getParameter("recipe_product_id2"));
                    if(!Product2.equals("none")){
                        String[] tmp = Product2.split(":");
                        int optionalShopProductItemID2 = Integer.parseInt(tmp[2].trim());
                        int inventory2 = Integer.parseInt(request.getParameter("inventory2"));
                        if(inventory2<=0){
                            request.setAttribute("inventory1","The inventory must more than 0");
                        }else{
                        checkAddProduct = recipeDao.updateOption(recipeProductID2, recipe_ID, optionalShopProductItemID2, inventory2);
                        }
                        }
                    }
                    String Product3 = request.getParameter("Product3");
                    if(Product3!= null){
                    int recipeProductID3 = Integer.parseInt(request.getParameter("recipe_product_id3"));
                    if(!Product3.equals("none")){
                        String[] tmp = Product3.split(":");
                        int optionalShopProductItemID3 = Integer.parseInt(tmp[2].trim());
                        int inventory3 = Integer.parseInt(request.getParameter("inventory3"));
                        if(inventory3<=0){
                            request.setAttribute("inventory3","The inventory must more than 0");
                        }else{
                        checkAddProduct = recipeDao.updateOption(recipeProductID3, recipe_ID, optionalShopProductItemID3, inventory3);
                    }
                    }
                    }
                    String Product4 = request.getParameter("Product4");
                    if(Product4!=null){
                    int recipeProductID4 = Integer.parseInt(request.getParameter("recipe_product_id4"));
                    if(!Product4.equals("none")){
                        String[] tmp = Product4.split(":");
                        int optionalShopProductItemID4 = Integer.parseInt(tmp[2].trim());
                        int inventory4 = Integer.parseInt(request.getParameter("inventory4"));
                        if(inventory4<=0){
                            request.setAttribute("inventory4","The inventory must more than 0");
                        }else{
                        checkAddProduct = recipeDao.updateOption(recipeProductID4, recipe_ID, optionalShopProductItemID4, inventory4);
                    }
                    }
                    }
                    String Product5 = request.getParameter("Product5");
                    if(Product5!=null){
                    int recipeProductID5 = Integer.parseInt(request.getParameter("recipe_product_id5"));
                    if(!Product5.equals("none")){
                        String[] tmp = Product5.split(":");
                        int optionalShopProductItemID5 = Integer.parseInt(tmp[2].trim());
                        int inventory5 = Integer.parseInt(request.getParameter("inventory5"));
                        if(inventory5<=0){
                            request.setAttribute("inventory5","The inventory must more than 0");
                        }else{
                        checkAddProduct = recipeDao.updateOption(recipeProductID5, recipe_ID, optionalShopProductItemID5, inventory5);
                    }
                    }
                    }
                    
                    if(checkAddProduct){
                        boolean check = recipeDao.updateRecipe(recipe, recipe_ID);
                        if(check){
                        request.setAttribute("SUCCESS_MESSAGE", "Cập nhật thành công");
                        url = SUCCESS + recipe_ID + "&shop_id=" + shopID;
                        }
                    }else{
                        request.setAttribute("ERROR_MESSAGE", "Cập nhật thất bại");
                    }
                
            }
        }catch(Exception e){
            log("Error at UpdateRecipeController:" + e.toString());
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
