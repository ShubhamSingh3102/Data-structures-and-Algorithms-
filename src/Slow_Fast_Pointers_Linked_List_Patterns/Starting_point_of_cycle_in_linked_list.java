//package Slow_Fast_Pointers_Linked_List_Patterns;
//import java.util.*;
//public class Starting_point_of_cycle_in_linked_list {
//    public static class Node{
//        int data;
//        Node next;
//        Node(int data){
//            this.data = data;
//        }
//    }
//    public static int cycleStartPoint(Node head){
//        Node slow = head;
//        Node fast = head;
//
//        if(head == null){
//            return -1;
//        }
//        if(head.next == null){
//            return -1;
//        }
//
//        while(fast != null){
//            if(slow == null){
//                return -1;
//            }
//            slow = slow.next;
//            if(fast.next == null){
//                return -1;
//            }
//            fast = fast.next.next;
//            if(slow == fast){
//                slow = head;
//
//                while(slow != fast){
//                    slow = slow.next;
//                    fast = fast.next;
//                }
//                return slow.data;
//            }
//        }
//        return -1;
//    }
//    public static void main(String[] args) {
//        Node a = new Node(17);
//        Node b = new Node(13);
//        Node c = new Node(15);
//        Node d = new Node(14);
//        Node e = new Node(16);
//        Node f = new Node(18);
//        Node g = new Node(20);
//
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = f;
//        f.next = g;
//        g.next = c;
//        System.out.println(cycleStartPoint(a));
//    }
//}


















package Slow_Fast_Pointers_Linked_List_Patterns;
import java.util.*;
public class Starting_point_of_cycle_in_linked_list {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    // L1 = nC - L2   ---> l1 = C - L2
    public static Node cycleStartPoint(Node head){
        Node slow = head;
        Node fast = head;


        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;

                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Node a = new Node(17);
        Node b = new Node(13);
        Node c = new Node(15);
        Node d = new Node(14);
        Node e = new Node(16);
        Node f = new Node(18);
        Node g = new Node(20);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = c;
        System.out.println(cycleStartPoint(a).data);
    }
}
