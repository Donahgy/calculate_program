package serivce;

import entity.discount.DisCount;
import enums.MerchandiseType;
import utils.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DiscountService {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");


    public static DisCount formStr(String str) {

        String[] split = str.split("\\|");
        if (split.length != 3) {
            throw new IllegalArgumentException("解析折扣异常");
        }
        Date date = getDistontDate(split);
        double discount = getDiscount(split);
        MerchandiseType merchandiseType = getType(split);

        return new DisCount(date, discount, merchandiseType);
    }

    private static MerchandiseType getType(String[] split) {
        return MerchandiseType.formSt(split[2].trim());
    }

    private static double getDiscount(String[] split) {
        try {
            double discount = Double.parseDouble(split[1].trim());
            if (discount > 0 && discount <= 1) {
                return discount;
            }
            else {
                throw new IllegalArgumentException("折扣点异常");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("折扣点异常");
        }
    }

    private static Date getDistontDate(String[] split) {
        return DateUtils.formatDate(split[0].trim());
    }
}
