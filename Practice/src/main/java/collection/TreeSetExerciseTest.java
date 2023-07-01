package collection;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

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
        TreeSet<Integer> set= new TreeSet<>();
        for(int i=0;i<4;i++){
            set.add(i);
        }
        System.out.println(set.ceiling(4));
        Set<Integer> set2 = set.subSet(4, 7);
        System.out.println("size:"+set2.size());
        Set<Integer> set3 = set.headSet(2);
        System.out.println("size:"+set3.size());
        for(int num:set3){
            System.out.println(num);
        }
        Set<Integer> set4 = set.tailSet(2);
        System.out.println("size:"+set4.size());
        for(int num:set4){
            System.out.println(num);
        }
    }
}
