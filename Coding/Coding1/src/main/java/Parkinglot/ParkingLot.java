package Parkinglot;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParkingLot {
    private int capacity;

    private List<ParkingSpot> spots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;

    }



    public static void learn_Inserting_And_Retrieving() {
        Integer []nums = {1,2,3,4};
        List<Integer> list = Arrays.asList(nums);
        Collections.min(list);
        Collections.max(list,Comparator.reverseOrder());
        Collections.frequency(list,1);
        Collections.synchronizedList(list);
    }



}
