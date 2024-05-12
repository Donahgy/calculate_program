package entity.coupon;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠券实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DiscountCoupon {

    // 优惠券截至日期
    private Date date;

    // 需要满足减免的总价
    private BigDecimal enoughDiscount;

    // 减免的价钱
    private BigDecimal minusCount;

}
