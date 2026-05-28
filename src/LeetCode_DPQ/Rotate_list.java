package LeetCode_DPQ;
import java.util.*;
public class Rotate_list {
    public static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static int length(Node head){
        int count = 0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public static Node rotateRight(Node head,int k){
        if(head == null && head.next == null || k == 0){
            return head;
        }
        int l = length(head);
        k = k % l;
        if(k == 0){
            return head;
        }

        // firstly go to the last node
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        // connect last node to the head(make cyclic)
        temp.next = head;

        // find new tail
        int steps = l - k; // remaining steps
        Node newTail = head;
        for(int i = 1; i < steps; i++){
            newTail = newTail.next;
        }

        // new head
        Node newHead = newTail.next;

        // break cycle
        newTail.next = null;

        return newHead;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        int k = 2;

        System.out.println(rotateRight(a,k));
    }
}
