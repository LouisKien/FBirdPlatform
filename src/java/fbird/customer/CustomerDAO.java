/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.customer;

import fbird.user.UserDTO;
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
public class CustomerDAO {

    private static final String VIEW = "SELECT * FROM customer WHERE customer_id= ?";
    private static final String UPDATE_CUSTOMER = "insert into customer(username, fullname, phone, email, gender, date_of_birth, registed_date) values(?, ?, ?, ?, ?, ?, ?)";
    private static final String CHECK_EXIST = "SELECT fullname FROM customer WHERE username=?";

    private static final String INSERT_CUSTOMER = "INSERT INTO customer(username, fullname, email, avatar, registed_date) VALUES(?,?,?,?,?)";

    public List<CustomerDTO> getCustomer(int customer_id) throws SQLException {
        List<CustomerDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW);
                ptm.setInt(1, customer_id);
                rs = ptm.executeQuery();
//                while(rs.next()){
//                    list.add(new UserDto(rs.getString("userID"), rs.getString("fullName"), rs.getString("roleID"), "***"));   
//                }

                while (rs.next()) {
                    String username = rs.getString("username");
                    String phone = rs.getString("phone");
                    String fullname = rs.getString("fullname");
                    String avatar = rs.getString("avatar");
                    String email = rs.getString("email");
                    Boolean gender = rs.getBoolean("gender");
                    Date date_of_birth = rs.getDate("date_of_birth");
                    list.add(new CustomerDTO(customer_id, username, fullname, date_of_birth, phone, avatar, gender, email));
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

    public boolean createCustomer(String username, String fullname, String phone, String email, boolean gender, String dob, Date date) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(UPDATE_CUSTOMER);
            ptm.setString(1, username);
            ptm.setString(2, fullname);
            ptm.setString(3, phone);
            ptm.setString(4, email);
            ptm.setBoolean(5, gender);
            ptm.setString(6, dob);
            ptm.setDate(7, (java.sql.Date) date);
            check = ptm.executeUpdate() > 0 ? true : false;
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
        return check;
    }

    public CustomerDTO checkCustomerExist(String username) throws SQLException {
//        CustomerDTO customer = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(CHECK_EXIST);
            ptm.setString(1, username);

            rs = ptm.executeQuery();
            if (rs.next()) {
                return new CustomerDTO(rs.getString(1), rs.getString(2));
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

    public boolean insertCustomer(CustomerDTO googleCustomer) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_CUSTOMER);
                String abc = googleCustomer.getFullname();
                ptm.setString(1, googleCustomer.getUsername());
                ptm.setString(2, googleCustomer.getFullname());
                ptm.setString(3, googleCustomer.getEmail());
                ptm.setString(4, googleCustomer.getAvatar());
                ptm.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
                check = ptm.executeUpdate() > 0 ? true : false;
            }
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
        return check;
    }

}
