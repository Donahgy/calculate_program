import entity.coupon.DiscountCoupon;
import entity.discount.DisCount;
import entity.merchandise.Merchandise;
import serivce.CalculateService;
import serivce.DiscountService;
import serivce.ObtainMerchandiseInfo;
import utils.DateUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

import static serivce.DiscountCouponService.handleDiscountCoupon;
import static serivce.ObtainMerchandiseInfo.handleMerchandiseInfo;

public class Test {

    public static void main(String[] args) throws ParseException {


        //2013.11.11 | 0.7 | 电⼦
        // 输入折扣消息
        Scanner scanner = new Scanner(System.in);
        List<DisCount> discount_type_list = new ArrayList<>();
        while (true) {
            // 输入折扣信息
            String s = scanner.nextLine();
            if (s.isEmpty()) {
                break;
            }
            DisCount disCount = DiscountService.formStr(s);
            discount_type_list.add(disCount);
        }

        List<Merchandise> merchandise_type_list = new ArrayList<>();

        // 1 * ipad : 2399.00
        while (true) {
            // 输入所购商品信息
            String s = scanner.nextLine();
            if (s.isEmpty()) {
                break;
            }
            merchandise_type_list.add(handleMerchandiseInfo(s));
        }


        // 结算日期
        String date = scanner.nextLine();
        Date calDate = DateUtils.formatDate(date);


        // 输出
        List<DiscountCoupon> discountCouponList = new ArrayList<>();
        while (true) {
            // 输入所购商品信息
            String s = scanner.nextLine();
            if (s.isEmpty()) {
                break;
            }
            discountCouponList.add(handleDiscountCoupon(s));
        }

        BigDecimal res = CalculateService.calculate(discount_type_list, merchandise_type_list, calDate, discountCouponList);
        System.out.println(res);
    }
}
