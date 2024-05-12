package serivce;

import entity.coupon.DiscountCoupon;
import entity.discount.DisCount;
import entity.merchandise.Merchandise;
import enums.MerchandiseType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;

@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class CalculateService {

    public static BigDecimal calculate(List<DisCount> disCountList,
                                       List<Merchandise> merchandiseList,
                                       Date calDate,
                                       List<DiscountCoupon> discountCouponList) {

        Map<MerchandiseType, List<DisCount>> disCountMap = disCountList.stream()
                .filter(it -> calDate.compareTo(it.getDate()) == 0)
                .collect(groupingBy(DisCount::getMerchandiseType));


        BigDecimal res = merchandiseList.stream()
                .map(it -> {
                    BigDecimal currentPrice = it.getPrice().multiply(BigDecimal.valueOf(it.getCount()));
                    if (disCountMap.containsKey(it.getType())) {
                        List<DisCount> disCounts = disCountMap.get(it.getType());

                        Double discount = disCounts.get(0).getDiscount();
                        return currentPrice.multiply(BigDecimal.valueOf(discount));
                    } else {
                        return currentPrice;
                    }
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        discountCouponList.sort(Comparator.comparing(DiscountCoupon::getDate));
        Optional<DiscountCoupon> first = discountCouponList.stream()
                .filter(it -> calDate.before(it.getDate()))
                .findFirst();

        if (!first.isPresent()) {
            return res.setScale(2, RoundingMode.HALF_UP);
        }
        DiscountCoupon discountCoupon = first.get();
        if (res.compareTo(discountCoupon.getEnoughDiscount()) >= 0) {
            return res.subtract(discountCoupon.getMinusCount()).setScale(2, RoundingMode.HALF_UP);
        }
        return res.setScale(2, RoundingMode.HALF_UP);
    }

}
