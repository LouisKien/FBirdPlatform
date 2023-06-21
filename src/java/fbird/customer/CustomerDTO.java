/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.customer;

import java.util.Date;

/**
 *
 * @author louis
 */
public class CustomerDTO {
    int customer_id;
    String username;
    String fullname;
    Date date_of_birth;
    String phone;
    String avatar;
    boolean gender;
    String email;

    public CustomerDTO() {
    }

    public CustomerDTO(int customer_id, String username, String fullname, Date date_of_birth, String phone, String avatar, boolean gender, String email) {
        this.customer_id = customer_id;
        this.username = username;
        this.fullname = fullname;
        this.date_of_birth = date_of_birth;
        this.phone = phone;
        this.avatar = avatar;
        this.gender = gender;
        this.email = email;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
