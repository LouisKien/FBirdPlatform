/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fbird.utils.DBUtils;
import fbird.feedback.FeedbackDTO;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class FeedbackDAO {
    private static final String VIEW = "SELECT feedback_id, feedback, customer_id, number_of_stars, status, feedback_date FROM feedback WHERE shop_product_item_id= ?";
    private static final String ADD = "INSERT INTO feedback(customer_id, shop_product_item_id, feedback, status, number_of_stars, feedback_date) VALUES(?,?,?,?,?,?)";
    
    public List<FeedbackDTO> getFeedback(int shop_product_item_id) throws SQLException {
        List<FeedbackDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW);
                ptm.setInt(1, shop_product_item_id );
                rs = ptm.executeQuery();
//                while(rs.next()){
//                    list.add(new UserDto(rs.getString("userID"), rs.getString("fullName"), rs.getString("roleID"), "***"));   
//                }

                while (rs.next()) {
                    int feedback_id = rs.getInt("feedback_id");
                    
                    String feedback = rs.getString("feedback");
                    int customer_id = rs.getInt("customer_id");
                    int number_of_stars = rs.getInt("number_of_stars");
                    Boolean status = rs.getBoolean("status");
                    Date feedback_date =rs.getDate("feedback_date");
                    
                    list.add(new FeedbackDTO(feedback_id, customer_id, shop_product_item_id, feedback, status, number_of_stars, feedback_date));
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
    public void addFeedback(FeedbackDTO feedback) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD);
                ptm.setInt(1, feedback.getCustomer_id());
                ptm.setInt(2, feedback.getShop_product_item_id());
                ptm.setString(3, feedback.getFeedback());
                ptm.setBoolean(4, feedback.getStatus());
                ptm.setInt(5, feedback.getNumber_of_stars());
                ptm.setDate(6, (java.sql.Date) feedback.getFeedback_date());
                ptm.executeUpdate();
               
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
    }
}
