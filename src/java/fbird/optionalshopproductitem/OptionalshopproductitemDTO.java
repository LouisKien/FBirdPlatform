/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.optionalshopproductitem;

/**
 *
 * @author Admin
 */
public class OptionalshopproductitemDTO {
    private int optional_shop_product_item_id;
    private int shop_product_item_id;
    private String name;
    private Double price;
    private String title;
    public OptionalshopproductitemDTO() {
    }

    public OptionalshopproductitemDTO(int optional_shop_product_item_id, String name, Double price) {
        this.optional_shop_product_item_id = optional_shop_product_item_id;
        this.name = name;
        this.price = price;
    }

    public OptionalshopproductitemDTO(String name, String title) {
        this.name = name;
        this.title = title;
    }

    

    

    public OptionalshopproductitemDTO(Double price) {
        this.price = price;
    }
    

    public int getShop_product_item_id() {
        return shop_product_item_id;
    }

    public void setShop_product_item_id(int shop_product_item_id) {
        this.shop_product_item_id = shop_product_item_id;
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

    public int getOptional_shop_product_item_id() {
        return optional_shop_product_item_id;
    }

    public void setOptional_shop_product_item_id(int optional_shop_product_item_id) {
        this.optional_shop_product_item_id = optional_shop_product_item_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
