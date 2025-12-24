package Queue;
import java.util.*;
public class LinkedList_Implementation_of_Queue {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    };
    public static class QueueLinkedList{
        Node head = null;
        Node tail = null;
        int size = 0;
        public void add(int data){
            Node temp = new Node(data);
            temp.data = data;
            if(head == null){
                head = temp;
                tail = temp;
            }
            else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }
        public int remove(){
            if(head == null){
                return -1;
            }
            else{
                int data = head.data;
                head = head.next;
                size--;
                return data;
            }
        }
        public int peek(){
            if(head == null){
                return -1;
            }
            else{
                return head.data;
            }
        }
        public void display(){
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }
        public boolean isEmpty(){
            if(head == null){
                return true;
            }
            else{
                return false;
            }
        }
        public boolean isFull(){
            if(tail == null){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();
        q.add(1);
        q.add(2);
        q.add(5);
        q.add(4);
        q.add(6);
        q.display();
        q.remove();
        q.display();
        System.out.println(q.size);
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
    }
}
