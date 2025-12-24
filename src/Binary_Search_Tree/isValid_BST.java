package Binary_Search_Tree;
import java.util.*;
public class isValid_BST {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
    public static boolean isValidBST(Node root){
        return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean isValidBST(Node root,long minVal,long maxVal){
        if(root == null){
            return true;
        }
        if(root.val >= maxVal || root.val <= minVal){
            return false;
        }
        return isValidBST(root.left,minVal,root.val) && isValidBST(root.right,root.val,maxVal);
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

        boolean ans = isValidBST(root);
        System.out.println(ans);
    }
}
