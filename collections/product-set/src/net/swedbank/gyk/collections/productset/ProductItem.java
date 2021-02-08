package net.swedbank.gyk.collections.productset;

import java.time.LocalDateTime;

public class ProductItem {
    private String id;
    private String name;
    private LocalDateTime salesDate;
    private double amount;

    public ProductItem(String id, String name, LocalDateTime salesDate, double amount) {
        this.id = id;
        this.name = name;
        this.salesDate = salesDate;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getSalesDate() {
        return salesDate;
    }

    public double getAmount() {
        return amount;
    }
}
