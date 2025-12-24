package Linked_List;
import java.util.LinkedList;
public class Reverse_a_linked_list {
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
    public static void reverseDisplay(Node head){
        // here actually connection of node is not changed...
        Node temp = head;
        if(head == null){
            return;
        }
            reverseDisplay(temp.next);
            System.out.print(temp.data + " ");
    }
    public static Node reverseLinkedList(Node head){
        // recursive way....
        // Time complexity : O(n)
        // Space complexity : O(n)
        Node temp = head;

        // Base case
        if(head.next == null){ // tail Node
            return head;
        }
        Node newHead = reverseLinkedList(head.next);
        head.next.next = head; // interchanging the connections...
        head.next = null;
        return newHead;
    }

    public static Node reverseLinkedListIterative(Node head){
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev; // for connection
            prev = curr;
            curr = next;
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

        display(a);
//        reverseDisplay(a);
//        Node p = reverseLinkedList(a);
//        display(p);
        Node p = reverseLinkedListIterative(a);
        display(p);
    }
}
