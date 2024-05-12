package serivce;

import entity.coupon.DiscountCoupon;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DiscountCouponServiceTest {


    @Test
    void test_handleDiscountCoupon_emptyString() {
        assertThrows(IllegalArgumentException.class, () -> {
            DiscountCouponService.handleDiscountCoupon("");
        });
    }

    @Test
    void test_handleDiscountCoupon_incorrectFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            DiscountCouponService.handleDiscountCoupon("2014.3.2 1000");
        });
    }

    @Test
    void test_handleDiscountCoupon_enoughDiscountGreaterThanMinusCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            DiscountCouponService.handleDiscountCoupon("2014.3.2 200 1000");
        });
    }

    @Test
    void test_handleDiscountCoupon_validString() {
        String validInput = "2022.12.31 200 100";
        DiscountCoupon result = DiscountCouponService.handleDiscountCoupon(validInput);
        assertNotNull(result);
        assertEquals(new BigDecimal("200.0"), result.getEnoughDiscount());
        assertEquals(new BigDecimal("100.0"), result.getMinusCount());
    }

    @Test
    void test_handleDiscountCoupon_enoughDiscountLessThanMinusCount() {
        String validInput = "2022.12.31 200 100";
        assertDoesNotThrow(() -> DiscountCouponService.handleDiscountCoupon(validInput));
    }
}