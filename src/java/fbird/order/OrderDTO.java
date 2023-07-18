/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.order;

/**
 *
 * @author Admin
 */
public class OrderDTO {
    private String street;
    private String city;
    private String postal_code;
    private String phone;
    private String home_number;

    public OrderDTO() {
    }

    public OrderDTO(String street, String city, String postal_code, String phone, String home_number) {
        this.street = street;
        this.city = city;
        this.postal_code = postal_code;
        this.phone = phone;
        this.home_number = home_number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHome_number() {
        return home_number;
    }

    public void setHome_number(String home_number) {
        this.home_number = home_number;
    }
    @Override
    public String toString() {
        return home_number + "/" + street +"/" + city;
    }
}
