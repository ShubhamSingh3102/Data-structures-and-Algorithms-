package Linked_List;
import java.util.*;
public class Cycle_in_a_linked_list {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static boolean cycleLinkedList(Node head){
        Node slow = head;
        Node fast = head;

        if(head == null){ // empty linked list
            return false;
        }
        if(head.next == null){ // single element is present in linked list....
            return false;
        }
        while(fast!=null){
            if(slow == null){
                return false;
            }
            slow = slow.next;
            if(fast.next == null){
                return false;
            }
            fast = fast.next.next;
            if(fast == slow){
                return true; // cycle in a linked list...
            }
        }
        return false; // not a cycle
    }
    public static Node cycleBeginNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                break;
            }
        }
        Node temp = head;
        while(temp!=slow){
            temp = temp.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        Node a = new Node(87);
        Node b = new Node(100);
        Node c = new Node(13);
        Node d = new Node(4);
        Node e = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = b;
//        boolean p = cycleLinkedList(a);
//        System.out.println(p);
        Node q = cycleBeginNode(a);
        System.out.println(q.data);
    }
}
