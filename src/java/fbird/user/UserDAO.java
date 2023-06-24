/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.user;

import fbird.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author louis
 */
public class UserDAO {
    private static final String LOGIN = "SELECT role_id, status FROM account WHERE username=? AND password=?";
    private static final String CHECK_EXIST = "SELECT * FROM account WHERE username=? AND password=?";
    private static final String SIGN_UP = "insert into account values(?, ?, 3, 1)";
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
    
    public UserDTO checkUserExist(String username, String password) throws SQLException {
        //UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(CHECK_EXIST);
            ptm.setString(1, username);
            ptm.setString(2, password);
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
    public void singup(String username, String password) throws SQLException{
        
        Connection conn = null;
        PreparedStatement ptm = null;
        
        try{
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(SIGN_UP);
            ptm.setString(1, username);
            ptm.setString(2, password);
            ptm.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            
        }finally {
            
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
    
        }
    }
}
