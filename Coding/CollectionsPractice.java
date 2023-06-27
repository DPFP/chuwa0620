import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsPractice {
    public static void main(String[] args) {
        String item;

        // ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Item1");  // Create
        item = arrayList.get(0);  // Read
        arrayList.set(0, "UpdatedItem");  // Update
        arrayList.remove(0);  // Delete

        // LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Item1");  // Create
        item = linkedList.get(0);  // Read
        linkedList.set(0, "UpdatedItem");  // Update
        linkedList.remove(0);  // Delete

        // CopyOnWriteArrayList A thread-safe variant of ArrayList in which all mutative operations (add, set, and so on) are implemented by making a fresh copy of the underlying array.
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Item1");  // Create
        item = list.get(0);  // Read
        list.set(0, "UpdatedItem");  // Update
        list.remove(0);  // Delete

        boolean containsItem;

        // HashSet
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Item1");  // Create
        containsItem = hashSet.contains("Item1");  // Read
        hashSet.remove("Item1");  // Delete

        //TreeSet
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Item1");  // Create
        treeSet.add("Item2");  // Create
        treeSet.add("Item3");  // Create
        treeSet.add("Item4");  // Create
        String firstItem = treeSet.first();  // Read
        System.out.println("first item of treeset is " + firstItem);
        treeSet.remove("Item1");  // Delete

        //HashMap
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Item1");  // Create
        item = hashMap.get(1);  // Read
        hashMap.put(1, "UpdatedItem");  // Update
        hashMap.remove(1);  // Delete

        //TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "Item1");  // Create
        Map.Entry<Integer, String> firstEntry = treeMap.firstEntry();  // Read
        treeMap.remove(1);  // Delete

        //LinkedHashMap
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "Item1");  // Create
        item = linkedHashMap.get(1);  // Read
        linkedHashMap.put(1, "UpdatedItem");  // Update
        linkedHashMap.remove(1);  // Delete

        // ConcurrentHashMap
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("Key1", 1);  // Create
        Integer value = map.get("Key1");  // Read
        map.put("Key1", 2);  // Update
        map.remove("Key1");  // Delete

    }
}
