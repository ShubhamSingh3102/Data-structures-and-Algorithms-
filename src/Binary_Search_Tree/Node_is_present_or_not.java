package Binary_Search_Tree;
import java.util.*;
public class Node_is_present_or_not {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node isPresent(Node root, int val) {
        if (root == null || root.val == val)
            return root;

        if (val < root.val)
            return isPresent(root.left, val);

        return isPresent(root.right, val);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        Node a = new Node(2);
        Node b = new Node(6);
        root.left = a;
        root.right = b;

        Node c = new Node(1);
        Node d = new Node(3);
        a.left = c;
        a.right = d;

        Node e = new Node(5);
        Node f = new Node(7);
        b.left = e;
        b.right = f;

        Node node = isPresent(root, 5);
        if (node != null)
            System.out.println("Node found with value: " + node.val);
        else
            System.out.println("Node not found.");
    }
}
