/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.shop;

import java.util.Date;

public class ShopDTO {

    String username, shopName, phone, address, avatar, email, city;
    Date registed_date;

    public ShopDTO() {
    }

    public ShopDTO(String username, String shopName, String phone, String address, String avatar, String email, String city, Date registed_date) {
        this.username = username;
        this.shopName = shopName;
        this.phone = phone;
        this.address = address;
        this.avatar = avatar;
        this.email = email;
        this.city = city;
        this.registed_date = registed_date;
    }

    public ShopDTO(String username, String phone, String email, Date registed_date) {
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.registed_date = registed_date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getRegisted_date() {
        return registed_date;
    }

    public void setRegisted_date(Date registed_date) {
        this.registed_date = registed_date;
    }

}