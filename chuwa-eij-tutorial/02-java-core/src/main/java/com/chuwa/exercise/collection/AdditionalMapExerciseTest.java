package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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
        Map<Integer, Integer> mp = new ConcurrentHashMap<>();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                mp.put(i, i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1001; i <= 2000; i++) {
                mp.put(i, i);
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(mp.size());

        Map<Integer, Integer> mp2 = new ConcurrentHashMap<>();
        mp2.putAll(mp);
        System.out.println(mp2.size());

        mp.putIfAbsent(3500, 4000);
        System.out.println(mp.get(3500));
        mp.remove(3500);
        mp.putIfAbsent(3500,5000);
        System.out.println(mp.get(3500));
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
        Map<String, Integer> mp = new IdentityHashMap<>();
        String key1 = new String("100");
        String key2 = new String("100");
        mp.put(key1, 100);
        mp.put(key2, 200);
        mp.put(null, 300);
        System.out.println(mp.get(key1));
        System.out.println(mp.get(key2));
        System.out.println(mp.get(null));

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
        Map<DayOfWeek, Integer> enumMap = new EnumMap<DayOfWeek, Integer>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.put(DayOfWeek.TUESDAY, 2);
        enumMap.put(DayOfWeek.WEDNESDAY, 3);
        for (var key : enumMap.keySet()) {
            System.out.println(key + enumMap.get(key).toString());
        }
    }
}

enum DayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY
}