package Java_Collections_Framework;
import java.util.*;
public class List_Interface_example {
    static void ArrayList_Example() {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        System.out.println(l);
        l.remove(3); // index pe delete hoga...
        System.out.println(l);
//        l.clear(); // removes all element....
//        System.out.println(l);
        System.out.println(l.get(2));
        l.set(2,10); // modify at index i....
        System.out.println(l);
        System.out.println(l.contains(10)); // true
        System.out.println(l.contains(11)); // false
    }
    static void LinkedList_Example() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(21);
        ll.add(22);
        ll.add(23);
        ll.add(24);
        ll.add(25);
        System.out.println(ll);
        ll.removeFirst();
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);
        ll.remove(); // remove from first...
        System.out.println(ll);
        ll.set(1,10);
        System.out.println(ll);
        System.out.println(ll.contains(10));
    }
    static void Stack_Example() {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(5);
        st.push(6);
        System.out.println(st);
        st.pop();
        System.out.println(st);
        System.out.println(st.peek());
        System.out.println(st.search(5)); // true means 1..
        System.out.println(st.empty());
        System.out.println(st.size());
    }
    public static void main(String[] args) {
//        ArrayList_Example();
//        LinkedList_Example();
        Stack_Example();
    }
}
