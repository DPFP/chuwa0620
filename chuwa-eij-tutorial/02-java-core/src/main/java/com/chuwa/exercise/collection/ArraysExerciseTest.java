package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class ArraysExerciseTest {

    /**
     * e.g.
     * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
     * numbers[?]
     *
     * numbers[?] = #
     */

    @Test
    public void learn_Inserting_And_Retrieving() {

    }

    /**
     * binarySearch()
     * e.g.
     * Arrays.binarySearch(numbers, 4);
     *
     * sort(array)
     * sort(array, fromIndex, toIndex)
     * e.g.
     * Arrays.sort(numbers);
     *
     * Arrays.parallelSort(numbers);
     */
    @Test
    public void learn_search_and_sort() {
        int[] arr = new int[]{-4,-3,-2,-1,0,1,2,3,4};
        int target = Arrays.binarySearch(arr, 0);
        System.out.println(target);
    }

    /**
     * copyOf()
     * e.g.
     * Arrays.copyOf(numbers, numbers.length);
     *
     * copyOfRange()
     * e.g.
     * Arrays.copyOfRange(numbers, 0, 5);
     */
    @Test
    public void learn_copy_of_array() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = Arrays.copyOf(arr, arr.length);
        arr[0] = 10;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = Arrays.copyOfRange(arr, 0, 1);
        System.out.println(Arrays.toString(arr3));
    }

    /**
     * asList()
     * e.g.
     * List<Integer> list = Arrays.asList(numbers);
     *
     * equals()
     * e.g.
     * Arrays.equals(numbers1, numbers2);
     *
     * fill()
     * e.g.
     * Arrays.fill(numbers, 20);
     *
     */

    @Test
    public void learn_common_operations() {

        People[] l1 = new People[3];
        People[] l2 = new People[3];
        People p = new People(18,"Lichu");
        Arrays.fill(l1, p);
        l2 = Arrays.copyOf(l1, l1.length);
        p.setAge(20);

        for (var i : l1) {
            System.out.println(i);
        }
        System.out.println();
        for (var i : l2) {
            System.out.println(i);
        }
    }
}

class People {
    int age;
    String name;

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
