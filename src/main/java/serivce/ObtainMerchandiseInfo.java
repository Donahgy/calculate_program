package serivce;

import entity.merchandise.Merchandise;
import enums.MerchandiseType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

import static constants.ItemCategory.ITEM_TO_CATEGORY_MAP;

/**
 * 获取商品信息
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ObtainMerchandiseInfo {

    public static Merchandise handleMerchandiseInfo(String str) {
        String name = handleName(str);
        MerchandiseType merchandiseType = handleType(name);
        Integer count = handlePurchaseQuantity(str);
        BigDecimal price = handlePrice(str);
        return new Merchandise(name, price, count, merchandiseType);
    }

    private static MerchandiseType handleType(String name) {
        String categoryName = ITEM_TO_CATEGORY_MAP.get(name);
        return MerchandiseType.formSt(categoryName);
    }

    private static String handleName(String str) {
        String name = str.split("\\*")[1].split(":")[0].trim();
        if (!ITEM_TO_CATEGORY_MAP.containsKey(name)) {
            throw new IllegalArgumentException("所购产品不合法，请检查后重新输入");
        }
        return name;
    }

    private static BigDecimal handlePrice(String str) {
        String priceStr = str.split("\\*")[1].split(":")[1];
        if (Objects.nonNull(priceStr)) {
            double prices;
            try {
                prices = Double.parseDouble(priceStr.trim());
                if (0 < prices) {
                    return BigDecimal.valueOf(prices);
                } else {
                    throw new IllegalArgumentException("输入的商品单价不合法，请检查后重新输入");
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("输入的商品单价不合法，请检查后重新输入");
            }
        }
        throw new IllegalArgumentException("所采购的商品不在商品清单中，请检查后重新输入");
    }


    private static int handlePurchaseQuantity(String str) {
        try {
            String purchaseQuantity = str.split("\\*")[0];
            return Integer.parseUnsignedInt(purchaseQuantity.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("采购数量只能为正整数，请检查后重新输入");
        }
    }
}
