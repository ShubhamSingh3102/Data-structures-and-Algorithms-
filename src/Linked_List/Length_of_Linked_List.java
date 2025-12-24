package Linked_List;
import java.util.*;
public class Length_of_Linked_List {

    // iterative call
    public static int length(Node head){
        Node temp = head;
        int count = 0;
        while(temp!=null){
            System.out.print(temp.data + " ");
            count++;
            temp = temp.next;
        }
        return count;
    }

    // recursively call
    public static int lengthr(Node head){
        if(head == null){
            return 0;
        }
        return 1 + lengthr(head.next);
    }
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(9);
        Node d = new Node(8);
        Node e = new Node(16);
        Node f = new Node(100);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        int len = length(a);
        System.out.println();
        System.out.println("The length of the linked list is : " + len);

        int len1 = lengthr(a);
        System.out.println();
        System.out.println("The length of the linked list is : " + len1);
    }
}

