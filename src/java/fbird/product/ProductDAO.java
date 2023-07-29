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
    private static final String GET_ID1 = "SELECT TOP 1 shop_product_item_id\n"
            + "FROM shop_product_item\n"
            + "ORDER BY shop_product_item_id DESC;";
    private static final String VIEW_SHOP_PRODUCT = "SELECT\n"
            + "    shop_name, shop_owner.avatar,\n"
            + "    spi.shop_product_item_id,\n"
            + "    spi.title,\n"
            + "    ospi.price,\n"
            + "    spi.shop_id,\n"
            + "    pi.image_1\n"
            + "FROM\n"
            + "    dbo.shop_product_item spi\n"
            + "JOIN (\n"
            + "    SELECT\n"
            + "        shop_product_item_id,\n"
            + "        MIN(price) AS min_price\n"
            + "    FROM\n"
            + "        dbo.optional_shop_product_item\n"
            + "    GROUP BY\n"
            + "        shop_product_item_id\n"
            + ") AS min_prices ON spi.shop_product_item_id = min_prices.shop_product_item_id\n"
            + "JOIN shop_owner ON shop_owner.shop_id = spi.shop_id\n"
            + "JOIN dbo.optional_shop_product_item ospi ON min_prices.shop_product_item_id = ospi.shop_product_item_id\n"
            + "    AND ospi.price = min_prices.min_price\n"
            + "LEFT JOIN product_image pi ON spi.shop_product_item_id = pi.shop_product_item_id\n"
            + "WHERE\n"
            + "    spi.shop_id = ?\n"
            + "ORDER BY\n"
            + "    ospi.price ASC;";
    private static final String ADD_PRODUCT = "INSERT INTO [shop_product_item] VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE shop_product_item SET title=?, description=?, inventory=?, status=? WHERE shop_product_item_id=? ";
    private static final String NEW_VIEW_PRODUCT = "SELECT s.shop_product_item_id, s.shop_id, t.type_of_bird_name, s.title, p.category_name, i.image_1, i.image_2, i.image_3, i.image_4 FROM shop_product_item s JOIN product_category p ON s.category_id = p.category_id LEFT JOIN type_of_bird t ON s.type_of_bird_id = t.type_of_bird_id LEFT JOIN product_image i ON s.shop_product_item_id = i.shop_product_item_id";
    private static final String VIEW_PRODUCT = "SELECT * FROM shop_product_item where shop_id = ? Order by shop_product_item_id ASC\n" +
