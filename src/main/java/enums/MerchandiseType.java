package enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum MerchandiseType {

    ELE("电子"),//
    FOOD("食品"),//
    DAILY_NECESSITIES("日用品"),//
    WINE("酒类")//
    ;

    private final String typeName;


    public static MerchandiseType formSt(String str) {
        return Arrays.stream(MerchandiseType.values())
                .filter(type -> type.getTypeName().equals(str))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("type is not illegal"));
    }
}
