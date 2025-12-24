package Binary_Search_Tree;
import java.util.*;
public class kth_Largest_element_in_BST {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static class KthLargestInBST {
        // global variable...
        static int count = 0;
        static int result = -1;

        public static int kthLargest(Node root, int k) {
            count = 0;
            result = -1;
            reverseInOrder(root, k);
            return result;
        }

        private static void reverseInOrder(Node node, int k) {
            if (node == null || result != -1) return;

            reverseInOrder(node.right, k);

            count++;
            if (count == k) {
                result = node.val;
                return;
            }
            reverseInOrder(node.left, k);
        }

        public static void main(String[] args) {
            Node root = new Node(10);
            Node a = new Node(5);
            Node b = new Node(13);
            root.left = a;
            root.right = b;

            Node c = new Node(3);
            Node d = new Node(6);
            a.left = c;
            a.right = d;

            Node e = new Node(11);
            Node f = new Node(14);
            b.left = e;
            b.right = f;

            int k = 3;
            System.out.println("Kth largest element is: " + kthLargest(root, k));
        }
    }
}
