package Queue;
import java.util.*;
public class deque {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addLast(1);
        dq.addLast(2);
        dq.addLast(3);
        dq.addLast(4);
        dq.addLast(5);
        System.out.println(dq);
        dq.removeLast();
        System.out.println(dq);
        dq.addFirst(0);
        dq.addFirst(-1);
        dq.addFirst(-2);
        System.out.println(dq);
        dq.removeFirst();
        System.out.println(dq);
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());


//        dq.add(10); // last me add hoga...
//        dq.remove(); // first se remove hoga...
//        dq.removeAll(dq); // remove all the element from the deque...
//        System.out.println(dq);
    }
}
