package Linked_List;
import java.util.*;
public class Merge_two_sorted_list {
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
    public static Node mergeTwoLists(Node head1,Node head2){
        // using extra space
        // Time complexity : O(n)

        Node temp1 = head1;
        Node temp2 = head2;
        Node head = new Node(100); // ek naya node....
        Node temp = head;
        while(temp1!=null && temp2!=null){
            if(temp1.data < temp2.data){
                Node a = new Node(temp1.data);
                temp.next = a;
                temp = a;
                temp1 = temp1.next;
            }
            else{
                Node a = new Node(temp2.data);
                temp.next = a;
                temp = a;
                temp2 = temp2.next;
            }
        }
        if(temp1 == null){ // copy the remaining node
            temp.next = temp2;
        }
        else{              // copy the remaining node
            temp.next = temp1;
        }
        return head.next;
    }
    public static Node mergeTwoLists2(Node head1,Node head2){
        // without using extra space
        // Time complexity : O(n)

        Node temp1 = head1;
        Node temp2 = head2;
        Node h = new Node(100);
        Node t = h;
        while(temp1!=null && temp2!=null){
            if(temp1.data < temp2.data){
                t.next = temp1;
                t = temp1;
                temp1 = temp1.next;
            }
            else{
                t.next = temp2;
                t = temp2;
                temp2 = temp2.next;
            }
        }
        if(temp1 == null){
            t.next = temp2;
        }
        else{ // if t2 is null....
            t.next = temp1;
        }
        return h.next;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(5);
        Node d = new Node(7);
        Node e = new Node(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        display(a);

        Node a1 = new Node(2);
        Node b1 = new Node(4);
        Node c1 = new Node(6);
        Node d1 = new Node(8);
        Node e1 = new Node(10);
        a1.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = e1;

        display(a1);

//        a = mergeTwoLists(a,a1);
//        display(a);

        b = mergeTwoLists2(a,a1);
        display(b);
    }
}
