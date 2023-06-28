/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.product;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author louis
 */
public class ProductDTO {
    int shopProductItemID;
    int shopID;
    int categoryID;
    int typeOfBirdID;
    String title;
    String description;
    int inventory;
    Date uploadDate;
    byte status;
    String image_1;
    String image_2;
    String image_3;
    String image_4;
    String image_5;
    String type_of_bird_name;
    String category_name;
    String shop_name;
    String avatar;  
    Double price;
    
    
    
    String nameOption;
    double priceView;


    public ProductDTO() {
    }

    public ProductDTO(int shopID, int categoryID, int typeOfBirdID, String title, String description, int inventory, Date uploadDate, byte status) {
        this.shopID = shopID;
        this.categoryID = categoryID;
        this.typeOfBirdID = typeOfBirdID;
        this.title = title;
        this.description = description;
        this.inventory = inventory;
        this.uploadDate = uploadDate;
        this.status = status;
    }

    public ProductDTO(int shopProductItemID, int shopID, int categoryID, int typeOfBirdID, String title, String description, int inventory, Date uploadDate, byte status) {
        this.shopProductItemID = shopProductItemID;
        this.shopID = shopID;
        this.categoryID = categoryID;
        this.typeOfBirdID = typeOfBirdID;
        this.title = title;
        this.description = description;
        this.inventory = inventory;
        this.uploadDate = uploadDate;
        this.status = status;
    }


    public ProductDTO(int shopProductItemID, String title, String description, int inventory, Date uploadDate, byte status, String image_1, String image_2, String image_3, String image_4, String image_5, String type_of_bird_name, String shop_name, String avatar) {
        this.shopProductItemID = shopProductItemID;

   

        this.title = title;
        this.description = description;
        this.inventory = inventory;
        this.uploadDate = uploadDate;

        this.image_1 = image_1;
        this.image_2 = image_2;
        this.image_3 = image_3;
        this.image_4 = image_4;
        this.image_5 = image_5;
        this.type_of_bird_name = type_of_bird_name;
        this.shop_name = shop_name;
        this.avatar = avatar;
        
    }

    public ProductDTO(int shopProductItemID, int shopID, String title, String image_1, Double price) {
        this.shopProductItemID = shopProductItemID;
        this.shopID = shopID;
        this.title = title;
        this.image_1 = image_1;
        this.price = price;
    }

    

    public ProductDTO(int shopProductItemID, int shopID, int categoryID, int typeOfBirdID, String title, String description, int inventory, Date uploadDate, byte status, Double price, String nameOption) {
        this.shopProductItemID = shopProductItemID;
        this.shopID = shopID;
        this.categoryID = categoryID;
        this.typeOfBirdID = typeOfBirdID;
        this.title = title;
        this.description = description;
        this.inventory = inventory;
        this.uploadDate = uploadDate;
        this.status = status;
        this.price = price;
        this.nameOption = nameOption;
    }

    public ProductDTO(int shopProductItemID) {
        this.shopProductItemID = shopProductItemID;
    }

    
    public int getShopProductItemID() {
        return shopProductItemID;
    }

    public void setShopProductItemID(int shopProductItemID) {
        this.shopProductItemID = shopProductItemID;
    }
    

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getTypeOfBirdID() {
        return typeOfBirdID;
    }

    public void setTypeOfBirdID(int typeOfBirdID) {
        this.typeOfBirdID = typeOfBirdID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }


    public String getImage_1() {
        return image_1;
    }

    public void setImage_1(String image_1) {
        this.image_1 = image_1;
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

    public String getImage_5() {
        return image_5;
    }

    public void setImage_5(String image_5) {
        this.image_5 = image_5;
    }

    public String getType_of_bird_name() {
        return type_of_bird_name;
    }

    public void setType_of_bird_name(String type_of_bird_name) {
        this.type_of_bird_name = type_of_bird_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }



    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String getNameOption() {
        return nameOption;
    }

    public void setNameOption(String nameOption) {
        this.nameOption = nameOption;
    }

    public double getPriceView() {
        return priceView;
    }

    public void setPriceView(double priceView) {
        this.priceView = priceView;

    }

  

    
}
