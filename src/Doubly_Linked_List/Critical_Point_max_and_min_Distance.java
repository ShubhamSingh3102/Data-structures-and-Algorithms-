package Doubly_Linked_List;

public class Critical_Point_max_and_min_Distance {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void criticalMaxAndMinDistance(Node head) {
        Node temp = head.next; // Start from second node
        int index = 1;

        int first = -1;           // First critical point index
        int last = -1;            // Last critical point index
        int prevCritical = -1;    // Previous critical point index
        int minDist = Integer.MAX_VALUE;

        while (temp != null && temp.next != null) {
            int prev = temp.prev.data;
            int curr = temp.data;
            int next = temp.next.data;

            if ((curr > prev && curr > next) || (curr < prev && curr < next)) {
                if (first == -1) {
                    first = index;
                } else {
                    minDist = Math.min(minDist, index - prevCritical);
                }
                prevCritical = index;
                last = index;
            }

            temp = temp.next;
            index++;
        }

        if (first == last) {
            System.out.println("min distance = -1");
            System.out.println("max distance = -1");
        } else {
            System.out.println("min distance = " + minDist);
            System.out.println("max distance = " + (last - first));
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(5);
        Node d = new Node(3);
        Node e = new Node(2);
        Node f = new Node(7);
        Node g = new Node(8);
        Node h = new Node(9);
        Node i = new Node(1);
        Node j = new Node(10);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;

        j.prev = i;
        i.prev = h;
        h.prev = g;
        g.prev = f;
        f.prev = e;
        e.prev = d;
        d.prev = c;
        c.prev = b;
        b.prev = a;
        a.prev = null;

        criticalMaxAndMinDistance(a);
    }
}
