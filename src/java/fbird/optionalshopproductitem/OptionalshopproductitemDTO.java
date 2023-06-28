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
    int shop_product_item_id;
    String name;
    Double price;

    public OptionalshopproductitemDTO() {
    }

    public OptionalshopproductitemDTO(int shop_product_item_id, String name, Double price) {
        this.shop_product_item_id = shop_product_item_id;
        this.name = name;
        this.price = price;
    }

    public OptionalshopproductitemDTO(String name, Double price) {
        this.name = name;
        this.price = price;
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
    
}
