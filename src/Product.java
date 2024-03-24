import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Product implements Cloneable, Serializable, Comparable<Product> {
    // Идентификатор товара
    private int id;
    // Наименование товара
    private String name;
    // Universal Product Code (универсальный код товара)
    private String upc;
    // Производитель товара
    private String manufacturer;
    // Цена товара
    private BigDecimal price;
    // Срок хранения товара (до какой даты)
    private Date shelfLife;
    // Количество товара
    private int quantity;

    public Product(int id, String name, String upc, String manufacturer, BigDecimal price, Date shelfLife, int quantity) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.price = price;
        this.shelfLife = shelfLife;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", upc='" + upc + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", shelfLife=" + shelfLife +
                ", quantity=" + quantity +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Date shelfLife) {
        this.shelfLife = shelfLife;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return (
                getId() == product.getId()
                        && getQuantity() == product.getQuantity()
                        && Objects.equals(getShelfLife(), product.getShelfLife())
                        && Objects.equals(getName(), product.getName())
                        && Objects.equals(getUpc(), product.getUpc())
                        && Objects.equals(getManufacturer(), product.getManufacturer())
                        && Objects.equals(getPrice(), product.getPrice())
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getUpc(), getManufacturer(), getPrice(), getShelfLife(), getQuantity());
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Product o) {
        // Если объект равен
        if (equals(o)) return 0;
        // Если объект не равен, то вычисляем разницу в ID
        return getId() - o.getId();
    }
}
