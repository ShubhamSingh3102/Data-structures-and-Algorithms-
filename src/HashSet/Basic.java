package HashSet;
import java.util.*;
public class Basic {
    static void exampleHashSet(){
        HashSet<String> hs = new HashSet<>();
        hs.add("James");
        hs.add("Scott");
        hs.add("James");
        System.out.println(hs);
        System.out.println(hs.contains("James"));
        System.out.println(hs.size());
        hs.remove("James");
        System.out.println(hs);
        System.out.println(hs.contains("James"));
        System.out.println(hs.size());
        hs.add("Mark");
        for(String s : hs){
            System.out.print(s+ " ");
        }
    }
    public static void main(String[] args) {
        exampleHashSet();
    }
}
