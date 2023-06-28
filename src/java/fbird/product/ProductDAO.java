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
    private static final String VIEW_PRODUCT_DETAIL = "SELECT shop_product_item.shop_product_item_id, title, description, shop_product_item.shop_id, inventory, upload_date, status, type_of_bird_name, category_name, product_image.image_1, product_image.image_2, product_image.image_3,product_image.image_4,product_image.image_5, shop_name, avatar FROM shop_product_item left join shop_owner on shop_product_item.shop_id = shop_owner.shop_id left join type_of_bird on shop_product_item.type_of_bird_id = type_of_bird.type_of_bird_id left join product_image on product_image.shop_product_item_id = shop_product_item.shop_product_item_id left join product_category on shop_product_item.category_id = product_category.category_id WHERE shop_product_item.shop_product_item_id=?";
    private static final String VIEW_PRODUCT_HOMEPAGE = "SELECT shop_product_item.shop_product_item_id,shop_product_item.title, optional_shop_product_item.price, image_1\n" +
                                                    "    FROM dbo.shop_product_item\n" +
                                                    "    JOIN (\n" +
                                                    "        SELECT shop_product_item_id, MIN(price) AS min_price\n" +
                                                    "        FROM dbo.optional_shop_product_item\n" +
                                                    "        GROUP BY shop_product_item_id\n" +
                                                    "    ) AS min_prices ON shop_product_item.shop_product_item_id = min_prices.shop_product_item_id\n" +
                                                    "    JOIN dbo.optional_shop_product_item ON min_prices.shop_product_item_id = optional_shop_product_item.shop_product_item_id\n" +
                                                    "        AND optional_shop_product_item.price = min_prices.min_price\n" +
                                                    "        LEFT JOIN product_image ON shop_product_item.shop_product_item_id = product_image.shop_product_item_id\n" +
                                                    "    ORDER BY optional_shop_product_item.price ASC;";
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
    public List<ProductDTO> getProductDetail(int shopProductItemID) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(VIEW_PRODUCT_DETAIL);
                ptm.setInt(1, shopProductItemID);
                rs = ptm.executeQuery();
                while(rs.next()){
                    
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    int inventory = rs.getInt("inventory");
                    Date uploadDate = rs.getDate("upload_date");
                    Byte status = rs.getByte("status");
                    String image_1=rs.getString("image_1");
                    String image_2=rs.getString("image_2");
                    String image_3=rs.getString("image_3");
                    String image_4=rs.getString("image_4");
                    String image_5=rs.getString("image_5");
                    String type_of_bird_name=rs.getString("type_of_bird_name");
                    String shop_name=rs.getString("shop_name");
                    String avatar=rs.getString("avatar");

                    
                    list.add(new ProductDTO(shopProductItemID, title, description, inventory, uploadDate, status, image_1, image_2, image_3, image_4, image_5, type_of_bird_name, shop_name, avatar));
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
    public List<ProductDTO> getProductHomePage() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(VIEW_PRODUCT_HOMEPAGE);
                rs = ptm.executeQuery();
                while(rs.next()){

                    String title = rs.getString("title");

                    int shopProductItemID = rs.getInt("shop_product_item_id");
                    String image_1=rs.getString("image_1");
                    Double price=rs.getDouble("price");
                    list.add(new ProductDTO(shopProductItemID, title, image_1, price));
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
