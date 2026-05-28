package Slow_Fast_Pointers_Linked_List_Patterns;
import java.util.*;
public class Insertion_at_the_beginning {
    public static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insertionAtBeginning(Node head,int x){
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        return head;
    }
    public static Node insertionAtIndex(Node head, int val, int index){
        if(index == 0) {
            return insertionAtBeginning(head, val);
        }

        Node temp = head; // taaki head kahi bhula maat jaaye...
        for(int i = 0; i < index -1; i++){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }
    public static Node insertionAtEnd(Node head,int val){
        Node newNode = new Node(val);

        if(head == null){
            return newNode;
        }

        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }
    public static void display(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
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

        Node head = a;
        display(head);

        head = insertionAtBeginning(head,100);
        display(head);

        head = insertionAtIndex(head,200,5);
        display(head);

        head = insertionAtEnd(head,300);
        display(head);
    }
}
