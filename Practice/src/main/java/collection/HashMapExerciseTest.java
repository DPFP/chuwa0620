package collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class HashMapExerciseTest {

    /**
     * e.g.
     * Map<String, Integer> map = new HashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
     *
     * containsKey(Object key)
     * containsValue(Object value)
     *
     * keySet()
     * values()
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        Map<String, Integer> map = new HashMap<>();
        map.put("james",23);
        map.putIfAbsent("kobe",24);
        map.putIfAbsent("james",6);
        System.out.println(map.get("kobe"));
        System.out.println(map.get("james"));
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("white",8);
        map.putAll(map2);
        System.out.println(map.get("white"));
        System.out.println(map.containsValue(8) ? "true" : "false");
        System.out.println(map.isEmpty()? "true":"false");
        Map<String, Integer> map3 = new HashMap<>();
        System.out.println(map3.isEmpty()? "true":"false");
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     *
     * remove(Object key)
     * remove(Object key, Object value)
     *
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        Map<String, Integer> map = new HashMap<>();
        map.put("james",23);
        map.putIfAbsent("kobe",24);
        map.replace("james", 44);
        System.out.println(map.get("james"));
        map.replace("james",43,55);
        System.out.println(map.get("james"));
        map.replace("james",44,55);
        System.out.println(map.get("james"));
        map.replaceAll((key,val)->val+2);
        System.out.println(map.get("james"));
        map.remove("james",12);
        System.out.println(map.containsKey("james"));
        map.remove("james",57);
        System.out.println(map.containsKey("james"));
        System.out.println(map.get("kobe"));
        map.compute("kobe", (key,val)->(val == null) ? -1 : val+2);
        System.out.println(map.get("kobe"));
    }
}
