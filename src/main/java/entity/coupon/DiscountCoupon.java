package entity.coupon;

import javax.xml.crypto.Data;

/**
 *  优惠券实体类
 */
public class DiscountCoupon {

    // 优惠券截至日期
    private Data date;

    // 需要满足减免的总价
    private Double enoughDiscount;

    // 减免的价钱
    private Double minusCount;

    public DiscountCoupon() {
    }

    public DiscountCoupon(Data date, Double enoughDiscount, Double minusCount) {
        this.date = date;
        this.enoughDiscount = enoughDiscount;
        this.minusCount = minusCount;
    }

    public Data getDate() {
        return date;
    }

    public void setDate(Data date) {
        this.date = date;
    }

    public Double getEnoughDiscount() {
        return enoughDiscount;
    }

    public void setEnoughDiscount(Double enoughDiscount) {
        this.enoughDiscount = enoughDiscount;
    }

    public Double getMinusCount() {
        return minusCount;
    }

    public void setMinusCount(Double minusCount) {
        this.minusCount = minusCount;
    }
}
