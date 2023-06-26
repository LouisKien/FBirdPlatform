/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.shop;

import fbird.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author louis
 */
public class ShopDAO {
    private static final String CREATE_SHOP = "insert into shop_owner(username, shop_name, phone, email, address, registed_date, city) values(?, ?, ?, ?, ?, ?, ?)";
    public void createShop(String username, String shop_name, String phone, String email, String address, Date date, String city) throws SQLException{
        
        Connection conn = null;
        PreparedStatement ptm = null;
        
        try{
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(CREATE_SHOP);
            ptm.setString(1, username);
            ptm.setString(2, shop_name);
            ptm.setString(3, phone);
            ptm.setString(4, email);
            ptm.setString(5, address);
            ptm.setDate(6, (java.sql.Date) date);
            ptm.setString(7, city);
            ptm.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            
        }finally {
            
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
    
        }
    }
}
