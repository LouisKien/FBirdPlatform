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

    public ProductDTO(int shopProductItemID, int shopID, int categoryID, int typeOfBirdID, String title, String description, int inventory, Date uploadDate, byte status, String nameOption, double priceView) {
        this.shopProductItemID = shopProductItemID;
        this.shopID = shopID;
        this.categoryID = categoryID;
        this.typeOfBirdID = typeOfBirdID;
        this.title = title;
        this.description = description;
        this.inventory = inventory;
        this.uploadDate = uploadDate;
        this.status = status;
        this.nameOption = nameOption;
        this.priceView = priceView;
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
