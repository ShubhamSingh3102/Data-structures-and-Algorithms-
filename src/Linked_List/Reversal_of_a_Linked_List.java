package Linked_List;
import java.util.*;
public class Reversal_of_a_Linked_List {
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
    // TC --> O(n)
    // SC --> 0(1)
    public static Node reverseLinkedList(Node head){
        Node curr = head;   // mechanic
        Node prev = null;   // helper

        while(curr != null){
            Node nex = curr.next; // jab connection tutega to ye aage jump krne ke liye kaam aaega...
            curr.next = prev;  // for connection
            prev = curr;
            curr = nex;
        }
        return prev;
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

        System.out.print("Before reversal: ");
        display(a);
        System.out.print("After reversal: ");
        Node p = reverseLinkedList(a);
        display(p);
    }
}
