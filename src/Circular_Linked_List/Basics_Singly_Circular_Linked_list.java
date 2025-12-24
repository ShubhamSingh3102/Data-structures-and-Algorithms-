package Circular_Linked_List;
import java.util.*;
public class Basics_Singly_Circular_Linked_list {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static void display(Node head){
        Node temp = head;
        while(temp.next != head){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print(temp.data + " ");
        System.out.println();
    }

    public static void randomNode(Node random){
        Node temp = random;
        while(temp.next != random){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(temp.data+" ");
        System.out.println();
    }

    public static Node DeleteHeadNode(Node head){
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = head.next;
        return temp.next;
    }
    public static void main(String[] args) {
        Node a  = new Node(1);
        Node b  = new Node(5);
        Node c  = new Node(4);
        Node d  = new Node(3);
        Node e  = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = a;

        display(a);
//        randomNode(d);
        a = DeleteHeadNode(a);
        display(a);
    }
}
