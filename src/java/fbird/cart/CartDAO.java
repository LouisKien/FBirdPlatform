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
    private static final String VIEW_CART= "SELECT quantity, optional_shop_product_item.name, product_category.category_name, optional_shop_product_item.price, shop_product_item.title FROM  cart_item  JOIN optional_shop_product_item  ON cart_item.optional_shop_product_item_id = optional_shop_product_item.optional_shop_product_item_id JOIN shop_product_item ON optional_shop_product_item.shop_product_item_id = shop_product_item.shop_product_item_id JOIN product_category ON product_category.category_id = shop_product_item.category_id Where customer_id=?";
    
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

                    String title = rs.getString("title");
                    Double price = rs.getDouble("price");
                    String name = rs.getString("name");
                    int quantity = rs.getInt("quantity");
                    String category_name = rs.getString("category_name");
                   
                    
                   
                    list.add(new CartDTO(title, name, price, quantity, category_name));
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

}
