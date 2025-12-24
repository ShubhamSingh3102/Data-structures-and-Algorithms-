package Doubly_Linked_List;
import java.util.*;
public class Implementation_of_doubly_linkedList {
    public static class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
        }
    }
    public static class DoublyLinkedList {
        Node head = null;
        Node tail = null;
        int size = 0;

        void display() {
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }

        void displayRev() {
            Node temp = tail;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp = temp.prev;
            }
            System.out.println();
        }

        void insertAtHead(int data){
            Node t = new Node(data);
            if(head==null) {
                head = t;
                tail = t;
            }
            else{
                t.next = head;
                head.prev = t;
                head = t;
            }
            size++;
        }

        void insertAtTail(int data){
            Node t = new Node(data);
            if(tail==null) {
                tail = t;
                head = t;
            }
            else{
                t.prev = tail;
                tail.next = t;
                tail = t;
            }
            size++;
        }
    }
    public static void main(String[] args) {
        DoublyLinkedList ddl = new DoublyLinkedList();
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(2);
        Node d = new Node(99);
        Node e = new Node(13);
        ddl.head = a;
        ddl.tail = e;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.prev = d;
        d.prev = c;
        c.prev = b;
        b.prev = a;
        a.prev = null;

        ddl.display();
        ddl.insertAtHead(30);
        ddl.display();
        ddl.insertAtTail(100);
        ddl.display();
//        ddl.displayRev();
    }
}
