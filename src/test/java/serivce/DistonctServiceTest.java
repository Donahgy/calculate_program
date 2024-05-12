package serivce;

import entity.discount.DisCount;
import enums.MerchandiseType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistonctServiceTest {

    @Test
    void should_success() {
        DisCount disCount = DiscountService.formStr("2013.11.11 | 0.7 | 电子");
        assertEquals(0.7, disCount.getDiscount());
        assertEquals(MerchandiseType.ELE, disCount.getMerchandiseType());
    }
    @Test
    void test_formStr_invalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            DiscountService.formStr("2022.12.31 0.8 理论");
        });
    }

    @Test
    void test_formStr_invalidDiscount() {
        assertThrows(IllegalArgumentException.class, () -> {
            DiscountService.formStr("2022.12.31|1.2|理论");
        });
    }

    @Test
    void test_formStr_invalidMerchandiseType() {
        assertThrows(IllegalArgumentException.class, () -> {
            DiscountService.formStr("2022.12.31|0.8|理论");
        });
    }

}