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
    private static final String VIEW_RECIPE_HOMEPAGE ="SELECT recipe.title_recipe,recipe.recipe_id, recipe.shop_id, recipe.sell_price,recipe.original_price, recipe_image.source FROM recipe JOIN recipe_image ON recipe.recipe_id = recipe_image.recipe_id";
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
                    String source = rs.getString("source");

                    int recipe_id = rs.getInt("recipe_id");
                    int shop_id = rs.getInt("shop_id");
                    
                    Double sell_price = rs.getDouble("sell_price");
                    Double original_price = rs.getDouble("original_price");
                    
                    list.add(new RecipeDTO(recipe_id, shop_id , title_recipe, sell_price, original_price, source ));
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
}