"OFFSET ? ROWS \n" +
"FETCH FIRST 10 ROWS ONLY;";
    private static final String VIEW_PRODUCT_PAGENUMBER_SHOP_ACCOUNT = "SELECT count(*) FROM shop_product_item where shop_id = ?";
    private static final String GET_ID = "SELECT s.* FROM shop_product_item s WHERE shop_id = ? and category_id = ? and type_of_bird_id = ? and inventory = ? and title like N'?' and [upload_date] = '?'";
    private static final String VIEW_SHOP_PRODUCT_ITEM_ID = "SELECT shop_product_item_id FROM shop_product_item where shop_id=?";
    private static final String VIEW_PRODUCT_DETAIL = "SELECT shop_product_item.shop_product_item_id, title, description, shop_product_item.shop_id, inventory, upload_date, status, type_of_bird_name, category_name, product_image.image_1, product_image.image_2, product_image.image_3,product_image.image_4, shop_name, shop_owner.shop_id, avatar FROM shop_product_item left join shop_owner on shop_product_item.shop_id = shop_owner.shop_id left join type_of_bird on shop_product_item.type_of_bird_id = type_of_bird.type_of_bird_id left join product_image on product_image.shop_product_item_id = shop_product_item.shop_product_item_id left join product_category on shop_product_item.category_id = product_category.category_id WHERE shop_product_item.shop_product_item_id=?";
    private static final String VIEW_PRODUCT_HOMEPAGE = "SELECT\n"
            + "    spi.shop_product_item_id,\n"
            + "    spi.title,\n"
            + "    ospi.price,\n"
            + "    spi.shop_id,\n"
            + "    pi.image_1\n"
            + "FROM\n"
            + "    dbo.shop_product_item spi\n"
            + "    JOIN (\n"
            + "        SELECT\n"
            + "            shop_product_item_id,\n"
            + "            MIN(price) AS min_price\n"
            + "        FROM\n"
            + "            dbo.optional_shop_product_item\n"
            + "        GROUP BY\n"
            + "            shop_product_item_id\n"
            + "    ) AS min_prices ON spi.shop_product_item_id = min_prices.shop_product_item_id\n"
            + "    JOIN dbo.optional_shop_product_item ospi ON min_prices.shop_product_item_id = ospi.shop_product_item_id\n"
            + "        AND ospi.price = min_prices.min_price\n"
            + "    LEFT JOIN product_image pi ON spi.shop_product_item_id = pi.shop_product_item_id\n"
            + "ORDER BY\n"
            + "    ospi.price ASC;";

    private static final String VIEW_PRO_CUSTOMER = "SELECT shop_product_item.*, optional_shop_product_item.price, optional_shop_product_item.[name]\n"
            + "FROM dbo.shop_product_item\n"
            + "JOIN (\n"
            + "    SELECT shop_product_item_id, MIN(price) AS min_price\n"
            + "    FROM dbo.optional_shop_product_item\n"
            + "    GROUP BY shop_product_item_id\n"
            + ") AS min_prices ON shop_product_item.shop_product_item_id = min_prices.shop_product_item_id\n"
            + "JOIN dbo.optional_shop_product_item ON min_prices.shop_product_item_id = optional_shop_product_item.shop_product_item_id\n"
            + "    AND optional_shop_product_item.price = min_prices.min_price\n"
            + "ORDER BY optional_shop_product_item.price ASC;";
    private static final String VIEW_PRODUCT_PAGE ="SELECT shop_product_item.*, image_1, optional_shop_product_item.price, optional_shop_product_item.[name]\n" +
"            FROM dbo.shop_product_item\n" +
"            JOIN (\n" +
"                SELECT shop_product_item_id, MIN(price) AS min_price\n" +
"                FROM dbo.optional_shop_product_item\n" +
"                GROUP BY shop_product_item_id\n" +
"            ) AS min_prices ON shop_product_item.shop_product_item_id = min_prices.shop_product_item_id\n" +
"            JOIN dbo.optional_shop_product_item ON min_prices.shop_product_item_id = optional_shop_product_item.shop_product_item_id\n" +
"			JOIN product_image ON shop_product_item.shop_product_item_id = product_image.shop_product_item_id\n" +
"                AND optional_shop_product_item.price = min_prices.min_price\n" +
"            ORDER BY optional_shop_product_item.price ASC";

    private static final String SEARCH_PRODUCT = "SELECT spi.shop_product_item_id, spi.title, ospi.price, spi.shop_id, pi.image_1 FROM dbo.shop_product_item spi JOIN (SELECT shop_product_item_id, MIN(price) AS min_price FROM dbo.optional_shop_product_item GROUP BY shop_product_item_id ) AS min_prices ON spi.shop_product_item_id = min_prices.shop_product_item_id  JOIN dbo.optional_shop_product_item ospi ON min_prices.shop_product_item_id = ospi.shop_product_item_id AND ospi.price = min_prices.min_price LEFT JOIN product_image pi ON spi.shop_product_item_id = pi.shop_product_item_id WHERE title LIKE ? ORDER BY ospi.price ASC OFFSET ? ROWS FETCH FIRST 10 ROWS ONLY;";

    private static final String COUNT_SEARCH_PRODUCT_PAGE = "SELECT count(spi.shop_product_item_id) FROM dbo.shop_product_item spi JOIN (SELECT shop_product_item_id, MIN(price) AS min_price FROM dbo.optional_shop_product_item GROUP BY shop_product_item_id ) AS min_prices ON spi.shop_product_item_id = min_prices.shop_product_item_id  JOIN dbo.optional_shop_product_item ospi ON min_prices.shop_product_item_id = ospi.shop_product_item_id AND ospi.price = min_prices.min_price LEFT JOIN product_image pi ON spi.shop_product_item_id = pi.shop_product_item_id WHERE title LIKE ? ";
    
    private static final String PRODUCT_PAGE_NUMBERPAGE = "SELECT\n"
            + "                count(spi.shop_product_item_id)\n"
            + "            FROM\n"
            + "                dbo.shop_product_item spi\n"
            + "                JOIN (\n"
            + "                    SELECT\n"
            + "                        shop_product_item_id,\n"
            + "                        MIN(price) AS min_price\n"
            + "                    FROM\n"
            + "                        dbo.optional_shop_product_item\n"
            + "                    GROUP BY\n"
            + "                        shop_product_item_id\n"
            + "                ) AS min_prices ON spi.shop_product_item_id = min_prices.shop_product_item_id\n"
            + "                JOIN dbo.optional_shop_product_item ospi ON min_prices.shop_product_item_id = ospi.shop_product_item_id\n"
            + "                    AND ospi.price = min_prices.min_price\n"
            + "                LEFT JOIN product_image pi ON spi.shop_product_item_id = pi.shop_product_item_id";

    private static final String VIEW_PRODUCT_PAGE_PAGING="SELECT\n" +
