import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ProductTest {
    private final BigDecimal minPrice = BigDecimal.valueOf(9.99);
    private final BigDecimal maxPrice = BigDecimal.valueOf(10);
    private final Date minDate = new GregorianCalendar(2040, Calendar.JANUARY, 1).getTime();
    private final Date maxDate = new GregorianCalendar(2077, Calendar.JANUARY, 1).getTime();
    private Product potatoProduct;

    @Before
    public void setUp() {
        potatoProduct = new Product(1, "potato", "upc", "manufacturer", minPrice, minDate, 1) {
        };
    }

    // TODO: Проверить equals
    // TODO: Проверить hashCode
    // TODO: Проверить clone
    // TODO: Проверить compareTo
    // TODO: Проверить toString

    @Test
    public void testToString() {
    }

    @Test
    public void idGetterSetter() {
        var value = 100;
        potatoProduct.setId(value);
        Assertions.assertEquals(potatoProduct.getId(), value);
    }


    @Test
    public void nameGetterSetter() {
        var value = "not potato";
        potatoProduct.setName(value);
        Assertions.assertEquals(potatoProduct.getName(), value);
    }


    @Test
    public void upcGetterSetter() {
        var value = "not upc";
        potatoProduct.setUpc(value);
        Assertions.assertEquals(potatoProduct.getUpc(), value);
    }


    @Test
    public void manufacturerGetterSetter() {
        var value = "not manufacturer";
        potatoProduct.setManufacturer(value);
        Assertions.assertEquals(potatoProduct.getManufacturer(), value);
    }


    @Test
    public void priceGetterSetter() {
        var value = maxPrice;
        potatoProduct.setPrice(value);
        Assertions.assertEquals(potatoProduct.getPrice(), value);
    }


    @Test
    public void shelfLifeGetterSetter() {
        var value = maxDate;
        potatoProduct.setShelfLife(value);
        Assertions.assertEquals(potatoProduct.getShelfLife(), value);
    }

    @Test
    public void quantityGetterSetter() {
        var value = 100;
        potatoProduct.setQuantity(value);
        Assertions.assertEquals(potatoProduct.getQuantity(), value);
    }
}