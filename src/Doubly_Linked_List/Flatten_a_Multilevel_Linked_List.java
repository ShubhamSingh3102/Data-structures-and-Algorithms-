package Doubly_Linked_List;
import java.util.*;
public class Flatten_a_Multilevel_Linked_List {
    public static class Node {
        int data;
        Node next;
        Node prev;
        Node child;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" ");
            }
            curr = curr.next;
        }
        System.out.println();     // final newline
    }

    public static Node flatten(Node head) {
        Node temp = head;
        while (temp != null) {
            Node t = temp.next;
            if (temp.child != null) {
                Node c = flatten(temp.child);
                temp.next = c;
                c.prev = temp;

                // c ko aage le jao
                while (c.next != null) {
                    c = c.next;
                }
                c.next = t;
                if (t != null) {
                    t.prev = c;
                }
            }
            temp.child = null; // At the last sabke child ko null banana hai....
            temp = t;
        }
        return head;
    }

    public static void main(String[] args) {
        // Level 1
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;
        n5.next = n6;
        n6.prev = n5;

        // Level 2
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n7.next = n8;
        n8.prev = n7;
        n8.next = n9;
        n9.prev = n8;
        n9.next = n10;
        n10.prev = n9;

        n3.child = n7;  // 3 → child → 7

        // Level 3
        Node n11 = new Node(11);
        Node n12 = new Node(12);

        n11.next = n12;
        n12.prev = n11;

        n8.child = n11; // 8 → child → 11

        Node head = flatten(n1);
        display(head);

    }
}
