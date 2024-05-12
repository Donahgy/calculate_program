package main.Main;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MyMain {

    private static String FILE_NAME = "merchandise.txt";
    public static Map<String, String> itemToCategoryMap = new HashMap<>();

    static {
        try {
            InputStream inputStream = MyMain.class.getResourceAsStream("/" + FILE_NAME);
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
                        itemToCategoryMap.put(item.trim(), category);
                    }
                }
            }
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
