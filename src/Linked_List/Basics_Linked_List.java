package Linked_List;
import java.util.*;
public class Basics_Linked_List {

    // insertAtEnd
    public static void insertAtEnd(Node head,int data){
        Node temp = new Node(data);
        Node p = head;
        while(p.next!=null){
            p = p.next;
        }
        p.next = temp;
    }
    // recursively call
    public static void displayr(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.data + " ");
        displayr(head.next);
    }

    // delete a node given the node itself as parameter...
    public static void deleteNode(Node head){
        head.data = head.next.data;
        head.next = head.next.next;
    }

    // reverse of linked list
    public static void reverse(Node head){
        if(head == null){
            return;
        }
        reverse(head.next);
        System.out.print(head.data + " ");
    }

    // function call
    public static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // user defined data type
    public static class Node{ // user defined data type
        int data; // value
        Node next; // next wale node ka pura ka pura address hi contain kr rha hai.../address of next node....
        Node(int data){ // constructor
            this.data = data;
        }
    }

    public static void main(String[] args) {
//        Node x = new Node();
//        System.out.println(x.data);
//        System.out.println(x.next);

        Node a = new Node(5); // head
        Node b = new Node(3);
        Node c = new Node(9);
        Node d = new Node(8);
        Node e = new Node(16);

        // 5 3 9 8 16
        a.next = b; // linked... // 5 -> 3 9 8 16
//        System.out.println(a.next); // $Node@7b23ec81
//        System.out.println(b); // $Node@7b23ec81
//        System.out.println(b.data);
//        System.out.println(a.next.data);

        b.next = c;  // 5-> 3 -> 9 8 16
        c.next = d;  // 5 -> 3 -> 9 -> 8 16
        d.next = e;  // 5 -> 3 -> 9 -> 8 -> 16


//        System.out.println(a.data);
//        System.out.println(a.next.data);
//        System.out.println(a.next.next.data);
//        System.out.println(a.next.next.next.data);
//        System.out.println(a.next.next.next.next.data);


//        Node temp = a; // temp points to a
//        for(int i=1;i<=5;i++){
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }



//        Node temp = a; // temp points to a
//        while(temp!=null){ // for displaying linked list.....
//            System.out.print(temp.data + " ");
//            temp = temp.next;
//        }


//        display(a);
//        System.out.println();
//        displayr(a);
//        System.out.println();
//        reverse(a);

        insertAtEnd(a,87);
        display(a);
        System.out.println();
        deleteNode(b);
        display(a);
    }
}
