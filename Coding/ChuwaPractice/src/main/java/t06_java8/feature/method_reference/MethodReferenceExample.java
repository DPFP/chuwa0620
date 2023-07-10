package t06_java8.feature.method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceExample {

    public static void main(String[] args) {
        // 1. 静态方法引用
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));
        people.sort((p1,p2) -> Person.compareByName(p1, p2));

        people.sort(Person::compareByName);

        Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge);
        people.sort(byAgeComparator);

        Function<Person, String> getNameFunction = Person::getName;
        List<String> names = ArrayList<String>
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int compareByName(Person p1, Person p2) {
        return p1.name.compareTo(p2.name);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
