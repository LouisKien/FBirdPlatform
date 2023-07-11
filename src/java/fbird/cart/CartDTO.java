/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.cart;

/**
 *
 * @author louis
 */
public class CartDTO {
    int cart_item_id;
    int optional_shop_product_item_id;
    int customer_id;
    String title;
    String name;
    Double price;
    int quantity;
    String category_name;
    String image_1;
    public CartDTO() {
    }

    public CartDTO(String title, String image_1, String name, Double price, int quantity, String category_name, int optional_shop_product_item_id, int cart_item_id) {
        this.title = title;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category_name = category_name;
        this.optional_shop_product_item_id = optional_shop_product_item_id;      
        this.cart_item_id = cart_item_id;
        this.image_1 = image_1;
    }

    public CartDTO(int optional_shop_product_item_id, int customer_id, int quantity) {
        this.optional_shop_product_item_id = optional_shop_product_item_id;
        this.customer_id = customer_id;
        this.quantity = quantity;
        
    }

    public String getImage_1() {
        return image_1;
    }

    public void setImage_1(String image_1) {
        this.image_1 = image_1;
    }
    

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getOptional_shop_product_item_id() {
        return optional_shop_product_item_id;
    }

    public void setOptional_shop_product_item_id(int optional_shop_product_item_id) {
        this.optional_shop_product_item_id = optional_shop_product_item_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(int cart_item_id) {
        this.cart_item_id = cart_item_id;
    }
    
    
}
