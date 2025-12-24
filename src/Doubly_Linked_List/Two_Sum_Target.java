package Doubly_Linked_List;

public class Two_Sum_Target {
    public static class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data) {
            this.data = data;
        }
    }

    public static int twoSum(Node head, int target){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        Node h = head;
        Node t = temp;
        while(h.data < t.data){
            if(h.data + t.data == target){
                System.out.println(h.data+" + "+t.data + " = " + target);
                return 1;
            }
            else if(h.data + t.data > target){
                t = t.prev;
            }
            else{
                h = h.next;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(8);
        Node d = new Node(13);
        Node e = new Node(100);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        e.prev = d;
        d.prev = c;
        c.prev = b;
        b.prev = a;
        a.prev = null;

        int ans = twoSum(a,16);
        System.out.println(ans);
    }
}
