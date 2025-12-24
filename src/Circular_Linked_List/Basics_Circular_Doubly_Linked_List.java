package Circular_Linked_List;
import java.util.*;
public class Basics_Circular_Doubly_Linked_List {
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
        }
    }

    public static void display(Node head){
        Node temp = head;
        while(temp.next != head){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(temp.data + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        Node a  = new Node(4);
        Node b  = new Node(10);
        Node c  = new Node(5);
        Node d  = new Node(3);
        Node e  = new Node(100);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = a;

        a.prev = e;
        b.prev = a;
        c.prev = b;
        d.prev = c;
        e.prev = d;

        display(a);
    }
}
