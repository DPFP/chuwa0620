package exercise.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
public class Product {
    private Long id;

    private String name;
    private String category;
    private Double price;

    private Set<Order> orders;
}