"                spi.shop_product_item_id,\n" +
"                spi.title,\n" +
"                ospi.price,\n" +
"                spi.shop_id,\n" +
"                pi.image_1\n" +
"            FROM\n" +
"                dbo.shop_product_item spi\n" +
"                JOIN (\n" +
"                    SELECT\n" +
"                        shop_product_item_id,\n" +
"                        MIN(price) AS min_price\n" +
"                    FROM\n" +
"                        dbo.optional_shop_product_item\n" +
"                    GROUP BY\n" +
"                        shop_product_item_id\n" +
"                ) AS min_prices ON spi.shop_product_item_id = min_prices.shop_product_item_id\n" +
"                JOIN dbo.optional_shop_product_item ospi ON min_prices.shop_product_item_id = ospi.shop_product_item_id\n" +
"                    AND ospi.price = min_prices.min_price\n" +
"                LEFT JOIN product_image pi ON spi.shop_product_item_id = pi.shop_product_item_id\n" +
"            ORDER BY\n" +
"                spi.shop_product_item_id\n" +
"				OFFSET ? ROWS\n" +
"				FETCH FIRST 10 ROWS ONLY;";
    
    private static final String CATEGORY_PAGENUMBER = "SELECT\n" +
"                count(spi.shop_product_item_id)\n" +
"                \n" +
"            FROM\n" +
"                dbo.shop_product_item spi\n" +
"                JOIN (\n" +
"                    SELECT\n" +
"                        shop_product_item_id,\n" +
"                        MIN(price) AS min_price\n" +
"                    FROM\n" +
"                        dbo.optional_shop_product_item\n" +
"                    GROUP BY\n" +
"                        shop_product_item_id\n" +
"                ) AS min_prices ON spi.shop_product_item_id = min_prices.shop_product_item_id\n" +
"                JOIN dbo.optional_shop_product_item ospi ON min_prices.shop_product_item_id = ospi.shop_product_item_id\n" +
"                    AND ospi.price = min_prices.min_price\n" +
"                LEFT JOIN product_image pi ON spi.shop_product_item_id = pi.shop_product_item_id where spi.category_id = ?";
    
    private static final String VIEW_CATEGORY_PAGING = "SELECT\n" +
