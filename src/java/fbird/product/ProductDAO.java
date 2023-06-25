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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuan3
 */
public class ProductDAO {

    private static final String GET_BIRD = "SELECT [type_of_bird_id] FROM type_of_bird WHERE [name] like ?";
    private static final String ADD_PRODUCT = "INSERT INTO [shop_product_item] VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE shop_product_item SET title=?, description=?, inventory=?, status=? WHERE shop_product_item_id=? ";
    private static final String VIEW_PRODUCT = "SELECT * FROM shop_product_item";

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
                ptm = conn.prepareStatement(UPDATE);
                    ptm.setString(1, product.getTitle());
                    ptm.setString(2, product.getDescription());
                    ptm.setInt(3, product.getInventory());
                    ptm.setInt(4, product.getStatus());
                    ptm.setInt(5, product.getShopProductItemID());
                    check = ptm.executeUpdate()>0?true:false;
                }
            }finally{
            if(conn != null) conn = null;
            if(ptm != null) ptm = null;
        }
        return check;
    }

    public List<ProductDTO> getListProduct() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(VIEW_PRODUCT);
                rs = ptm.executeQuery();
                while(rs.next()){
                    int shopProductItemID = rs.getInt("shop_product_item_id");
                    int shopID = rs.getInt("shop_id");
                    int categoryID = rs.getInt("category_id");
                    int typeOfBirdID = rs.getInt("type_of_bird_id");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    int inventory = rs.getInt("inventory");
                    Date uploadDate = rs.getDate("upload_date");
                    Byte status = rs.getByte("status");
                    list.add(new ProductDTO(shopProductItemID, shopID, categoryID, typeOfBirdID, title, description, inventory, uploadDate, status));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(conn!=null) conn.close();
            if(ptm!=null) ptm.close();
            if(rs!=null) rs.close();
        }
        return list;
    }
}
