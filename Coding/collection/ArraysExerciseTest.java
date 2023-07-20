package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(numbers[0]);
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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(Arrays.binarySearch(numbers, 4));
        int[] numbers2 = { 4, 2, 123, 4, 5, 6, 55, 23, 9, 10 };
        Arrays.sort(numbers2);
        System.out.println(Arrays.toString(numbers2));
        int[] numbers3 = { 4, 2, 123, 4, 5, 6, 55, 23, 9, 10 };
        Arrays.sort(numbers3, 3, 9);
        System.out.println(Arrays.toString(numbers3));
        Arrays.parallelSort(numbers3);
        System.out.println(Arrays.toString(numbers3));
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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] numbers1 = Arrays.copyOf(numbers, 4);
        System.out.println(Arrays.toString(numbers1));
        int[] numbers2 = Arrays.copyOfRange(numbers, 2, 5);
        System.out.println(Arrays.toString(numbers2));
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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<int[]> list = Arrays.asList(numbers);
        System.out.println(list.get(0)[0]);
        int[] numbers1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(Arrays.equals(numbers, numbers1));
        int[] numbers2 = new int[5];
        Arrays.fill(numbers2,3);
        System.out.println(Arrays.toString(numbers2));
    }
}
