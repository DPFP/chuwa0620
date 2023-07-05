package exercise.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExercise {
    public static void main(String[] args) {
        filterTest();
        sortTest();
        mapTest();
        groupByTest();
        mapTest2();
        groupByTest2();
        groupByTest3();
    }

    public static void filterTest() {
        List<Product> result = DataList.getProduct()
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("c1"))
                .filter(p -> p.getPrice() > 1)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    public static void sortTest() {
        Optional<Product> result = DataList.getProduct()
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("c1"))
                .min(Comparator.comparing(Product::getPrice));
//                .sorted(Comparator.comparing(Product::getPrice))
//                .findFirst();
        System.out.println(result);
    }

    public static void mapTest() {
        Map<Long, String> result = DataList.getProduct()
                .stream()
                .collect(Collectors.toMap(
                        product -> product.getId(),
                        product -> product.getName()
                ));
        System.out.println(result);
    }

    public static void groupByTest() {
        Map<String, List<Product>> result = DataList.getProduct()
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println(result);
    }


    public static void mapTest2() {
        Map<Product, String> result = DataList.getProduct()
                .stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        product -> product.getCategory()
                ));
        System.out.println(result);
    }

    public static void groupByTest2() {
        Map<String, List<String>> result = DataList.getProduct()
                .stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(product -> product.getName(), Collectors.toList())
                        ));
        System.out.println(result);
    }

    public static void groupByTest3() {
        Map<String, Optional<Product>> result = DataList.getProduct()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.maxBy(Comparator.comparing(Product::getPrice))));
        System.out.println(result);
    }



}
