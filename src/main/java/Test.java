import entity.discount.DisCount;
import entity.merchandistype.MerchandiseType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) throws ParseException {



        // 输入折扣消息
        Scanner scanner = new Scanner(System.in);

        // 处理节假日商品折扣信息
        List<DisCount> discount_type_list = new ArrayList<>();
        while (true)
        {
            // 输入折扣信息
            String s = scanner.nextLine();
            if (s.isEmpty())
            {
                break;
            }
            String[] discount = s.split("\\|");
            if (discount.length != 3)
            {
                // TODO 异常信息需要处理
            }
            else
            {
                for (int i = 0; i < discount.length; i++)
                {
                    DisCount disCount = new DisCount();
                    String s1 = discount[i].trim();
                    // 当i=0时，表示数组的第一个元素为日期
                    if (i == 0)
                    {
                        disCount.setDate(sdf.parse(s1));
                    }
                    // 当i=1时，表示数组的第二个元素为打折数
                    if (i == 1)
                    {
                        disCount.setDiscount(Double.parseDouble(s1));
                    }
                    // 当i=2时，表示数组的第三个元素为类别信息
                    if (i == 2)
                    {
                        disCount.setMerchandiseType(new MerchandiseType(s1));
                    }
                    discount_type_list.add(disCount);
                }
            }
        }

        System.out.println(discount_type_list);

        // 输入商品数量及单价信息
        List<String> count_merchandises = new ArrayList<>();
        while (true)
        {
            String merchandise = scanner.nextLine();
            if (merchandise.isEmpty())
            {
                break;
            }
            count_merchandises.add(merchandise);
        }

        // 结算日期
        String date = scanner.nextLine();

        // 输入优惠券信息
        String discount_coupon = scanner.nextLine();

        // 输出

    }
}
