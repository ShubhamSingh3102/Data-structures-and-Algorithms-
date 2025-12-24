package Queue;
import java.util.*;
public class Linked_List_Implementation_of_Circular_Queue {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static class QueueCircularLinkedList {
        Node head = null;
        Node tail = null;
        int size = 0;

        public void add(int data) {
            Node temp = new Node(data);
            temp.data = data;
            if (head == null) {
                head = temp;
                tail = temp;
                tail.next = head; // circular link
            } else {
                tail.next = temp;
                tail = temp;
                tail.next = head;
            }
            size++;
        }

        public int remove() {
            if (head == null) {
                System.out.println("Queue is empty");
                return -1;
            }
            if (head == tail) {
                int data = head.data;
                head = null;
                tail = null;
                size--;
                return data;
            } else {
                int data = head.data;
                head = head.next;
                tail.next = head;
                size--;
                return data;
            }
        }

        public int peek() {
            if (head == null) {
                return -1;
            } else {
                return head.data;
            }
        }

        public void display() {
            if (head == null) {
                System.out.println("Queue is empty");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
                if (temp == head) {
                    break;
                }
            }
            System.out.println();
        }

        public boolean isEmpty() {
            if (head == null) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isFull() {
            if (tail == null) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        QueueCircularLinkedList q = new QueueCircularLinkedList();
        q.add(1);
        q.add(2);
        q.add(5);
        q.add(4);
        q.add(6);
        q.add(7);
        q.display();
        q.remove();
        q.display();
        System.out.println(q.size);
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
    }
}
