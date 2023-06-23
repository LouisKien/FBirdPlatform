/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.report;

import fbird.utils.DBUtils;
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
public class ReportedProductDAO {
    private static final String VIEW = "SELECT shop_product_item_id, customer_id, detail FROM reported_product WHERE reported_product_id= ?";
    private static final String ADD = "INSERT INTO reported_product (shop_product_item_id, customer_id, detail) VALUES(?,?,?)";
    
    public List<ReportedProductDTO> getReportProduct(int reported_product_id) throws SQLException {
        List<ReportedProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW);
                ptm.setInt(1, reported_product_id );
                rs = ptm.executeQuery();


                while (rs.next()) {
                    int shop_id= rs.getInt("shop_product_item_id");       
                    int customer_id= rs.getInt("customer_id");                                           
                    String detail =rs.getString("detail");
                    
                   list.add(new ReportedProductDTO(shop_id, customer_id, detail));
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
    public void addReportProduct(ReportedProductDTO addreportproduct) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD);
                ptm.setInt(1, addreportproduct.getShop_product_item_id());
                ptm.setInt(2, addreportproduct.getCustomer_id());
                ptm.setString(3, addreportproduct.getDetail());
              
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
