package Linked_List;
import java.util.*;
public class Rotate_A_Linked_List {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node rotateLL(Node head, int k){
        // first we have to find n and last
        if(head == null){
            return null;
        }
        int n = 1;
        Node last = head;

        while(last.next != null){
            n++;
            last = last.next;
        }

        k = k % n;
        if(k == 0){
            return head;
        }

        int count = 1;
        int c = (n - k);
        Node t = head;

        while(t != null){
            if(count == c){
                break;
            }
            count++;
            t = t.next;
        }

        // for (n- k +1)
        Node res = t.next;

        // now connection
        last.next = head;

        t.next = null;

        return res;
    }
    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        int k = 3;

        display(a);
        Node p = rotateLL(a,k);
        display(p);
    }
}
