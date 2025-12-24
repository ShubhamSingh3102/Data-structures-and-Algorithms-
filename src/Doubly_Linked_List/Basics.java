package Doubly_Linked_List;
import java.util.*;
public class Basics {
    public static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }
    public static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void displayRev(Node tail){
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static Node insertAtHead(Node head,int data){
        Node t = new Node(data);
        if(head==null) {
            head = t;
        }
        else {
            t.next = head;
            head.prev = t;
        }
        return t;
    }

    public static void insertAtTail(Node head,int data){
        Node temp = head;
        // temp ko tail tk leke jaate h....
        while(temp.next!=null){
            temp = temp.next;
        }
        Node t = new Node(data);
        temp.next = t;
        t.prev = temp;
        temp = t;
    }

    public static void InsertAtIdx(Node head,int index,int data){
        Node temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        Node t = new Node(data);
        t.next = temp.next;
        t.prev = temp;
        temp.next = t;
        temp.next.prev = t;
    }

    public static Node deleteHead(Node head){
        if(head==null){
            return null;
        }
        else{
            Node temp = head;
            head = head.next;
            head.prev = null;
            return head;
        }
    }

    public static void deleteTail(Node head){
        Node temp = head;
        if(head==null){
            return;
        }
        else {
            while(temp.next!=null){
                temp = temp.next;
            }
            Node t = temp.prev;
            t.next = null;
        }
    }

    public static void deleteAtIdx(Node head,int index){
        Node temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;
        temp = temp.next;
    }
    // random node is given
    public static void displayRandom(Node random){
        Node temp = random;
        // Move this temp backwards to the head....
        while(temp.prev!=null){
            temp = temp.prev;
        }
        // print the list.....
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(2);
        Node d = new Node(99);
        Node e = new Node(13);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        e.prev = d;
        d.prev = c;
        c.prev = b;
        b.prev = a;
        a.prev = null;

        display(a);
//        displayRev(e);
//        displayRandom(c);
        Node newHead = insertAtHead(a,30);
        display(newHead);
        insertAtTail(newHead,100);
        display(newHead);
        InsertAtIdx(newHead,3,50);
        display(newHead);
        Node p = deleteHead(newHead);
        display(p);
        deleteTail(p);
        display(p);
        deleteAtIdx(p,3);
        display(p);
    }
}
