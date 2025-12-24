package Binary_Search_Tree;
import java.util.*;
public class kth_Smallest_element_in_BST {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static class KthSmallestInBST {
        // global variable...
        static int count = 0;
        static int result = -1;

        public static int kthSmallest(Node root, int k) {
            count = 0;
            result = -1;
            inOrder(root, k);
            return result;
        }

        private static void inOrder(Node node, int k) {
            if (node == null || result != -1) return;

            inOrder(node.left, k);

            // work...
            count++;
            if (count == k) {
                result = node.val;
                return;
            }

            inOrder(node.right, k);
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
            System.out.println("Kth smallest element is: " + kthSmallest(root, k));
        }
    }
}
