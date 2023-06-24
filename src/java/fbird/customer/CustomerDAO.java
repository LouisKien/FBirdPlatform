/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.customer;


import fbird.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CustomerDAO {
    private static final String VIEW = "SELECT * FROM feedback WHERE customer_id= ?";
    
    
    public List<CustomerDTO> getCustomer(int customer_id) throws SQLException {
        List<CustomerDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW);
                ptm.setInt(1, customer_id );
                rs = ptm.executeQuery();
//                while(rs.next()){
//                    list.add(new UserDto(rs.getString("userID"), rs.getString("fullName"), rs.getString("roleID"), "***"));   
//                }

                while (rs.next()) {
                    String username = rs.getString("feedback");
                    String phone = rs.getString("phone");
                    String fullname = rs.getString("fullname");
                    String avatar = rs.getString("avatar");
                    String email = rs.getString("email");
                    Boolean gender = rs.getBoolean("gender");
                    Date date_of_birth = rs.getDate("date_of_birth");
                    list.add(new CustomerDTO(customer_id, username, fullname, date_of_birth, phone, avatar, gender, email));
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
