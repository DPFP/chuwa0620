package t06_java8.feature.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApiIntermediateOperation {
    public void testFilter() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = col.stream();
        stream.filter(t -> t % 2 == 0).forEach(System.out::println);

        List<Employee> employees = new ArrayList<>();
        Stream<String> name = employees.stream().map(Employee::gerName);
        name.filter(n -> n.length() > 3).forEach(System.out::println);
    }

    public void testLimit() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.stream().limit(3).forEach(System.out::println);
    }

    public void testSkip() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.stream().skip(2).forEach(System.out::println);
    }
    public void testDistinct() {
        int[] arr = new int[]{1, 2, 3, 4, 4, 2, 5};
        IntStream st = Arrays.stream(arr);
        st.distinct().forEach(System.out::println);
    }
    public void testFlatMap() {
        List<String> lists1 = Arrays.asList("1", "2", "33", "4", "5");
        List<String> lists2 = Arrays.asList("6", "7", "8", "9", "10");
        List<List<String>> listsOfStrings = new ArrayList<>();
        listsOfStrings.add(lists1);
        listsOfStrings.add(lists2);
        // 2. 分步骤使用flatmap找到最大值。 为了方便理解
        System.out.println("**** 分步骤使用flatmap找到最大值 *****");
        // 2.1 把一个二维的strign flatten为一个string stream对象。 注意flatMap里，input是list, 输出是list转换的stream对象。
        Stream<String> stringStream = listsOfStrings.stream().flatMap(list -> list.stream());
        // 2.1.1 如果是使用普通map，则生成的是Stream<Stream>对象
        Stream<Stream<String>> streamStream = listsOfStrings.stream().map(list -> list.stream());
        // 2.2 将string 转为int数组，然后找出max值，此时max()方法返回的是Optional<Integer>
        OptionalInt max = stringStream.mapToInt(Integer::parseInt).max();
        // 2.3 从Optional里拿出int数值。
        int asInt = max.getAsInt();
        System.out.println(asInt);
        int asInt1 = listsOfStrings.stream().flatMap(list -> list.stream())
                .mapToInt(Integer::parseInt)
                .max().getAsInt();
    }
    public void testIntermediateOperationChain() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        // 找出list2中的偶数，并乘以10
        List<Integer> collect = list2.stream().filter(t -> t % 2 == 0)
                .map(t -> t * 10)
                .collect(Collectors.toList());
    }

    public void testSorted() {
        List<Integer> list = Arrays.asList(87, 2, 65, 34, 72, 12);
        list.stream().sorted().forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);
    }
}