"                spi.shop_product_item_id,\n" +
"                spi.title,\n" +
"                ospi.price,\n" +
"                spi.shop_id,\n" +
"                pi.image_1\n" +
"            FROM\n" +
"                dbo.shop_product_item spi\n" +
"                JOIN (\n" +
"                    SELECT\n" +
"                        shop_product_item_id,\n" +
"                        MIN(price) AS min_price\n" +
"                    FROM\n" +
"                        dbo.optional_shop_product_item\n" +
"                    GROUP BY\n" +
"                        shop_product_item_id\n" +
"                ) AS min_prices ON spi.shop_product_item_id = min_prices.shop_product_item_id\n" +
"                JOIN dbo.optional_shop_product_item ospi ON min_prices.shop_product_item_id = ospi.shop_product_item_id\n" +
"                    AND ospi.price = min_prices.min_price\n" +
"                LEFT JOIN product_image pi ON spi.shop_product_item_id = pi.shop_product_item_id where spi.category_id = ?\n" +
"           ORDER BY\n" +
"                spi.shop_product_item_id\n" +
"				OFFSET ? ROWS\n" +
"				FETCH FIRST 10 ROWS ONLY;";
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
                ptm.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));
                ptm.setByte(8, product.getStatus());

                check = ptm.executeUpdate() > 0 ? true : false;

            }
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
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            if (ptm != null) {
                ptm = null;
            }
            if (conn != null) {
                conn = null;
            }
        }
        return check;
    }
    public int getNumberProductPageShopAccount(int shop_id) throws SQLException {
        
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_PRODUCT_PAGENUMBER_SHOP_ACCOUNT);
                ptm.setInt(1, shop_id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int total = rs.getInt(1);
                    int countPage = 0;
                    countPage = total/10;
                    if(total % 10 != 0){
                        countPage++;
                    }
                    return countPage;
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
        return 0;
    }
    

    public List<ProductDTO> getListProduct(int shop_id, int index) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_PRODUCT);
                ptm.setInt(1, shop_id);
                ptm.setInt(2, (index-1)*10);
                rs = ptm.executeQuery();
                while (rs.next()) {
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

    public List<ProductDTO> getListProCus() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_PRO_CUSTOMER);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int shopProductItemID = rs.getInt("shop_product_item_id");
                    int shopID = rs.getInt("shop_id");
                    int CategoryID = rs.getInt("category_id");
                    int typeOfBirdID = rs.getInt("type_of_bird_id");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    int inventory = rs.getInt("inventory");
                    Date uploadDate = rs.getDate("upload_date");
                    byte status = rs.getByte("status");
                    double price = rs.getDouble("price");
                    String name = rs.getString("name");
                    list.add(new ProductDTO(shopProductItemID, shopID, CategoryID, typeOfBirdID, title, description, inventory, uploadDate, status, price, name));
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

    public List<ProductDTO> getProductDetail(int shopProductItemID) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_PRODUCT_DETAIL);
                ptm.setInt(1, shopProductItemID);
                rs = ptm.executeQuery();
                while (rs.next()) {

                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    int inventory = rs.getInt("inventory");
                    int shop_id = rs.getInt("shop_id");
                    Date uploadDate = rs.getDate("upload_date");
                    Byte status = rs.getByte("status");
                    String image_1 = rs.getString("image_1");
                    String image_2 = rs.getString("image_2");
                    String image_3 = rs.getString("image_3");
                    String image_4 = rs.getString("image_4");

                    String type_of_bird_name = rs.getString("type_of_bird_name");
                    String shop_name = rs.getString("shop_name");
                    String avatar = rs.getString("avatar");

                    list.add(new ProductDTO(shop_id, shopProductItemID, title, description, inventory, uploadDate, status, image_1, image_2, image_3, image_4, type_of_bird_name, shop_name, avatar));
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

    public List<ProductDTO> getProductHomePage() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_PRODUCT_HOMEPAGE);
                rs = ptm.executeQuery();
                while (rs.next()) {

                    String title = rs.getString("title");

                    int shopProductItemID = rs.getInt("shop_product_item_id");
                    int shopID = rs.getInt("shop_id");
                    String image_1 = rs.getString("image_1");
                    Double price = rs.getDouble("price");

                    list.add(new ProductDTO(shopProductItemID, shopID, title, image_1, price));
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

    public List<ProductDTO> getProductPage() throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_PRODUCT_PAGE);
                rs = ptm.executeQuery();
                while (rs.next()) {

                    String title = rs.getString("title");
                    int categoryID = rs.getInt("category_id");
                    int shopProductItemID = rs.getInt("shop_product_item_id");
                    int shopID = rs.getInt("shop_id");
                    String image_1 = rs.getString("image_1");
                    Double price = rs.getDouble("price");

                    list.add(new ProductDTO(shopProductItemID, shopID, title, image_1, price, categoryID));
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
    public int getNumberProductPage() throws SQLException {
        
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(PRODUCT_PAGE_NUMBERPAGE);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int total = rs.getInt(1);
                    int countPage = 0;
                    countPage = total/10;
                    if(total % 5 != 0){
                        countPage++;
                    }
                    return countPage;
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
        return 0;
    }
    public List<ProductDTO> getProductPaging(int index) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_PRODUCT_PAGE_PAGING);
                ptm.setInt(1, (index - 1) * 10);
                rs = ptm.executeQuery();
                while (rs.next()) {

                    String title = rs.getString("title");

                    int shopProductItemID = rs.getInt("shop_product_item_id");
                    int shopID = rs.getInt("shop_id");
                    String image_1 = rs.getString("image_1");
                    Double price = rs.getDouble("price");

                    list.add(new ProductDTO(shopProductItemID, shopID, title, image_1, price));
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
    
    public List<ProductDTO> getShopProductItemId(int shop_id) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_SHOP_PRODUCT_ITEM_ID);
                ptm.setInt(1, shop_id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int shopProductItemID = rs.getInt("shop_product_item_id");

                    list.add(new ProductDTO(shopProductItemID));
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

    public List<ProductDTO> getShopProduct(int shop_id) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_SHOP_PRODUCT);
                ptm.setInt(1, shop_id);
                rs = ptm.executeQuery();
                while (rs.next()) {

                    String title = rs.getString("title");
                    String avatar = rs.getString("avatar");
                    String shop_name = rs.getString("shop_name");

                    int shopProductItemID = rs.getInt("shop_product_item_id");
                    int shopID = rs.getInt("shop_id");
                    String image_1 = rs.getString("image_1");
                    Double price = rs.getDouble("price");

                    list.add(new ProductDTO(shopProductItemID, shopID, title, image_1, avatar, price, shop_name));
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

    public List<ProductDTO> findByName(String search, int index) {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                stm = conn.prepareStatement(SEARCH_PRODUCT);
                stm.setString(1, "%" + search + "%");
                stm.setInt(2, (index - 1) * 10);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String title = rs.getString("title");

                    int shopProductItemID = rs.getInt("shop_product_item_id");
                    int shopID = rs.getInt("shop_id");
                    String image_1 = rs.getString("image_1");
                    Double price = rs.getDouble("price");

                    list.add(new ProductDTO(shopProductItemID, shopID, title, image_1, price));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int getNumberSearchPage(String search) throws SQLException {
        
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(COUNT_SEARCH_PRODUCT_PAGE);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int total = rs.getInt(1);
                    int countPage = 0;
                    countPage = total/10;
                    if(total % 5 != 0){
                        countPage++;
                    }
                    return countPage;
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
        return 0;
    }
    
    public int getID(ProductDTO product) throws SQLException, ClassNotFoundException {
        int shopProductItemID = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn = DBUtils.getConnection();
            if(conn != null){
                ptm = conn.prepareStatement(GET_ID);
                ptm.setInt(1, product.getShopID());
                ptm.setInt(2, product.getCategoryID());
                ptm.setInt(3, product.getTypeOfBirdID());
                ptm.setInt(4, product.getInventory());
                ptm.setString(5, product.getShop_name());
                ptm.setDate(6, (Date) product.getUploadDate());
                rs = ptm.executeQuery();
                if(rs.next()){
                    shopProductItemID = rs.getInt("shop_product_item_id");
                }
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs != null) rs.close();
            if(ptm != null) ptm.close();
            if(conn != null) conn.close();
        }
        return shopProductItemID;
    }
    
    public int getNumberCategoryPage(int categoryID) throws SQLException {
        
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CATEGORY_PAGENUMBER);
                ptm.setInt(1, categoryID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int total = rs.getInt(1);
                    int countPage = 0;
                    countPage = total/10;
                    if(total % 5 != 0){
                        countPage++;
                    }
                    return countPage;
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
        return 0;
    }
    public List<ProductDTO> getCategoryPaging(int index, int categoryID) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_CATEGORY_PAGING);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, (index - 1) * 10);
                rs = ptm.executeQuery();
                while (rs.next()) {

                    String title = rs.getString("title");

                    int shopProductItemID = rs.getInt("shop_product_item_id");
                    int shopID = rs.getInt("shop_id");
                    String image_1 = rs.getString("image_1");
                    Double price = rs.getDouble("price");

                    list.add(new ProductDTO(shopProductItemID, shopID, title, image_1, price));
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

    public int getID1() throws SQLException, ClassNotFoundException {
        int shopProductItemID = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ID1);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    shopProductItemID = rs.getInt("shop_product_item_id");
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
        return shopProductItemID;
    }
}
