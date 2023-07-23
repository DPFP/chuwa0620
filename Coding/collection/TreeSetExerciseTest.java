package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set= new TreeSet<>();
        set.add(5);
        set.add(2);
        set.add(7);
        set.add(9);
        System.out.println(set);
        Set<Integer> set1= new TreeSet<>();
        set1.add(1);
        set.addAll(set1);
        System.out.println(set);
        System.out.println(((TreeSet<Integer>) set).first());
        System.out.println(((TreeSet<Integer>) set).last());
        Set<Integer> set2 = ((TreeSet<Integer>) set).subSet(2,4);
        System.out.println(set2);

        System.out.println(((TreeSet<Integer>) set).headSet(3));
        System.out.println(((TreeSet<Integer>) set).tailSet(6));
        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
}
