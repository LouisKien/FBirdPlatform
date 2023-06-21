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
    private static final String VIEW = "SELECT feedback, custommer_id, number_of_stars, feedback_date FROM feedback WHERE shop_product_item_id= ?";
    
    
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
                    String feedback = rs.getString("feedback");
                    int custommer_id = rs.getInt("custommer_id");
                    int number_of_stars = rs.getInt("role");
                    Boolean status = rs.getBoolean("status");
                    Date feedback_date =rs.getDate("feedback_date");
                    
                    list.add(new FeedbackDTO(custommer_id, shop_product_item_id, feedback, status, number_of_stars, feedback_date));
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
