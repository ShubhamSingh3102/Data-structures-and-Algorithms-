package Binary_Search_Tree;
import java.util.*;
public class Morris_Traversal_Inorder {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static List<Integer> inOrderTraversal(Node root) {
        Node curr = root;
        List<Integer> arr = new ArrayList<>();
        while (curr != null) {
            // if curr.left exists krta hai...if exists krt hai then find predecessor...
            if (curr.left != null) { // curr.left exists krta hai....find predecessor....
                Node pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                // connect pred with curr....
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else { // if pred.right == curr.....
                    // unlink pred and curr....
                    pred.right = null;
                    arr.add(curr.val);
                    curr = curr.right;
                }
            }
            else{ // if curr.left == null,no pred...
                arr.add(curr.val);
                curr = curr.right;
            }
        }
        return arr;
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
        System.out.println(inOrderTraversal(root));
    }
}
