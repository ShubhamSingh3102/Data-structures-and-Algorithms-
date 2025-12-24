package Linked_List;
import java.util.*;
public class Palindrome {
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
    public static boolean isPalindrome(Node head){
        // left middle of a linked list
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = reverseLinkedListIterative(slow.next);
        slow.next = temp;
        Node p1 = head;
        Node p2 = slow.next;
        while(p2!=null){
            if(p1.data != p2.data){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(3);
        Node e = new Node(2);
        Node f = new Node(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        display(a);
        boolean p = isPalindrome(a);
        System.out.println(p);
    }
}
