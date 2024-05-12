package serivce;

import entity.discount.DisCount;
import enums.MerchandiseType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DIstonctServiceTest {

    @Test
    void should_success() {
        DisCount disCount = DiscountService.formStr("2013.11.11 | 0.7 | 电子");

        assertEquals(0.7, disCount.getDiscount());
        assertEquals(MerchandiseType.ELE, disCount.getMerchandiseType());
    }


}