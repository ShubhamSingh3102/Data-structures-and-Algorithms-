package Linked_List;
import java.util.*;
public class Reverse_Linked_List_II {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static Node reverseBetween(Node head,int left,int right) {
        if (head == null || left == right) {
            return head;
        }

        int pos = 1;
        Node before = null;
        Node t = head;

        while(pos < left) {
            before = t;
            t = t.next;
            pos++;
        }
        // pos = left
        // now reverse till right
        Node curr = t;
        Node prev = null;
        int times = right - left + 1;

        while (times-- > 0) {
            Node nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        // now connection
        t.next = curr;

        if(before != null){
            before.next = prev;
            return head;
        } else {
            return prev;
        }
    }
    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(1);
        Node d = new Node(2);
        Node e = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        display(a);

        Node p = reverseBetween(a,2,4);
        display(p);
    }
}
