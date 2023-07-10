/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.cart;
import fbird.cart.CartDTO;
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
 * @author Admin
 */
public class CartDAO {
    private static final String VIEW_CART= "SELECT quantity, cart_item.optional_shop_product_item_id, optional_shop_product_item.name, product_category.category_name, optional_shop_product_item.price, shop_product_item.title \n" +
"FROM  cart_item  \n" +
"JOIN optional_shop_product_item  ON cart_item.optional_shop_product_item_id = optional_shop_product_item.optional_shop_product_item_id \n" +
"JOIN shop_product_item ON optional_shop_product_item.shop_product_item_id = shop_product_item.shop_product_item_id \n" +
"JOIN product_category ON product_category.category_id = shop_product_item.category_id Where customer_id=?";
    private static final String ADD_CART_ITEM= "INSERT INTO cart_item (optional_shop_product_item_id, customer_id, quantity) VALUE(?,?,?)";
    public List<CartDTO> getCart(int customer_id) throws SQLException {
        List<CartDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_CART);
                ptm.setInt(1, customer_id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int optional_shop_product_item_id = rs.getInt("optional_shop_product_item_id");
                    String title = rs.getString("title");
                    Double price = rs.getDouble("price");
                    String name = rs.getString("name");
                    int quantity = rs.getInt("quantity");
                    String category_name = rs.getString("category_name");
                   
                    
                   
                    list.add(new CartDTO(title, name, price, quantity, category_name, optional_shop_product_item_id));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }
public void addFeedback(CartDTO addCartItem) throws SQLException, ClassNotFoundException{
        
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_CART_ITEM);
                ptm.setInt(1, addCartItem.getOptional_shop_product_item_id());
                ptm.setInt(1, addCartItem.getCustomer_id());
                ptm.setInt(1, addCartItem.getQuantity());
                
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
