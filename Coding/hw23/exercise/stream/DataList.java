package exercise.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DataList {

    public static List<Product> getProduct() {

        List<Product> productList = new ArrayList<>();

        productList.add(new Product(1L, "n1", "c1", 1.0, new HashSet<>()));
        productList.add(new Product(2L, "n2", "c1", 2.0, new HashSet<>()));
        productList.add(new Product(3L, "n3", "c3", 3.0, new HashSet<>()));
        return productList;
    }

}
