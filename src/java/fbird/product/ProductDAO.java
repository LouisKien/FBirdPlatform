/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.product;

import fbird.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tuan3
 */
public class ProductDAO {

    private static final String GET_BIRD = "SELECT [type_of_bird_id] FROM type_of_bird WHERE [name] like ?";
    private static final String ADD_PRODUCT = "INSERT INTO [shop_product_item] VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE shop_product_item SET title=?, description=?, inventory=?, status=? WHERE shop_product_item_id=? ";

    public int checkTypeOfBird(String typeOfBird) throws ClassNotFoundException, SQLException {
        int id = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_BIRD);
                ptm.setString(1, "N" + typeOfBird);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("type_of_bird_id");
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
        return id;

    }

    public boolean addProduct(ProductDTO product) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_PRODUCT);
                ptm.setInt(1, product.getShopID());
                ptm.setInt(2, product.getCategoryID());
                ptm.setInt(3, product.getTypeOfBirdID());
                ptm.setString(4, product.getTitle());
                ptm.setString(5, product.getDescription());
                ptm.setInt(6, product.getInventory());
                ptm.setDate(7, (Date) product.getUploadDate());
                ptm.setByte(8, product.getStatus());

                check = ptm.executeUpdate() > 0 ? true : false;

            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ptm != null) {
                ptm.close();
            }
        }
        return check;
    }

    public boolean checkUpdate(ProductDTO product) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_PRODUCT);
                    ptm.setString(1, product.getTitle());
                    ptm.setString(2, product.getDescription());
                    ptm.setInt(3, product.getInventory());
                    ptm.setInt(4, product.getStatus());
                    check = ptm.executeUpdate()>0?true:false;
                }
            }finally{
            if(conn != null) conn = null;
            if(ptm != null) ptm = null;
        }
        return check;
    }
}
