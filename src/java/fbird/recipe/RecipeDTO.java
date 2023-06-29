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
    Double sell_price;
    Double original_price;
    String source;
    String description;

    public RecipeDTO() {
    }

    public RecipeDTO(int recipe_id, int shop_id, String title_recipe, Double sell_price, Double original_price, String source) {
        this.recipe_id = recipe_id;
        this.shop_id = shop_id;
        this.title_recipe = title_recipe;
        this.sell_price = sell_price;
        this.original_price = original_price;
        this.source = source;
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

    public Double getSell_price() {
        return sell_price;
    }

    public void setSell_price(Double sell_price) {
        this.sell_price = sell_price;
    }

    public Double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Double original_price) {
        this.original_price = original_price;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
