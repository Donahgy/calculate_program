package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

    public static Date formatDate(String str){
        try {
            return sdf.parse(str.trim());
        } catch (ParseException e) {
            throw new IllegalArgumentException("输入日期异常");
        }
    }
}
