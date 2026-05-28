package Linked_List;
import java.util.*;
public class Reverse_Nodes_in_K_Group {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void reverse(Node head,int times){
        Node curr = head;
        Node prev = null;

        while(times-- > 0){
            Node nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
        }
        return;
    }
    public static Node swapNode(Node head, int k){
        if(head == null){
            return null;
        }
        Node left = head;
        Node right;
        Node res = null;
        Node prevLeft = null;
        int size = k;

        while(true) {
            right = left;
            for(int i = 0; i < (size-1); i++){
                if(right == null){
                    break;
                }
                right = right.next;
            }
            if(right != null){
                Node nextLeft = right.next;
                reverse(left,size);

                // now for connection
                if(prevLeft != null){
                    prevLeft.next = right;
                }
                prevLeft = left;
                if(res == null){
                    res = right;  // newHead
                }
                left = nextLeft;
            } else {  // right == null // akela element baacha h...
                if(prevLeft != null){
                    prevLeft.next = left;
                }
                if(res == null){
                    res = left;
                }
                break;
            }
        }
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

        Node p = swapNode(a,k);
        display(p);
    }
}
