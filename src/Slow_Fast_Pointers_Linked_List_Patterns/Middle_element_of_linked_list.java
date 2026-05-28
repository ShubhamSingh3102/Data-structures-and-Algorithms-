package Slow_Fast_Pointers_Linked_List_Patterns;
import java.util.*;
public class Middle_element_of_linked_list {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void display(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    // head first house number ka address store krta hai.....
    public static Node middleElement(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        Node a = new Node(17);
        Node b = new Node(13);
        Node c = new Node(15);
        Node d = new Node(14);
        Node e = new Node(16);
        Node f = new Node(18);
        Node g = new Node(20);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        display(a);

        System.out.println(middleElement(a).data);
    }
}
