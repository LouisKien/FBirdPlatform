/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.user;

import fbird.customer.CustomerDTO;
import fbird.shop.ShopDTO;
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
 * @author louis
 */
public class UserDAO {

    private static final String LOGIN = "SELECT role_id, status FROM account WHERE username=? AND password=?";
    private static final String CHECK_EXIST = "SELECT * FROM account WHERE username=?";
    private static final String SIGN_UP = "insert into account values(?, ?, 3, 1)";

    private static final String GET_ACCOUNT = "SELECT username, role_id, status FROM account WHERE role_id = 2 OR role_id = 3";
    private static final String GET_SHOP = "SELECT username, email, phone, registed_date from shop_owner";
    private static final String GET_CUSTOMER = "SELECT username, email, phone, registed_date from customer";
    private static final String SEARCH_ACCOUNT_ON_VIEW_ACCOUNT_PAGE = "SELECT username, role_id, status FROM account WHERE username like ?";

    public UserDTO checkLogin(String username, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(LOGIN);
            ptm.setString(1, username);
            ptm.setString(2, password);
            rs = ptm.executeQuery();
            if (rs.next()) {
                int role_id = Integer.parseInt(rs.getString("role_id"));
                int status = Integer.parseInt(rs.getString("status"));
                user = new UserDTO(username, password, role_id, status);
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
        return user;
    }

    public UserDTO checkUserExist(String username) throws SQLException {
        //UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(CHECK_EXIST);
            ptm.setString(1, username);
            
            rs = ptm.executeQuery();
            if (rs.next()) {
                return new UserDTO(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3)), Integer.parseInt(rs.getString(4)));
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
        return null;
    }

    public void singup(String username, String password) throws SQLException {

        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(SIGN_UP);
            ptm.setString(1, username);
            ptm.setString(2, password);
            ptm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
    }

    public List<UserDTO> getListAccount() throws SQLException {
        List<UserDTO> listAccount = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(GET_ACCOUNT);
            rs = ptm.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                int role_id = Integer.parseInt(rs.getString("role_id"));
                int status = Integer.parseInt(rs.getString("status"));
                listAccount.add(new UserDTO(username, role_id, status));
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
        return listAccount;
    }

    public List<ShopDTO> listAccountForShop() throws SQLException {
        List<ShopDTO> listShop = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(GET_SHOP);
            rs = ptm.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Date registed_date = rs.getDate("registed_date");
                listShop.add(new ShopDTO(username, phone, email, registed_date));
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
        return listShop;
    }

    public List<CustomerDTO> listAccountForCustomer() throws SQLException {
        List<CustomerDTO> listCustomer = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(GET_CUSTOMER);
            rs = ptm.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Date registed_date = rs.getDate("registed_date");
                listCustomer.add(new CustomerDTO(username, phone, email, registed_date));
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
        return listCustomer;
    }

    public List<UserDTO> searchAccountList(String search) throws SQLException {
        List<UserDTO> listAccount = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(SEARCH_ACCOUNT_ON_VIEW_ACCOUNT_PAGE);
            ptm.setString(1, "%" + search + "%");
            rs = ptm.executeQuery();
            while (rs.next()) {
                int role_id = Integer.parseInt(rs.getString("role_id"));
                if (role_id == 2 || role_id == 3) {
                    String username = rs.getString("username");
                    int status = Integer.parseInt(rs.getString("status"));
                    listAccount.add(new UserDTO(username, role_id, status));
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
        return listAccount;
    }

}
