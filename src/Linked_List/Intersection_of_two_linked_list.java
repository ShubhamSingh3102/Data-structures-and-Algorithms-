package Linked_List;

public class Intersection_of_two_linked_list {
    public static class Node{
        int data;
        Node next;
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
    public static Node getIntersectionNode(Node headA,Node headB){
        Node tempA = headA;
        Node tempB = headB;
        // first find length of both the linked list...
        int lengthA = 0;
        while(tempA!=null){
            lengthA++;
            tempA = tempA.next;
        }
        int lengthB = 0;
        while(tempB!=null){
            lengthB++;
            tempB = tempB.next;
        }
        tempA = headA;
        tempB = headB;

        if(lengthA > lengthB){
            int steps = lengthA - lengthB;
            for(int i=1;i<=steps;i++){
                tempA = tempA.next;
            }
        }
        else{
            int steps = lengthB - lengthA;
            for(int i=1;i<=steps;i++){
                tempB = tempB.next;
            }
        }
        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {
        Node a = new Node(87);
        Node b = new Node(100);
        Node c = new Node(13);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(12);
        Node g = new Node(10);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        display(a);

        Node a1 = new Node(90);
        Node b1 = new Node(9);
        Node c1 = new Node(5);
        Node d1 = new Node(12);
        Node e1 = new Node(10);
        a1.next = b1;
        b1.next = e;
        c1.next = d1;
        d1.next = e1;

        display(a1);

        System.out.println("Intersection of two linked list is :");
        Node q = getIntersectionNode(a,a1);
        System.out.println(q.data);
    }
}
