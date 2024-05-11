package entity.discount;

import entity.merchandistype.MerchandiseType;

import java.util.Date;

/**
 *  折扣类
 */
public class DisCount {

    // 日期
    private Date date;

    // 折扣
    private Double discount;

    // 折扣类型
    private MerchandiseType merchandiseType;

    public DisCount() {
    }

    public DisCount(Date date, Double discount, MerchandiseType merchandiseType) {
        this.date = date;
        this.discount = discount;
        this.merchandiseType = merchandiseType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public MerchandiseType getMerchandiseType() {
        return merchandiseType;
    }

    public void setMerchandiseType(MerchandiseType merchandiseType) {
        this.merchandiseType = merchandiseType;
    }
}
