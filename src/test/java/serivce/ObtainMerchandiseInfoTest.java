package serivce;


import entity.merchandise.Merchandise;
import enums.MerchandiseType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObtainMerchandiseInfoTest {

    @Test
    void should_sucess() {

        /*
        1 * ipad : 2399.00
        1 * 显示器 : 1799.00
        12 * 啤酒 : 25.00
        5 * 面包 : 9.00
         */
        Merchandise merchandise = ObtainMerchandiseInfo.handleMerchandiseInfo("1 * ipad : 2399.00");

        assertEquals(1, merchandise.getCount());
        assertEquals("ipad", merchandise.getMerchandise_name());
        assertEquals(BigDecimal.valueOf(2399.00), merchandise.getPrice());
        assertEquals(MerchandiseType.ELE, merchandise.getType());
    }
}