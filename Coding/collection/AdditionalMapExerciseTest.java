package com.chuwa.exercise.collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.*;
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
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("a", 1);
        map.putIfAbsent("a", 3);
        map.putIfAbsent("b", 2);
        System.out.println(map.values());

        ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>();
        map2.put("d", 4);
        map.putAll(map2);
        System.out.println(map.values());

    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    //当HashMap对4个key执行put操作时，使用hashCode作为hash值，使用equals进行相等判断，后3个put操作，最终执行的是更新操作，最后HashMap中只有1项。
    //
    //而IdentityHashMap对4个key执行put操作时，使用System.identityHashCode作为hash值，使用==进行相等判断，后3个put操作，最终执行的是插入操作，最后IdentityHashMap中有4项。

    public void learn_IdentityHashMap() {
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
        map.put(DayOfWeek.of(4),1);
        map.putIfAbsent(DayOfWeek.of(2),4);
        System.out.println(map.size());
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.of(4),1);
        enumMap.putIfAbsent(DayOfWeek.of(2),4);
    }
}
