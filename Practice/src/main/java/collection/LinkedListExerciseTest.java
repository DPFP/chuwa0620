package collection;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(12);
        list.addFirst(13);
        list.addLast(14);
        for(int num:list){
            System.out.println(num);
        }
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(12);
        list.add(13);
        list.add(14);
        list.removeFirst();
        System.out.println(list.getFirst());
        list.add(15);
        list.add(13);
        list.removeLastOccurrence(13);
        System.out.println("-----------------");
        for(int num:list){
            System.out.println(num);
        }
        list.sort((a,b)->(b-a));
        System.out.println("-----------------");
        for(int num:list){
            System.out.println(num);
        }
    }
}
