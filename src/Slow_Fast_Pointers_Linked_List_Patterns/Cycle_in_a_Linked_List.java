package Slow_Fast_Pointers_Linked_List_Patterns;
import java.util.*;
public class Cycle_in_a_Linked_List {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;

        if(head == null){
            return false;
        }
        if(head.next == null) {
            return false;
        }
        while(fast != null){
            if(slow == null){
                return false;
            }
            slow = slow.next;
            if(fast.next == null){
                return false;
            }
            fast = fast.next.next;  // 2 times...
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Node a = new Node(17);
        Node b = new Node(13);
        Node c = new Node(15);
        Node d = new Node(14);
        Node e = new Node(16);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = c;

        System.out.println(hasCycle(a));
    }
}
