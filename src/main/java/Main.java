import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "1 * 显⽰器 : 2399.00"; // 示例输入字符串

        // 定义正则表达式，匹配“数量 * 商品名 : 价格”格式的字符串，商品名可能包含中文字符
        String regex = "(\\d+) \\* (.+?) : (\\d+\\.\\d+)";

        // 编译正则表达式
        Pattern pattern = Pattern.compile(regex);

        // 创建匹配器
        Matcher matcher = pattern.matcher(input);

        // 如果匹配成功，提取匹配到的部分
        if (matcher.find()) {
            String quantity = matcher.group(1); // 数量
            String item = matcher.group(2); // 商品名
            String price = matcher.group(3); // 价格

            // 打印提取到的信息
            System.out.println("数量: " + quantity);
            System.out.println("商品名: " + item);
            System.out.println("价格: " + price);
        } else {
            System.out.println("输入字符串格式不正确。");
        }
    }
}
