package serivce;

import entity.merchandise.Merchandise;
import enums.MerchandiseType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ObtainMerchandiseInfoTest {

    @Test
    void should_handleMerchandiseInfo_success() {
        Merchandise merchandise = ObtainMerchandiseInfo.handleMerchandiseInfo("1 * ipad : 2399.00");
        assertEquals(1, merchandise.getCount());
        assertEquals("ipad", merchandise.getMerchandise_name());
        assertEquals(BigDecimal.valueOf(2399.00), merchandise.getPrice());
        assertEquals(MerchandiseType.ELE, merchandise.getType());
    }

    @Test
    void should_handleMerchandiseInfo_fail_when_invalid_name() {
        assertThrows(IllegalArgumentException.class, () -> ObtainMerchandiseInfo.handleMerchandiseInfo("1 * invalid : 2399.00"));
    }

    @Test
    void should_handleMerchandiseInfo_fail_when_invalid_price() {
        assertThrows(IllegalArgumentException.class, () -> ObtainMerchandiseInfo.handleMerchandiseInfo("1 * ipad : invalid"));
    }

    @Test
    void should_handleMerchandiseInfo_fail_when_invalid_quantity() {
        assertThrows(IllegalArgumentException.class, () -> ObtainMerchandiseInfo.handleMerchandiseInfo("invalid * ipad : 2399.00"));
    }


}