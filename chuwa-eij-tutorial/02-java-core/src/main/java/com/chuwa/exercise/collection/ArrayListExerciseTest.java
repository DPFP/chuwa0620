package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

import static java.util.Collections.addAll;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
        List<Integer> l2 = new ArrayList<>();
        l2.addAll(l);
        System.out.println(l2);

    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        List<String> l = new ArrayList<>(Arrays.asList("abc","cba","acd"));

    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        List<Integer> l = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        var it = l.iterator();
        while (it.hasNext()) {
            var ele = it.next();
            if (ele == 3)it.remove();
        }
        System.out.println(l);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> l = new ArrayList<>(Arrays.asList(1,2,3));
        Collections.sort(l);
        System.out.println(l);
        Collections.sort(l, Comparator.reverseOrder());
        System.out.println(l);
    }
}
