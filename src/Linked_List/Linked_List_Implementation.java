package Linked_List;
import java.util.*;
public class Linked_List_Implementation {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    // ye aapne me ek data structure hai...
    public static class linkedList {
        Node head = null;
        Node tail = null;
        int size = 0;

        void insertAtEnd(int data) {
            Node temp = new Node(data);
            if (head == null) { // for empty linked list
                head = temp;
            } else { // for non-empty linked list
                tail.next = temp;
            }
            tail = temp;
            size++;
        }

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

//        int size() { // 0(n)
//            Node temp = head;
//            int count = 0;
//            while (temp != null) {
//                count++;
//                temp = temp.next;
//            }
//            return count;
//        }

        void insertAtBeginning(int data) {
            Node temp = new Node(data);
            if (head == null) { // empty list
                head = temp;
                tail = temp;
//                insertAtEnd(data);
            } else { // non-empty list
                temp.next = head;
                head = temp;
            }
            size++;
        }

        void insertAtIndex(int index, int data) {
            Node temp = new Node(data);
            Node p = head;
            if(index == size){
                insertAtEnd(data);
                return;
            }
            if(index == 0){
                insertAtBeginning(data);
                return;
            }
            else if(index<0 || index>size){
                System.out.println("Wrong index");
                return;
            }
            for(int i=1;i<=index-1;i++){
                p = p.next;
            }
            temp.next = p.next;
            p.next = temp;
            size++;
        }

        int getElement(int index){
            Node temp = head;
            for(int i=1;i<=index;i++){
                temp = temp.next;
            }
            return temp.data;
        }


        // deletion of linked list

        void deleteAtIndex(int index) {
            if (index < 0) {
                System.out.println("Wrong index");
                return;
            } else if (index == 0) {
                Node temp = head;
                head = head.next;
                size--;
                return;
            }
            Node p = head;
            for (int i = 1; i <= index - 1; i++) {
                p = p.next;
            }
            p.next = p.next.next;

            if (index == size - 1) {
                tail = p;
            }
            size--;
        }
    }

    public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);
        ll.display();
        System.out.println();
//        int length = ll.size();
//        System.out.println("The size of the linked list is: " + length);
        ll.insertAtBeginning(2);
        ll.insertAtBeginning(3);
        ll.display();
        System.out.println();
        ll.insertAtIndex(4,30);
        ll.display();
        System.out.println();
//        System.out.println(ll.tail.data);
        ll.insertAtIndex(0,100);
        ll.display();
        System.out.println();
//        int element = ll.getElement(4);
//        System.out.println("Element is : " + element);
//        System.out.println(ll.size);

        ll.deleteAtIndex(0);
        ll.display();
//        System.out.println();
//        System.out.println(ll.tail.data);
    }
}
