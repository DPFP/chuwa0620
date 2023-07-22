import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = List.of(20, 3, 78, 9, 6, 53, 73, 99, 24, 32);
        list.stream().mapToInt(n->n.intValue()).average().orElse(0.0);
    }

}