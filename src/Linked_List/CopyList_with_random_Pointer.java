package Linked_List;
import java.util.*;
public class CopyList_with_random_Pointer {
    public static class Node{
        int data;
        Node next;
        Node random;
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
//    public static Node copyList(Node head){
//        if(head == null){
//            return null;
//        }
//        Node temp1 = head;
//        Node newHead = new Node(-1);
//        Node temp2 = newHead;
//        while(temp1!=null){
//            Node newNode = new Node(temp1.data);
//            temp2.next = newNode;
//            temp2 = newNode;
//            temp1 = temp1.next;
//        }
//        return newHead.next;
//    }
    public static Node copyListRandomPointer(Node head){

        // Step 1---> Deep copy
        if(head == null){
            return null;
        }
        Node temp1 = head;
        Node newHead = new Node(0);
        Node temp2 = newHead;
        while(temp1!=null){
            Node t = new Node(temp1.data);
            temp2.next = t;
            temp2 = t;
            temp1 = temp1.next;
        }

        newHead = newHead.next;
        temp2 = newHead;
        temp1 = head;

        // Step2---> Alternate connections
        Node temp = new Node(0);
        while(temp1!=null){
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;


            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }
        temp2 = newHead;
        temp1 = head;

        // Step3---> Assigning random pointers
        while(temp1!=null) {
            if(temp1.random == null){
                if(temp2 == null){
                    break;
                }
                temp2.random = null;
            }
            else{
                temp2.random = temp1.random.next;
            }
            temp1 = temp2.next;
            if(temp1!=null){
                temp2 = temp1.next;
            }
        }
        temp2 = newHead;
        temp1 = head;

        // Step4---> Separating the list
        while(temp1!=null){
            temp1.next = temp2.next;
            temp1 = temp1.next;
            if(temp1==null){
                break;
            }
            temp2.next = temp1.next;
            if(temp2.next==null){
                break;
            }
            temp2 = temp2.next;
        }
        return newHead;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(10);
        Node c = new Node(99);
        Node d = new Node(101);
        Node e = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;


        a.random = null;
        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;

        display(a);
        Node p = copyListRandomPointer(a);
        display(p);
    }
}
