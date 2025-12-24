package Java_Collections_Framework;
import java.util.*;
public class Set_Interface_Examples {
    static void HashSetExample() {
        HashSet<Integer> hs = new HashSet<>();
        // unordered and unique element....
        // Hashset uses hashing concept...
        // unique....
        // TC --> 0(1)
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(5);
        System.out.println(hs);
        hs.add(2); // duplicate are not included...
        hs.remove(1); // not index its actually and element...
        System.out.println(hs);
        hs.remove(3);
        System.out.println(hs);
        System.out.println(hs.contains(5));
    }
    static void LinkedHashSetExample() {
        LinkedHashSet<Integer> l = new LinkedHashSet<>();
        // ordered of insertion and unique element...
        // Linked list + hashing concept used...
        l.add(21);
        l.add(12);
        l.add(34);
        l.add(22);
        System.out.println(l);
        l.remove(12);
        System.out.println(l);
    }
    static void TreeSetExample() {
        TreeSet<Integer> ts = new TreeSet<>();
        // sorted and unique element...
        // self-balancing Binary Search Tree(BST)....red blood tree..
        // TC --> 0(log n)
        ts.add(100);
        ts.add(250);
        ts.add(230);
        ts.add(150);
        ts.add(120);
        System.out.println(ts);
        ts.remove(120);
        System.out.println(ts);
        System.out.println(ts.contains(100));
        System.out.println(ts.last());
    }
    public static void main(String[] args) {
//        HashSetExample();
//        LinkedHashSetExample();\
        TreeSetExample();
    }
}
