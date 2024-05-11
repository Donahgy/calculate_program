package serivce;

import entity.merchandise.Merchandise;
import entity.merchandistype.MerchandiseType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取商品信息
 */
public class ObtainMerchandiseInfo {

    static MerchandiseType electronicMerchandiseType = new MerchandiseType();
    static MerchandiseType foodMerchandiseType = new MerchandiseType();
    static MerchandiseType dailyMerchandiseType = new MerchandiseType();
    static MerchandiseType drinksMerchandiseType = new MerchandiseType();

    static {
        electronicMerchandiseType.setMerchandiseName("电子");
    }

    public Merchandise obtainMerchandiseInfo(String merchandiseStr) {
        Merchandise merchandise = new Merchandise();
        // 定义正则表达式，匹配“数量 * 商品名 : 价格”格式的字符串，商品名可能包含中文字符
        String regex = "(\\d+) \\* (.+?) : (\\d+\\.\\d+)";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);
        // 创建匹配器
        Matcher matcher = pattern.matcher(merchandiseStr);
        // 如果匹配成功，提取匹配到的部分
        if (matcher.find()) {
            String quantity = matcher.group(1); // 数量
            String merchandiseName = matcher.group(2); // 商品名
            String price = matcher.group(3); // 价格

            merchandise.setPrice(Double.parseDouble(price));
            merchandise.setCount(Integer.parseInt(quantity));
            merchandise.setMerchandise_name(merchandiseName);

        } else {
            System.out.println("输入字符串格式不正确。");
        }
        return merchandise;
    }
}
