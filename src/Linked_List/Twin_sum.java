package Linked_List;
import java.util.*;
public class Twin_sum {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static Node reverseLinkedListIterative(Node head){
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev; // for connection
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static int twinSum(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = reverseLinkedListIterative(slow.next);
        slow.next = temp;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        Node p1 = head;
        Node p2 = slow.next;
        while (p2 != null) {
            sum = p1.data + p2.data;
            if (sum > max) {
                max = sum;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return max;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(10);
        Node c = new Node(13);
        Node d = new Node(3);
        Node e = new Node(5);
        Node f = new Node(7);
        Node g = new Node(7);
        Node h = new Node(2);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;

        display(a);
        int p = twinSum(a);
        System.out.println(p);
    }
}
