package serivce;

import entity.coupon.DiscountCoupon;
import utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

public class DiscountCouponService {


    public static DiscountCoupon handleDiscountCoupon(String str) {
        Date disountCouponDate = handleDate(str);
        BigDecimal enoughDiscount = handleEnoughDiscount(str);
        BigDecimal minusCount = handleMinusCount(str);

        if (enoughDiscount.compareTo(minusCount) < 0) {
            throw new IllegalArgumentException("满减异常");
        }

        return new DiscountCoupon(disountCouponDate, enoughDiscount, minusCount);
    }

    private static Date handleDate(String str) {

        String s = str.trim().split(" ")[0].trim();
        return DateUtils.formatDate(s);
    }

    private static BigDecimal handleEnoughDiscount(String str) {
        try {
            String purchaseQuantity = str.trim().split(" ")[1];
            double aDouble = Double.parseDouble(purchaseQuantity);
            return BigDecimal.valueOf(aDouble);
        } catch (Exception e) {
            throw new IllegalArgumentException("输入异常 请检查后重新输入");
        }

    }

    private static BigDecimal handleMinusCount(String str) {
        try {
            String purchaseQuantity = str.trim().split(" ")[2];
            double aDouble = Double.parseDouble(purchaseQuantity);
            return BigDecimal.valueOf(aDouble);
        } catch (Exception e) {
            throw new IllegalArgumentException("输入异常 请检查后重新输入");
        }

    }


}
