package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,44,1,34));
        System.out.println(Collections.min(list));
        System.out.println(Collections.min(list, Collections.reverseOrder()));
        System.out.println(Collections.frequency(list, 1));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(i);
        }
        System.out.println("Original List: " + list);
        List<Integer> syncList = Collections.synchronizedList(list);
        System.out.println("Synchronized List: " + syncList);
    }
}
