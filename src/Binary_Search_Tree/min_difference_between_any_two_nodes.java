package Binary_Search_Tree;
import java.util.*;
public class min_difference_between_any_two_nodes {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    private static int minDiff = Integer.MAX_VALUE;
    static Node prev = null;
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        if(prev!=null){
            int diff = Math.abs(root.val - prev.val);
            minDiff = Math.min(minDiff,diff);
        }
        prev = root;
        inOrder(root.right);
    }
    public static int minDiffInBST(Node root){
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inOrder(root);
        return minDiff;
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
        int n = minDiffInBST(root);
        System.out.println(n);
    }
}
