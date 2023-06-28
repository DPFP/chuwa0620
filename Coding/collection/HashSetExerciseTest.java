package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set= new HashSet<>();
        set.add(1);
        Set<Integer> set1= new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set.addAll(set1);
        System.out.println(set.contains(1));
        set.remove(1);
        System.out.println(set);
        set.clear();
        System.out.println(set.isEmpty());

    }
}
