package Doubly_Linked_List;
import java.util.*;
public class Palindrome_Linked_List {
    public static class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean isPalindrome(Node head) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node h = head;
        Node t = temp;
        while (h != t) {
            if (h.data != t.data) {
                return false;
            }
            h = h.next;
            t = t.prev;
        }
        return true;
    }
    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(5);
        Node d = new Node(5);
        Node e = new Node(10);
        Node f = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        f.prev = e;
        e.prev = d;
        d.prev = c;
        c.prev = b;
        b.prev = a;
        a.prev = null;

        System.out.println(isPalindrome(a));
    }
}
