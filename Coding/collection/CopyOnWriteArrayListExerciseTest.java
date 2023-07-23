package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List list = new CopyOnWriteArrayList();
        list.add(1);
        list.add("string");
        list.addAll(list);
        System.out.println(list);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
//        List<String> list = new CopyOnWriteArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> i = list.iterator();

        while(i.hasNext()) {
            String s = i.next();
            if(s.equals("Apple")) i.remove();
        }


//        System.out.println(itr.hasNext());
    }
}
