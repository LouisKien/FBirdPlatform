/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.order;

import fbird.cart.CartDAO;
import fbird.customer.CustomerDTO;
import fbird.utils.DBUtils;
import java.util.List;
import java.sql.SQLException;
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
public class OrderDAO {

    private static final String VIEW_ADDRESS = "select street, city, postal_code, phone, home_number from customer_address where customer_id=?";
    private static final String CREATE_ORDER = "INSERT customer_order(customer_id, delivery_method_id, order_address, order_date, status, total_price_order, paypal_transaction_id, order_phone) VALUES (?,?,?,?,?,?,?,?)";
    private static final String GET_LIST_OPTIONAL_SHOP_PRODUCT_ITEM_ID = "SELECT optional_shop_product_item_id FROM optional_shop_product_item JOIN shop_product_item ON optional_shop_product_item.shop_product_item_id = shop_product_item.shop_product_item_id WHERE name = ? AND title = ? AND price = ?";
    private static final String GET_CUSTOMER_ORDER_ID = "SELECT order_id FROM customer_order WHERE paypal_transaction_id = ? AND customer_id = ?";
    private static final String ADD_ORDER_PRODUCT = "INSERT order_item(order_id, optional_shop_product_item_id, sell_price, amount) VALUES (?,?,?,?)";
    private static final String SUBTRACT_QUANTITY_IN_INVENTORY = "UPDATE shop_product_item SET inventory = inventory - ? WHERE shop_product_item_id = (SELECT shop_product_item.shop_product_item_id FROM optional_shop_product_item JOIN shop_product_item ON optional_shop_product_item.shop_product_item_id = shop_product_item.shop_product_item_id WHERE optional_shop_product_item_id = ?)";
    private static final String GET_CART_ITEM_ID = "SELECT cart_item_id FROM optional_shop_product_item JOIN cart_item ON optional_shop_product_item.optional_shop_product_item_id = cart_item.optional_shop_product_item_id WHERE optional_shop_product_item.optional_shop_product_item_id = ? AND customer_id = ?";

    public List<OrderDTO> getAddress(int customer_id) throws SQLException {
        List<OrderDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_ADDRESS);
                ptm.setInt(1, customer_id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String street = rs.getString("street");
                    String city = rs.getString("city");
                    String postal_code = rs.getString("postal_code");
                    String phone = rs.getString("phone");
                    String home_number = rs.getString("home_number");

                    list.add(new OrderDTO(street, city, postal_code, phone, home_number));
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

    public boolean createOrder(int customer_id, int delivery_method_id, String order_address, double total_price_order, String order_phone, String paypal_transaction_id) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_ORDER);
                ptm.setInt(1, customer_id);
                ptm.setInt(2, delivery_method_id);
                ptm.setString(3, order_address);
                ptm.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
                ptm.setString(5, "Đã thanh toán");
                ptm.setDouble(6, total_price_order);
                ptm.setString(7, paypal_transaction_id);
                ptm.setString(8, order_phone);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
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
        return check;
    }

    public List<OrderDTO> getAllProductProperties(List<OrderDTO> listOrder, int customer_order_id) {
        List<OrderDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                for (OrderDTO o : listOrder) {
                    String title = o.getTitle();
                    String name = o.getName();
                    double price = o.getPrice();
                    int quantity = o.getQuantity();
                    double unitPrice = price / (double) quantity;
                    ptm = conn.prepareStatement(GET_LIST_OPTIONAL_SHOP_PRODUCT_ITEM_ID);
                    ptm.setString(1, name);
                    ptm.setString(2, title);
                    ptm.setDouble(3, unitPrice);
                    rs = ptm.executeQuery();
                    while (rs.next()) {
                        int order_id = customer_order_id;
                        int optional_product_item_id = rs.getInt("optional_shop_product_item_id");
                        double sell_price = unitPrice;
                        int amount = quantity;
                        list.add(new OrderDTO(order_id, optional_product_item_id, sell_price, amount));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return list;
    }

    public int getCustomerOrderID(int customer_id, String paypal_transaction_id) throws SQLException {
        int customer_order_id = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(GET_CUSTOMER_ORDER_ID);
            ptm.setString(1, paypal_transaction_id);
            ptm.setInt(2, customer_id);
            rs = ptm.executeQuery();
            while (rs.next()) {
                customer_order_id = rs.getInt("order_id");
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
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
        return customer_order_id;
    }

    public boolean addOrderProduct(List<OrderDTO> listProperty) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                for (OrderDTO o : listProperty) {
                    ptm = conn.prepareStatement(ADD_ORDER_PRODUCT);
                    int orderid = o.getOrder_id();
                    int optional = o.getOptional_product_item_id();
                    double s = o.getSell_price();
                    int amount = o.getAmount();
                    ptm.setInt(1, o.getOrder_id());
                    ptm.setInt(2, o.getOptional_product_item_id());
                    ptm.setDouble(3, o.getSell_price());
                    ptm.setInt(4, o.getAmount());
                    check = ptm.executeUpdate() > 0 ? true : false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
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
        return check;
    }

    public boolean subtractQuantityInInventory(List<OrderDTO> listProperty) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                for (OrderDTO o : listProperty) {
                    ptm = conn.prepareStatement(SUBTRACT_QUANTITY_IN_INVENTORY);
                    ptm.setInt(1, o.getAmount());
                    ptm.setInt(2, o.getOptional_product_item_id());
                    check = ptm.executeUpdate() > 0 ? true : false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
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
        return check;
    }

    public boolean deleteCartItem(List<OrderDTO> listProperty, int customer_id) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                for (OrderDTO o : listProperty) {
                    ptm = conn.prepareStatement(GET_CART_ITEM_ID);
                    ptm.setInt(1, o.getOptional_product_item_id());
                    ptm.setInt(2, customer_id);
                    rs = ptm.executeQuery();
                    if (rs.next()) {
                        CartDAO cdao = new CartDAO();
                        check = cdao.deleteCartItem(rs.getInt("cart_item_id"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
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
        return check;
    }

}
