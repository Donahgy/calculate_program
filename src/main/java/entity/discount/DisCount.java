package entity.discount;

import enums.MerchandiseType;
import lombok.*;

import java.util.Date;

/**
 *  折扣类
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DisCount {

    // 日期
    private Date date;

    // 折扣
    private Double discount;

    // 折扣类型
    private MerchandiseType merchandiseType;
}
