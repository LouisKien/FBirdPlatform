/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.order;

import fbird.utils.DBUtils;
import java.util.List;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admin
 */
public class OrderDAO {
     private static final String VIEW_ADDRESS ="select street, city, postal_code, phone, home_number from customer_address where customer_id=?";
     public List<OrderDTO> getAddress(int customer_id) throws SQLException {
        List<OrderDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_ADDRESS);
                ptm.setInt(1, customer_id);
                rs = ptm.executeQuery();
                while (rs.next()) {                   
                    String street = rs.getString("street");
                    String city = rs.getString("city");
                    String postal_code = rs.getString("postal_code");
                    String phone = rs.getString("phone");
                    String home_number = rs.getString("home_number");
                    
                    list.add(new OrderDTO(street, city, postal_code, phone, home_number));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
}
