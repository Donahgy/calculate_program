package serivce;

import entity.coupon.DiscountCoupon;
import entity.discount.DisCount;
import entity.merchandise.Merchandise;
import org.junit.jupiter.api.Test;
import utils.DateUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateServiceTest {

    /*

    2013.11.11 | 0.7 | 电子

    1 * ipad : 2399.00
    1 * 显示器 : 1799.00
    12 * 啤酒 : 25.00
    5 * 面包 : 9.00

    2013.11.11
    2014.3.2 1000 200
     */


    @Test
    void success_cal_test() {
        List<DisCount> discount_type_list = new ArrayList<>();
        DisCount disCount = DiscountService.formStr("2013.11.11 | 0.7 | 电子");
        discount_type_list.add(disCount);

        List<Merchandise> merchandise_type_list = new ArrayList<>();
        merchandise_type_list.add(ObtainMerchandiseInfo.handleMerchandiseInfo("1 * ipad : 2399.00"));
        merchandise_type_list.add(ObtainMerchandiseInfo.handleMerchandiseInfo("1 * 显示器 : 1799.00"));
        merchandise_type_list.add(ObtainMerchandiseInfo.handleMerchandiseInfo("12 * 啤酒 : 25.00"));
        merchandise_type_list.add(ObtainMerchandiseInfo.handleMerchandiseInfo("5 * 面包 : 9.00"));
        Date calDate = DateUtils.formatDate("2013.11.11");
        List<DiscountCoupon> discountCouponList = new ArrayList<>();
        discountCouponList.add(DiscountCouponService.handleDiscountCoupon("2014.3.2 1000 200"));

        BigDecimal res = CalculateService.calculate(discount_type_list, merchandise_type_list, calDate, discountCouponList);
        assertEquals(BigDecimal.valueOf(3083.60).setScale(2), res);
    }

    @Test
    void success_cal_2() {
        List<DisCount> discount_type_list = new ArrayList<>();

        List<Merchandise> merchandise_type_list = new ArrayList<>();
        merchandise_type_list.add(ObtainMerchandiseInfo.handleMerchandiseInfo("3 * 蔬菜 : 5.98"));
        merchandise_type_list.add(ObtainMerchandiseInfo.handleMerchandiseInfo("8 * 餐巾纸 : 3.20"));
        Date calDate = DateUtils.formatDate("2014.01.01");
        List<DiscountCoupon> discountCouponList = new ArrayList<>();

        BigDecimal res = CalculateService.calculate(discount_type_list, merchandise_type_list, calDate, discountCouponList);
        assertEquals(BigDecimal.valueOf(43.54).setScale(2), res);
    }

    @Test
    void success_cal_has_2_discount_coupon() {
        List<DisCount> discount_type_list = new ArrayList<>();

        List<Merchandise> merchandise_type_list = new ArrayList<>();
        merchandise_type_list.add(ObtainMerchandiseInfo.handleMerchandiseInfo("3 * 蔬菜 : 5.98"));
        merchandise_type_list.add(ObtainMerchandiseInfo.handleMerchandiseInfo("8 * 餐巾纸 : 3.20"));
        Date calDate = DateUtils.formatDate("2014.01.01");
        List<DiscountCoupon> discountCouponList = new ArrayList<>();
        discountCouponList.add(DiscountCouponService.handleDiscountCoupon("2013.3.2 1000 200"));
        discountCouponList.add(DiscountCouponService.handleDiscountCoupon("2014.3.2 10 2"));

        BigDecimal res = CalculateService.calculate(discount_type_list, merchandise_type_list, calDate, discountCouponList);
        assertEquals(BigDecimal.valueOf(41.54).setScale(2), res);
    }

    @Test
    void test_calculate_with_different_merchandise_types() {
        List<DisCount> discount_type_list = new ArrayList<>();
        discount_type_list.add(DiscountService.formStr("2013.11.11 | 0.7 | 电子"));
        discount_type_list.add(DiscountService.formStr("2013.11.11 | 0.8 | 食品"));

        List<Merchandise> merchandise_type_list = new ArrayList<>();
        merchandise_type_list.add(ObtainMerchandiseInfo.handleMerchandiseInfo("1 * ipad : 2399.00")); // 电子
        merchandise_type_list.add(ObtainMerchandiseInfo.handleMerchandiseInfo("1 * 显示器 : 1799.00")); // 电子
        merchandise_type_list.add(ObtainMerchandiseInfo.handleMerchandiseInfo("12 * 啤酒 : 25.00")); // 食品
        merchandise_type_list.add(ObtainMerchandiseInfo.handleMerchandiseInfo("5 * 面包 : 9.00")); // 食品
        Date calDate = DateUtils.formatDate("2013.11.11");
        List<DiscountCoupon> discountCouponList = new ArrayList<>();
        discountCouponList.add(DiscountCouponService.handleDiscountCoupon("2014.3.2 1000 200"));

        BigDecimal res = CalculateService.calculate(discount_type_list, merchandise_type_list, calDate, discountCouponList);
        assertEquals(BigDecimal.valueOf(3074.60).setScale(2), res);
    }
}