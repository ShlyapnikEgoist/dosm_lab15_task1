import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ProductService {
    private final List<Product> products;

    public ProductService(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProductsByName(String name) {
        // Используем stream
        // по статье https://www.baeldung.com/java-copy-list-to-another#using-java-8
        return products.stream()
                .filter(product -> Objects.equals(product.getName(), name))
                .toList();
    }

    public List<Product> getProductsByNameWithLessOrEqualPrice(String name, BigDecimal highPrice) {
        return products.stream()
                .filter(product -> Objects.equals(product.getName(), name))
                // firstBigDecimal.compareTo(secondBigDecimal) <= 0  // "<="
                // https://stackoverflow.com/questions/34677644/how-to-use-comparison-operators-like-on-bigdecimal
                .filter(product -> product.getPrice().compareTo(highPrice) <= 0)
                .toList();
    }

    public List<Product> getProductsAfterShelfDate(Date minShelfDate) {
        return products.stream()
                .filter(product -> product.getShelfLife().compareTo(minShelfDate) > 0)
                .toList();
    }
}
