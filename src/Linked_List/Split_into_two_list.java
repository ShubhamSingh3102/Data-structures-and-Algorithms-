package Linked_List;
import java.util.*;
public class Split_into_two_list {
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
    public static Node splitTwoList(Node head){
        // using extra space
        Node temp = head;
        Node odd = new Node(-1);
        Node even = new Node(0);
        Node o = odd;
        Node e = even;
        while (temp!=null){
            if(temp.data % 2!=0){ // odd
                o.next = temp;
                o = o.next;
            }
            else{ // even
                e.next = temp;
                e = e.next;
            }
            temp = temp.next;
        }
        e.next = null;
        o.next = even.next;
        return odd.next;
    }

    public static Node splitTwoList2(Node head) {
        // without using extra space
        if (head == null || head.next == null) return head;

        Node oddHead = null, oddTail = null;
        Node evenHead = null, evenTail = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next; // store next node
            current.next = null; // disconnect current node

            if (current.data % 2 != 0) { // Odd
                if (oddHead == null) {
                    oddHead = oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            } else { // Even
                if (evenHead == null) {
                    evenHead = evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            }
            current = nextNode;
        }

        // Connect odd list to even list
        if (oddTail != null) {
            oddTail.next = evenHead;
            return oddHead;
        } else {
            return evenHead; // No odd elements
        }
    }


    public static Node oddEvenList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node temp = head;
        Node Odd = new Node(-1);
        Node Even = new Node(0);
        Node tempOdd = Odd;
        Node tempEven = Even;
        while(temp!=null){
            tempOdd.next = temp;
            temp = temp.next;
            tempOdd = tempOdd.next;


            tempEven.next = temp;
            if(temp==null) break;
            temp = temp.next;
            tempEven = tempEven.next;

        }
        Odd = Odd.next;
        Even = Even.next;
        tempOdd.next = Even;
        return Odd;
    }

    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(4);
        Node d = new Node(1);
        Node e = new Node(2);
//        Node f = new Node(8);
//        Node g = new Node(10);
//        Node h = new Node(13);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
//        e.next = f;
//        f.next = g;
//        g.next = h;

        display(a);
//        Node p = splitTwoList(a);
//        display(p);
//        Node p = splitTwoList2(a);
//        display(p);
        Node p = oddEvenList(a);
        display(p);
    }
}