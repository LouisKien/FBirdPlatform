/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.feedback;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class FeedbackDTO {
    int feedback_id;
    int customer_id;
    int shop_product_item_id;
    String feedback;
    Boolean status;
    int number_of_stars;
    Date feedback_date;
    String avatar;
    String fullname;

    public FeedbackDTO() {
    }

    public FeedbackDTO(int feedback_id, int customer_id, int shop_product_item_id, String feedback, Boolean status, int number_of_stars, Date feedback_date) {
        this.feedback_id = feedback_id;
        this.customer_id = customer_id;
        this.shop_product_item_id = shop_product_item_id;
        this.feedback = feedback;
        this.status = status;
        this.number_of_stars = number_of_stars;
        this.feedback_date = feedback_date;
    }

    public FeedbackDTO(int customer_id, int shop_product_item_id, String feedback, Boolean status, int number_of_stars, Date feedback_date) {
        this.customer_id = customer_id;
        this.shop_product_item_id = shop_product_item_id;
        this.feedback = feedback;
        this.status = status;
        this.number_of_stars = number_of_stars;
        this.feedback_date = feedback_date;
    }

    public FeedbackDTO(String feedback, Boolean status, int number_of_stars, Date feedback_date, String avatar, String fullname) {
        this.feedback = feedback;
        this.status = status;
        this.number_of_stars = number_of_stars;
        this.feedback_date = feedback_date;
        this.avatar = avatar;
        this.fullname = fullname;
    }

    

   

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getShop_product_item_id() {
        return shop_product_item_id;
    }

    public void setShop_product_item_id(int shop_product_item_id) {
        this.shop_product_item_id = shop_product_item_id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getNumber_of_stars() {
        return number_of_stars;
    }

    public void setNumber_of_stars(int number_of_stars) {
        this.number_of_stars = number_of_stars;
    }

    public Date getFeedback_date() {
        return feedback_date;
    }

    public void setFeedback_date(Date feedback_date) {
        this.feedback_date = feedback_date;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    
    
    

    

    
}
