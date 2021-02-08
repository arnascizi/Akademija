package net.swedbank.gyk.collections.productset;

import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Products {

    Set<Product> products;

    public Products() {
        products = new HashSet<>();
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
            products.addProduct(item.getId(), item.getName(), item.getSalesDate());
        }

        System.out.printf("We have sold %d unique items\n", products.numberOfProducts());
        products.printAll();


    }

    //implement this
    private void addProduct(String id, String name, LocalDateTime salesDate) {
        Product newProduct = new Product(id, name, salesDate);
        for (Product product : products) {
            if (product.equals(newProduct)) {
                System.out.println("Item exists");
                return;
            }
        }
        products.add(newProduct);
    }


    //implement this
    public int numberOfProducts() {
        return products.size();
    }

    public void printAll() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
