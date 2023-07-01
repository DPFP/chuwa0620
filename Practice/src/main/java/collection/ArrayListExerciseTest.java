package collection;

import org.junit.Test;

import java.util.*;

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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println("size: "+ list.size());
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        for(int num:list2){
            System.out.println(num);
        }
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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println("size: "+ list.size());
        list.remove(1);
        System.out.println("size: "+ list.size());
        list.add(2);
        list.add(3);
        List<Integer> removeList = new ArrayList<>();
        removeList.add(2);
        removeList.add(1);
        list.removeAll(removeList);
        System.out.println("size: "+ list.size());
        list.clear();
        System.out.println("size: "+ list.size());
        list.add(2);
        list.add(3);
        list.set(0,1);
        System.out.println("val: "+list.get(0));
        List<String> listStr = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        System.out.println("List before replaceAll: " + listStr);
        listStr.replaceAll(str -> str.toUpperCase());
        System.out.println("List after replaceAll: " + listStr);
        list.clear();
        list.add(1);
        list.add(2);
        list.add(1);
        System.out.println(list.contains(1)?"true":"false");
        System.out.println(list.contains(2)?"true":"false");
        System.out.println(list.contains(3)?"true":"false");
        System.out.println(list.indexOf(1));
        System.out.println(list.indexOf(2));
        System.out.println(list.lastIndexOf(1));
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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int num = iterator.next();
            System.out.println(num);
        }
        iterator = list.iterator();
        while (iterator.hasNext()){
            int num = iterator.next();
            if(num == 1){
                iterator.remove();
            }
        }
        System.out.println("List after removal: " + list);
        iterator = list.iterator();
        iterator.forEachRemaining(num->System.out.println("each num: "+num));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<5;i++){
            list.add(i);
        }
        list.sort((a,b)->(b-a));
        for(int i=0;i<5;i++){
            System.out.println(list.get(i));
        }
        System.out.println("----------");
        Collections.sort(list);
        for(int i=0;i<5;i++){
            System.out.println(list.get(i));
        }
        System.out.println("----------");
        Collections.sort(list, Comparator.reverseOrder());
        for(int i=0;i<5;i++){
            System.out.println(list.get(i));
        }
    }
}