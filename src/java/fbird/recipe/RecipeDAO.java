/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.recipe;

import fbird.recipe.RecipeDTO;
import fbird.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RecipeDAO {
    
    
    private static final String VIEW_RECIPE_HOMEPAGE ="SELECT recipe.title_recipe,recipe.recipe_id, recipe.shop_id, recipe.total_price, recipe_image.image_1 FROM recipe JOIN recipe_image ON recipe.recipe_id = recipe_image.recipe_id";
    private static final String VIEW_RECIPE_DETAIL = "SELECT r.recipe_id, t.type_of_bird_name, r.shop_id, r.title_recipe, r.[description], r.total_price, p.recipe_product_id, p.optional_shop_product_item_id, op.[name], p.quantity, new.*\n" +
"FROM recipe r\n" +
"LEFT JOIN recipe_product p ON r.recipe_id = p.recipe_id\n" +
"LEFT JOIN type_of_bird t ON r.type_of_bird_id = t.type_of_bird_id\n" +
"LEFT JOIN optional_shop_product_item op ON op.optional_shop_product_item_id = p.optional_shop_product_item_id\n" +
"LEFT JOIN (\n" +
"    SELECT s.shop_product_item_id, s.shop_id, t.type_of_bird_name, s.title, s.[status], p.category_name, i.image_1, i.image_2, i.image_3, i.image_4, o.optional_shop_product_item_id, o.[name], o.price\n" +
"    FROM shop_product_item s\n" +
"    JOIN product_category p ON s.category_id = p.category_id\n" +
"    LEFT JOIN type_of_bird t ON s.type_of_bird_id = t.type_of_bird_id\n" +
"    LEFT JOIN product_image i ON s.shop_product_item_id = i.shop_product_item_id\n" +
"    JOIN optional_shop_product_item o ON s.shop_product_item_id = o.shop_product_item_id\n" +
"    WHERE o.optional_shop_product_item_id IN (SELECT recipe_product.optional_shop_product_item_id FROM recipe_product)\n" +
") new ON op.optional_shop_product_item_id = new.optional_shop_product_item_id\n" +
"WHERE r.recipe_id = ?";
    
    public List<RecipeDTO> getRecipeHomePage() throws SQLException {
        List<RecipeDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_RECIPE_HOMEPAGE);
                rs = ptm.executeQuery();
                while (rs.next()) {

                    String title_recipe = rs.getString("title_recipe");
                    String image_1 = rs.getString("image_1");

                    int recipe_id = rs.getInt("recipe_id");
                    int shop_id = rs.getInt("shop_id");
                    
                    Double total_price = rs.getDouble("total_price");
                   
                    
                    list.add(new RecipeDTO(recipe_id, shop_id , title_recipe, total_price, image_1 ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }

    public List<RecipeDTO> getRecipeDetail(int recipeID) throws SQLException {
        List<RecipeDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                ptm = conn.prepareStatement(VIEW_RECIPE_DETAIL);
                ptm.setInt(1, recipeID);
                rs = ptm.executeQuery();
                while(rs.next()){
                    String typeOfBirdName = rs.getString("type_of_bird_name");
                    int shopID = rs.getInt("shop_id");
                    String titleRecipe = rs.getString("title_recipe");
                    String description = rs.getString("description");
                    Double total = rs.getDouble("total_price");
                    int recipeProductID = rs.getInt("recipe_product_id");
                    int optionalShopProductItemID = rs.getInt("optional_shop_product_item_id");
                    String nameProductOptional = rs.getString("name");
                    int quantity = rs.getInt("quantity");
                    int shopProductItemID = rs.getInt("shop_product_item_id");
                    String nameProduct = rs.getString("title");
                    Boolean status = rs.getBoolean("status");
                    String categoryName = rs.getString("category_name");
                    String image_1 = rs.getString("image_1");
                    String image_2 = rs.getString("image_2");
                    String image_3 = rs.getString("image_3");
                    String image_4 = rs.getString("image_4");
                    Double priceProduct = rs.getDouble("price");
                    list.add(new RecipeDTO(recipeID, shopID, titleRecipe, total, recipeProductID, typeOfBirdName, optionalShopProductItemID, nameProductOptional, quantity, shopProductItemID, nameProduct, status, categoryName, image_1, image_2, image_3, image_4, description, priceProduct));
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs != null) rs.close();
            if(ptm != null) ptm.close();
            if(conn != null) conn.close();
        }
        return list;
    }


}
