package generic;

public class GenericMethod {
    public static void main(String[] args) {
        System.out.printf("Maximum of %d, %d, and %d is %d.\n\n", 2, 4, 6, MaximumGenericTest.maximum(2,4,6));
        System.out.printf("Maximum of %.1f, %.1f, and %.1f is %.1f.\n\n", 2.4, 4.56, 6.55, MaximumGenericTest.maximum(2.4,4.56,6.55));
        System.out.printf("Maximum of %s, %s, and %s is %s.\n\n", "apple", "tiger", "pear", MaximumGenericTest.maximum("apple","tiger","pear"));
    }
}

class MaximumGenericTest {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z){
        T max = x;
        if(y.compareTo(max)>0){
            max = y;
        }
        if(z.compareTo(max)>0){
            max = z;
        }
        return max;
    }
}