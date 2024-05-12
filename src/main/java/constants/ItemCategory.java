package constants;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ItemCategory {

    public static Map<String, String> ITEM_TO_CATEGORY_MAP = new HashMap<>();

    static {
        try {
            String FILE_NAME = "merchandise.txt";
            InputStream inputStream = ItemCategory.class.getResourceAsStream("/" + FILE_NAME);
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            String line;
            while ((line = fileReader.readLine()) != null) {

                // 处理每一行，分割分类和物品列表
                String[] parts = line.split("：");
                if (parts.length == 2) {
                    String category = parts[0].trim();
                    String[] items = parts[1].split("，");
                    // 建立物品到分类的映射
                    for (String item : items) {
                        ITEM_TO_CATEGORY_MAP.put(item.trim(), category);
                    }
                }
            }
            fileReader.close();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
