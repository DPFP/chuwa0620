package collection;

import org.junit.Test;

import java.util.ArrayList;
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
        System.out.println(numbers[1]);
        numbers[1] = 100;
        System.out.println(numbers[1]);
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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 23 };
        System.out.println(Arrays.binarySearch(numbers, 3));
        System.out.println(Arrays.binarySearch(numbers, 11));
        numbers[2] = 200;
        numbers[4] = 1000;
        System.out.println("--------");
        Arrays.sort(numbers);
        for(int num:numbers){
            System.out.println(num);
        }
        numbers[2] = 200;
        numbers[4] = 1000;
        System.out.println("--------");
        Arrays.sort(numbers, 0, 5);
        for(int num:numbers){
            System.out.println(num);
        }
        numbers[2] = 40000;
        numbers[4] = 49999;
        System.out.println("--------");
        Arrays.parallelSort(numbers);
        for(int num:numbers){
            System.out.println(num);
        }
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
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 23 };
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        for(int num:copy){
            System.out.println(num);
        }
        System.out.println("----------------");
        int[] copy2 = Arrays.copyOfRange(numbers, 0,2);
        for(int num:copy2){
            System.out.println(num);
        }
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
        Integer[] nums = {1,2,3,4};
        List<Integer> list = Arrays.asList(nums);
        for(int num:list){
            System.out.println(num);
        }
        Integer[] nums2 = {1,2,3,4};
        Integer[] nums3 = {1,2,3,4, 5};
        System.out.println(Arrays.equals(nums, nums2));
        System.out.println(Arrays.equals(nums, nums3));
        Arrays.fill(nums,2);
        for(int num:nums){
            System.out.println(num);
        }
    }
}