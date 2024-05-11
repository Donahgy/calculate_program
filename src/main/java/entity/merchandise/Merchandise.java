package entity.merchandise;

import entity.merchandistype.MerchandiseType;

/**
 *  商品类
 */
public class Merchandise {

    // 商品名称
    private String merchandise_name;

    // 商品单价
    private Double price;

    // 所买的商品总数
    private Integer count;

    public Merchandise() {
    }

    public Merchandise(String merchandise_name, Double price,Integer count) {
        this.merchandise_name = merchandise_name;
        this.price = price;
        this.count = count;
    }

    public String getMerchandise_name() {
        return merchandise_name;
    }

    public void setMerchandise_name(String merchandise_name) {
        this.merchandise_name = merchandise_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
