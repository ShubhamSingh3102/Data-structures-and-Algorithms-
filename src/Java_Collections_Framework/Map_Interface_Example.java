package Java_Collections_Framework;
import java.util.*;
public class Map_Interface_Example {
    static void HashMap_Example() {
        HashMap<Integer, String> map = new HashMap<>();
        // unordered....Hashtable internally use....
        // best performance is given by HashMaps....
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
//        map.put(1, "F"); // over-rides...
        map.putIfAbsent(1, "F"); // if key 1 is absent then it will do "F"
        System.out.println(map);
        map.remove(2);
        System.out.println(map);
        System.out.println(map.size());
//        System.out.println(map.isEmpty());
//        System.out.println(map.get(5));
//        System.out.println(map.containsKey(3));
//        System.out.println(map.containsValue("A"));
        System.out.println(map.keySet());
        System.out.println(map.values());

        // Iterating over keys in a map....
        for(Integer i :map.keySet()){
            System.out.print(i + " ");
        }
        System.out.println();

        // Iterating over values in a map....
        for(String i :map.values()){
            System.out.print(i + " ");
        }
        System.out.println();

        // Iterating over the key,value mapping...
        for(var e : map.entrySet()){
            System.out.print(e + " ");
        }
    }
    static void LinkedHashMap_Example() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        // ordered....Linked List + Hashtable internally use...
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
//        map.put(1, "F"); // over-rides...
        map.putIfAbsent(1, "F"); // if key 1 is absent then it will do "F"
        System.out.println(map);
        map.remove(2);
        System.out.println(map);
        System.out.println(map.size());
//        System.out.println(map.isEmpty());
//        System.out.println(map.get(5));
//        System.out.println(map.containsKey(3));
//        System.out.println(map.containsValue("A"));
        System.out.println(map.keySet());
        System.out.println(map.values());

        // Iterating over keys in a map....
        for(Integer i :map.keySet()){
            System.out.print(i + " ");
        }
        System.out.println();

        // Iterating over values in a map....
        for(String i :map.values()){
            System.out.print(i + " ");
        }
        System.out.println();

        // Iterating over the key,value mapping...
        for(var e : map.entrySet()){
            System.out.print(e + " ");
        }
    }
    static void TreeMap_Example() {
        TreeMap<Integer, String> map = new TreeMap<>();
        // sorted according to key...
        map.put(3, "C");
        map.put(1, "A");
        map.put(2, "B");
        map.put(4, "D");
        map.put(5, "E");
//        map.put(1, "F"); // over-rides...
        map.putIfAbsent(1, "F"); // if key 1 is absent then it will do "F"
        System.out.println(map);
        map.remove(2);
        System.out.println(map);
        System.out.println(map.size());
//        System.out.println(map.isEmpty());
//        System.out.println(map.get(5));
//        System.out.println(map.containsKey(3));
//        System.out.println(map.containsValue("A"));
        System.out.println(map.keySet());
        System.out.println(map.values());

        // Iterating over keys in a map....
        for(Integer i :map.keySet()){
            System.out.print(i + " ");
        }
        System.out.println();

        // Iterating over values in a map....
        for(String i :map.values()){
            System.out.print(i + " ");
        }
        System.out.println();

        // Iterating over the key,value mapping...
        for(var e : map.entrySet()){
            System.out.print(e + " ");
        }
    }
    public static void main(String[] args) {
//        HashMap_Example();
//        LinkedHashMap_Example();
        TreeMap_Example();
    }
}
