/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.report;

import fbird.report.ReportShopDTO;
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
public class ReportShopDAO {
     private static final String VIEW = "SELECT feedback_id, feedback, customer_id, number_of_stars, status, feedback_date FROM feedback WHERE shop_product_item_id= ?";
    private static final String ADD = "INSERT INTO feedback(customer_id, shop_product_item_id, feedback, status, number_of_stars, feedback_date) VALUES(?,?,?,?,?,?)";
    
    public List<ReportShopDTO> getFeedback(int shop_product_item_id) throws SQLException {
        List<ReportShopDTO> list = new ArrayList<>();
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
                    
//                    list.add(new ReportShopDTO(feedback_id, customer_id, shop_product_item_id, feedback, status, number_of_stars, feedback_date));
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
