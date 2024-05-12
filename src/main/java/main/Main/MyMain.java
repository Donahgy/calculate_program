package main.Main;

import entity.merchandise.Merchandise;
import enums.MerchandiseType;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MyMain {

    public static List<Merchandise> merchandiseInfoList = new ArrayList<>();

    static Map<MerchandiseType, List<Merchandise>> map = new HashMap<>();
    public static List<String> allMerchandiseNames = new ArrayList<>();

    private static String FILE_NAME = "merchandise.txt";
    public static Map<String, String> itemToCategoryMap = new HashMap<>();

    static {
//        try {
//            // 获取默认的类加载器
//            ClassLoader classLoader = MyMain.class.getClassLoader();
//            // 获取到需要加载的文件所在的所有url
//            Enumeration<URL> urls = (classLoader != null ?
//                    classLoader.getResources(FILE_NAME) :
//                    ClassLoader.getSystemResources(FILE_NAME));
//            // 遍历获取到的文件url信息
//            while (urls.hasMoreElements()) {
//                // 封装对应的url信息
//                URL url = urls.nextElement();
//                String file1 = url.getFile();
//                // 解析文件信息
//                File file = new File(file1);
//                BufferedReader fileReader = new BufferedReader(new FileReader(file));
//                String line;
//                while ((line = fileReader.readLine()) != null) {
//                    // 处理每一行，分割分类和物品列表
//                    String[] parts = line.split("：");
//                    if (parts.length == 2) {
//                        String category = parts[0].trim();
//                        String[] items = parts[1].split("，");
//                        // 建立物品到分类的映射
//                        for (String item : items) {
//                            itemToCategoryMap.put(item.trim(), category);
//                        }
//                    }
//                }
//                fileReader.close();
//                System.out.println(itemToCategoryMap);
//            }
//
//        } catch (Exception e) {
//            throw new IllegalArgumentException("");
//        }
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
