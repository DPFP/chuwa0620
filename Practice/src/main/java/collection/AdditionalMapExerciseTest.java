package collection;

import org.junit.Test;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("Apple", 10);
        System.out.println(map.get("Apple"));
        map.putIfAbsent("Apple", 12);
        System.out.println(map.get("Apple"));
        map.putIfAbsent("Pear", 12);
        System.out.println(map.get("Pear"));
        Map<String, Integer> map2 = new ConcurrentHashMap<>();
        map2.putAll(map);
        System.out.println(map2.get("Apple"));
    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> identityHashMap = new IdentityHashMap<>();
        String key1 = new String("key");
        String key2 = new String("key");
        hashMap.put(key1, "1");
        identityHashMap.put(key1, "1");
        System.out.println(hashMap.containsKey(key2));
        System.out.println(identityHashMap.containsKey(key2));
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    @Test
    public void learn_EnumMap() {
        EnumMap<Day, String> dayMap = new EnumMap<>(Day.class);
        dayMap.put(Day.MONDAY, "Working day");
        dayMap.put(Day.TUESDAY, "Working day");
        dayMap.put(Day.WEDNESDAY, "Working day");
        dayMap.put(Day.THURSDAY, "Working day");
        dayMap.put(Day.FRIDAY, "Working day");
        dayMap.put(Day.SATURDAY, "Weekend");
        dayMap.put(Day.SUNDAY, "Weekend");

        for (Day day : Day.values()) {
            System.out.println(day + ": " + dayMap.get(day));
        }
    }
}
