/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.report;

/**
 *
 * @author Admin
 */
public class ReportShopDTO {
    int reported_shop_id;
    int shop_id;
    int custommer_id;
    String detail;
    int reported_reson;

    public ReportShopDTO() {
    }

    public ReportShopDTO(int reported_shop_id, int shop_id, int custommer_id, String detail, int reported_reson) {
        this.reported_shop_id = reported_shop_id;
        this.shop_id = shop_id;
        this.custommer_id = custommer_id;
        this.detail = detail;
        this.reported_reson = reported_reson;
    }

    public ReportShopDTO(int shop_id, int custommer_id, String detail, int reported_reson) {
        this.shop_id = shop_id;
        this.custommer_id = custommer_id;
        this.detail = detail;
        this.reported_reson = reported_reson;
    }

    public int getReported_shop_id() {
        return reported_shop_id;
    }

    public void setReported_shop_id(int reported_shop_id) {
        this.reported_shop_id = reported_shop_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getCustommer_id() {
        return custommer_id;
    }

    public void setCustommer_id(int custommer_id) {
        this.custommer_id = custommer_id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getReported_reson() {
        return reported_reson;
    }

    public void setReported_reson(int reported_reson) {
        this.reported_reson = reported_reson;
    }
    
    
}
