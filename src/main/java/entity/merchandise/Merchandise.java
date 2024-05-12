package entity.merchandise;

import enums.MerchandiseType;
import lombok.*;

import java.math.BigDecimal;

/**
 * 商品类
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Merchandise {

    // 商品名称
    private String merchandise_name;

    // 商品单价
    private BigDecimal price;

    // 所买的商品总数
    private Integer count;

    private MerchandiseType type;
}
