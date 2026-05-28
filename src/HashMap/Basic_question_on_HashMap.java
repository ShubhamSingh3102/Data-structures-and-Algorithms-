package HashMap;
import java.util.*;
public class Basic_question_on_HashMap {
    static void HashMap_Question(){
        // Syntax.....
        HashMap<String , Integer> mp = new HashMap<>();
        // Adding Elements....
        mp.put("Akash",21);
        mp.put("Yash",16);
        mp.put("Lav",17);
        mp.put("Rishika",19);
        mp.put("Harry",18);

        // Getting value of a key from the HashMap
        System.out.println(mp.get("Yash")); // 16
        System.out.println(mp.get("Rahul")); // null
        System.out.println(mp.get("Rishika")); // 19

        // Changing/Updating value of a key in the HashMap
        mp.put("Akash",25);
        System.out.println(mp);

        // Remove a pair from the hashMap
        System.out.println(mp.remove("Akash")); // 25
        System.out.println(mp);
        System.out.println(mp.remove("Shubham")); // null
        System.out.println(mp.size());

        // Checking if a key is in the HashMap or not....
        System.out.println(mp.containsKey("Akash")); // false
        System.out.println(mp.containsKey("Yash")); // true...

        // Adding a new entry only if the new key doesn't exist already
        mp.putIfAbsent("Akash",27); // will enter
        mp.putIfAbsent("Yash",35); // will not enter
//        System.out.println(mp);

        // Getting all the keys in the HashMaps....
        System.out.println(mp.keySet());

        // Getting all the values in the HashMaps....
        System.out.println(mp.values());

        // Getting all entries in the hashMap
        System.out.println(mp.entrySet());
        System.out.println();

        // Traversing all entries of hashMap --> multiple methods
        for(String key : mp.keySet()){
            System.out.printf("Age of %s is %d\n",key,mp.get(key));
        }
        System.out.println();
        for( Map.Entry<String,Integer> e: mp.entrySet()){
            System.out.printf("Age of %s is %d\n", e.getKey(),e.getValue());
        }
        System.out.println();
        for(var e : mp.entrySet()){
            System.out.printf("Age of %s is %d\n", e.getKey(),e.getValue());
        }
    }
    public static void main(String[] args) {
        HashMap_Question();
    }
}
