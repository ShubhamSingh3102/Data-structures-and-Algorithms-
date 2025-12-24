package Linked_List;
import java.util.*;
public class Add_two_numbers_in_Linked_lIst {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public Node addTwoLists(Node head1, Node head2) {

        Node t1 = head1;
        Node t2 = head2;

        Node dummyNode = new Node(-1);
        Node curr = dummyNode;

        int carry = 0;

        while (t1 != null || t2 != null) {

            int sum = carry;

            if (t1 != null) {
                sum += t1.data;
                t1 = t1.next;
            }

            if (t2 != null) {
                sum += t2.data;
                t2 = t2.next;
            }

            Node newNode = new Node(sum % 10);
            carry = sum / 10;

            curr.next = newNode;
            curr = curr.next;
        }

        // if the carry is left over....
        if (carry > 0) {
            curr.next = new Node(carry);
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        Add_two_numbers_in_Linked_lIst obj = new Add_two_numbers_in_Linked_lIst();

        // Creating List 1: 2 -> 4 -> 3  (represents 342)
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(3);

        // Creating List 2: 5 -> 6 -> 4  (represents 465)
        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(4);

        Node result = obj.addTwoLists(head1, head2);

        // Print the resulting linked list
        Node temp = result;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
