package net.swedbank.gyk.collections.productset;

import java.time.LocalDateTime;
import java.util.Objects;

public class Product {

    private String id;
    private String name;
    private LocalDateTime lastAppearsOn;

    public Product(String id, String name, LocalDateTime lastAppearsOn) {
        this.id = id;
        this.name = name;
        this.lastAppearsOn = lastAppearsOn;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastAppearsOn=" + lastAppearsOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id) && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
