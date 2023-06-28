/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.optionalshopproductitem;

import fbird.optionalshopproductitem.OptionalshopproductitemDTO;
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
public class OptionalshopproductitemDAO {
      private static final String GET_OPTIONAL = "SELECT name, price FROM optional_shop_product_item WHERE shop_product_item_id=?";
      private static final String GET_PRICE = "SELECT price FROM optional_shop_product_item WHERE name=?";
      
      
      
      public List<OptionalshopproductitemDTO> getListOptional(int shop_product_item_id) throws SQLException {
        List<OptionalshopproductitemDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(GET_OPTIONAL);
                ptm.setInt(1, shop_product_item_id);
                rs = ptm.executeQuery();
                while(rs.next()){
                 
                    String name = rs.getString("name");
                    Double price = rs.getDouble("price");
                    list.add(new OptionalshopproductitemDTO(name, price));
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
       public List<OptionalshopproductitemDTO> getPrice(String name) throws SQLException {
        List<OptionalshopproductitemDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(GET_PRICE);
                ptm.setString(1, name);
                rs = ptm.executeQuery();
                while(rs.next()){
                 
                    
                    Double price = rs.getDouble("price");
                    list.add(new OptionalshopproductitemDTO(price));
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
