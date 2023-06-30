/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.recipe;

/**
 *
 * @author louis
 */
public class RecipeDTO {
    int recipe_id;
    int shop_id;
    String title_recipe;
    Double total_price;
    
    String image_1;
    String description;

    public RecipeDTO() {
    }

    public RecipeDTO(int recipe_id, int shop_id, String title_recipe, Double total_price, String image_1) {
        this.recipe_id = recipe_id;
        this.shop_id = shop_id;
        this.title_recipe = title_recipe;
        this.total_price = total_price;
        
        this.image_1= image_1;
    }

    

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getTitle_recipe() {
        return title_recipe;
    }

    public void setTitle_recipe(String title_recipe) {
        this.title_recipe = title_recipe;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    

    public String getImage_1() {
        return image_1;
    }

    public void setImage_1(String image_1) {
        this.image_1 = image_1;
    }

    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
