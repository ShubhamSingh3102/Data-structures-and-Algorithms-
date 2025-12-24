package Java_Collections_Framework;
import java.util.*;
public class Queue_Interface_example {
    static void Queue_example() {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        System.out.println(q);
        q.remove();
        System.out.println(q);
        q.poll(); // remove
        System.out.println(q.poll()); // remove and return...
        System.out.println(q);
        System.out.println(q.element());
        System.out.println(q.peek());
        q.offer(60); // add
        System.out.println(q);
    }
    static void PriorityQueue_example() {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min PriorityQueue....
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // max PriorityQueue....
        pq.add(100);
        pq.add(200);
        pq.add(150);
        pq.add(75);
        pq.add(500);
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);
        System.out.println(pq.peek()); // the smallest element has the highest priority queue...
        pq.remove();
        System.out.println(pq);
    }
    static void Deque_example() {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(10);
        dq.addLast(20);
        dq.addFirst(30);
        dq.addLast(40);
        System.out.println(dq);
        dq.removeFirst();
        System.out.println(dq);
        dq.removeLast();
        System.out.println(dq);
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());
    }
    public static void main(String[] args) {
//        Queue_example();
//        PriorityQueue_example();
        Deque_example();
    }
}
