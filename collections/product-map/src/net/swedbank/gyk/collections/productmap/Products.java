package net.swedbank.gyk.collections.productmap;

import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Products {

    Map<Product, ProductStatistics> productStatistics;

    public Products() {
        productStatistics = new HashMap();
    }

    public static void main(String[] args) throws IOException, ParseException {

        List<ProductItem> productList;

        try {
            productList = Reader.readProducts("products.json");
        } catch (FileNotFoundException e) {
            productList = Reader.readProducts("product-set/products.json");
        }

        Products products = new Products();

        for (ProductItem item : productList) {
            products.addProduct(item.getId(), item.getName(), item.getSalesDate(), item.getAmount());
        }

        System.out.printf("We have sold %d unique items\n", products.numberOfProducts());

        products.printAll();

    }

    //implement this
    private void addProduct(String id, String name, LocalDateTime salesDate, double amount) {
        Product product = new Product(id, name);
        ProductStatistics statistics = new ProductStatistics(salesDate, salesDate, amount);
        if (!productStatistics.containsKey(new Product(id, name))) {
            productStatistics.put(product, statistics);
        } else {
            ProductStatistics updatedStatistics = productStatistics.get(product);
            updatedStatistics.updateLastSalesDate(salesDate);
            updatedStatistics.updateSalesAmount(amount);
        }

    }


    //implement this
    public int numberOfProducts() {
        return productStatistics.size();
    }

    public void printAll() {
        for (Map.Entry<Product, ProductStatistics> productEntry : productStatistics.entrySet()) {
            Product product = productEntry.getKey();
            ProductStatistics stat = productEntry.getValue();

            // implement printing here
            System.out.println(product + " : " + stat);
        }
    }


}
