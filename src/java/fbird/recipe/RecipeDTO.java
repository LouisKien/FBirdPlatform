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
    int recipeProductID;
    String typeOfBirdName;
    int optionalShopProductItemID;
    String nameProductOptional;
    int quantity;
    int shopProductItemID;
    String nameProduct;
    Boolean status;
    String category;
    String image_1;
    String image_2;
    String image_3;
    String image_4;
    String description;
    double price;

    public RecipeDTO() {
    }

    public RecipeDTO(int recipe_id, int shop_id, String title_recipe, Double total_price, String image_1) {
        this.recipe_id = recipe_id;
        this.shop_id = shop_id;
        this.title_recipe = title_recipe;
        this.total_price = total_price;

        this.image_1 = image_1;
    }

    public RecipeDTO(int recipe_id, int shop_id, String title_recipe, Double total_price, int recipeProductID, int optionalShopProductItemID, String nameProductOptional, int quantity, int shopProductItemID, String nameProduct, Boolean status, String image_1, String image_2, String image_3, String image_4, String description) {
        this.recipe_id = recipe_id;
        this.shop_id = shop_id;
        this.title_recipe = title_recipe;
        this.total_price = total_price;
        this.recipeProductID = recipeProductID;
        this.optionalShopProductItemID = optionalShopProductItemID;
        this.nameProductOptional = nameProductOptional;
        this.quantity = quantity;
        this.shopProductItemID = shopProductItemID;
        this.nameProduct = nameProduct;
        this.status = status;
        this.image_1 = image_1;
        this.image_2 = image_2;
        this.image_3 = image_3;
        this.image_4 = image_4;
        this.description = description;
    }

    public RecipeDTO(int recipe_id, int shop_id, String title_recipe, Double total_price, int recipeProductID, String typeOfBirdName, int optionalShopProductItemID, String nameProductOptional, int quantity, int shopProductItemID, String nameProduct, Boolean status, String category, String image_1, String image_2, String image_3, String image_4, String description, double price) {
        this.recipe_id = recipe_id;
        this.shop_id = shop_id;
        this.title_recipe = title_recipe;
        this.total_price = total_price;
        this.recipeProductID = recipeProductID;
        this.typeOfBirdName = typeOfBirdName;
        this.optionalShopProductItemID = optionalShopProductItemID;
        this.nameProductOptional = nameProductOptional;
        this.quantity = quantity;
        this.shopProductItemID = shopProductItemID;
        this.nameProduct = nameProduct;
        this.status = status;
        this.category = category;
        this.image_1 = image_1;
        this.image_2 = image_2;
        this.image_3 = image_3;
        this.image_4 = image_4;
        this.description = description;
        this.price = price;
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

    public int getRecipeProductID() {
        return recipeProductID;
    }

    public void setRecipeProductID(int recipeProductID) {
        this.recipeProductID = recipeProductID;
    }

    public int getOptionalShopProductItemID() {
        return optionalShopProductItemID;
    }

    public void setOptionalShopProductItemID(int optionalShopProductItemID) {
        this.optionalShopProductItemID = optionalShopProductItemID;
    }

    public String getNameProductOptional() {
        return nameProductOptional;
    }

    public void setNameProductOptional(String nameProductOptional) {
        this.nameProductOptional = nameProductOptional;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getShopProductItemID() {
        return shopProductItemID;
    }

    public void setShopProductItemID(int shopProductItemID) {
        this.shopProductItemID = shopProductItemID;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getImage_2() {
        return image_2;
    }

    public void setImage_2(String image_2) {
        this.image_2 = image_2;
    }

    public String getImage_3() {
        return image_3;
    }

    public void setImage_3(String image_3) {
        this.image_3 = image_3;
    }

    public String getImage_4() {
        return image_4;
    }

    public void setImage_4(String image_4) {
        this.image_4 = image_4;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTypeOfBirdName() {
        return typeOfBirdName;
    }

    public void setTypeOfBirdName(String typeOfBirdName) {
        this.typeOfBirdName = typeOfBirdName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
