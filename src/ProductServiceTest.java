import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Stream;

public class ProductServiceTest {
    String potatoProductName = "potato";
    BigDecimal minPrice = BigDecimal.valueOf(9.99);
    BigDecimal maxPrice = BigDecimal.valueOf(10);

    Date minDate = new GregorianCalendar(2040, Calendar.JANUARY, 1).getTime();
    Date maxDate = new GregorianCalendar(2077, Calendar.JANUARY, 1).getTime();

    Product potatoMinPriceMinDate = new Product(1, potatoProductName, "upc", "manufacturer", minPrice, minDate, 1) {
    };
    Product potatoMaxPriceMinDate = new Product(2, potatoProductName, "upc", "manufacturer", maxPrice, minDate, 1) {
    };
    Product notPotatoMinPriceMaxDate = new Product(2077, "not potato", "upc", "manufacturer", minPrice, maxDate, 1) {
    };
    List<Product> products = Stream.of(
                    potatoMinPriceMinDate,
                    potatoMaxPriceMinDate,
                    notPotatoMinPriceMaxDate
            )
            .toList();
    ProductService service = new ProductService(products);

    @Test
    public void getProductsByNameTest() {
        var targetProducts = Stream.of(
                        potatoMinPriceMinDate,
                        potatoMaxPriceMinDate
                )
                .toList();
        var productsByName = service.getProductsByName(potatoProductName);
        Assertions.assertEquals(productsByName, targetProducts);
    }

    @Test
    public void getProductsByNameAndPriceTest() {
        var targetProducts = Stream.of(
                        potatoMinPriceMinDate
                )
                .toList();
        var productsByNameAndMinPrice = service.getProductsByNameWithLessOrEqualPrice(potatoProductName, minPrice);
        Assertions.assertEquals(productsByNameAndMinPrice, targetProducts);
    }

    @Test
    public void getProductsByShelfDateTest() {
        var targetProducts = Stream.of(
                        notPotatoMinPriceMaxDate
                )
                .toList();
        var productsByShelfDate = service.getProductsAfterShelfDate(minDate);
        Assertions.assertEquals(productsByShelfDate, targetProducts);
    }
}
